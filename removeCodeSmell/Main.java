package removeCodeSmell;

import genre.Genre;
import itemClasses.ItemDiscountDecorator;
import itemClasses.MovieChildren;
import itemClasses.MovieNew;
import itemClasses.MovieRegular;
import itemClasses.MusicPop;
import itemInterfaces.ItemInterface;
import itemInterfaces.MovieAbtractClass;
import order.Order;
import order.OrderComposite;
import order.OrderDiscountDecorator;
import order.OrderToXMLDecorator;
import strategies.BuyStrategy;
import strategies.RentStrategy;

public class Main {

  public static void main(String[] args) {
    // use one of the two lines below
    strategyPattern();
    // strategyAndDecorator();
    // compositePattern();

  }

  public static void compositePattern() {
    // create customer
    Customer customer = new Customer("Thomas", 1);
    Order order = new Order();
    OrderComposite orderComposite = new OrderComposite();
    customer.setRental(orderComposite);

    ItemInterface item = new MovieNew("Starbucks Wars", 3, 20.0, Genre.HORROR, Genre.ROMANCE);
    item.setStrategy(new RentStrategy());
    ItemDiscountDecorator discountedItem = new ItemDiscountDecorator(item);
    discountedItem.setDiscountPercent(30.0);
    order.addItem(discountedItem);

    item = new MusicPop("Peter Pots and Pans", "Disney", 5, 2, 30.0, Genre.CHILREN);
    item.setStrategy(new BuyStrategy());
    discountedItem = new ItemDiscountDecorator(item);
    discountedItem.setDiscountPercent(5.0);
    order.addItem(item);

    item = new MovieRegular("Chronicles of Nah Nah", 4, 50.0, Genre.ROMANCE, Genre.NERD);
    item.setStrategy(new RentStrategy());
    discountedItem = new ItemDiscountDecorator(item);
    discountedItem.setDiscountPercent(10.0);
    order.addItem(item);

    orderComposite.addOrder(order);

    System.out.println("There are two orders in the composite object, so there should be six items and two totals.");
    OrderDiscountDecorator discountedOrder = new OrderDiscountDecorator(order);
    discountedOrder.setDiscountPercentage(20.0);
    orderComposite.addOrder(discountedOrder);

    System.out.println(orderComposite.toXML());
  }

  /**
   * Discount decorator and print as XML decorator.
   */
  public static void strategyAndDecorator() {
    // create customer
    Customer customer = new Customer("Thomas", 1);
    Order transaction = new Order();

    System.out.println("Applying item level discount: ");
    ItemInterface item = new MovieNew("Starbucks Wars", 3, 20.0, Genre.HORROR, Genre.ROMANCE);
    item.setStrategy(new RentStrategy());
    ItemDiscountDecorator discountedItem = new ItemDiscountDecorator(item);
    discountedItem.setDiscountPercent(30.0);
    transaction.addItem(discountedItem);

    item = new MusicPop("Peter Pots and Pans", "Disney", 5, 2, 30.0, Genre.CHILREN);
    item.setStrategy(new BuyStrategy());

    discountedItem = new ItemDiscountDecorator(item);
    discountedItem.setDiscountPercent(5.0);
    transaction.addItem(item);

    item = new MovieRegular("Chronicles of Nah Nah", 4, 50.0, Genre.ROMANCE, Genre.NERD);
    item.setStrategy(new RentStrategy());

    discountedItem = new ItemDiscountDecorator(item);
    discountedItem.setDiscountPercent(10.0);
    transaction.addItem(item);

    // assign transaction to customer
    customer.setRental(transaction);

    OrderDiscountDecorator discountedOrder = new OrderDiscountDecorator(transaction);
    discountedOrder.setDiscountPercentage(10.0);
    System.out.println(customer.statement());

    // assign discounted/decorated transaction to customer
    System.out.println("Applying 10% statement discount: ");
    customer.setRental(discountedOrder);

    System.out.println(customer.statement());
    System.out.println("The number of point changes because statement() was called twice for demonstration purpose.");

    // print in XML

    OrderToXMLDecorator xmlOrder = new OrderToXMLDecorator(discountedOrder);
    System.out.println();
    System.out.println(customer.toXML());
    System.out.println(xmlOrder.toXML());
  }

  public static void strategyPattern() {
    // create customer
    Customer customer = new Customer("Thomas", 1);
    // create rental
    Order rental = new Order(customer.getFreeItems());
    customer.setRental(rental);
    // create movie
    ItemInterface item = new MovieNew("Starbucks Wars", 3, 20.0, Genre.HORROR, Genre.ROMANCE);
    item.setStrategy(new RentStrategy());
    rental.addItem(item);

    item = new MovieNew("Steel Man - Infinity Wars", 3, 20.0, Genre.HORROR, Genre.ROMANCE);
    item.setStrategy(new RentStrategy());
    rental.addItem(item);

    item = new MovieChildren("Peter Pots and Pans", 5, 30.0, Genre.CHILREN);
    item.setStrategy(new BuyStrategy());
    rental.addItem(item);

    item = new MovieRegular("Chronicles of Nah Nah", 4, 10.0, Genre.ROMANCE, Genre.NERD);
    item.setStrategy(new RentStrategy());
    rental.addItem(item);

    item = new MovieRegular("Baywitch", 3, 23.3, Genre.ROMANCE, Genre.NERD);
    item.setStrategy(new RentStrategy());
    rental.addItem(item);

    for (ItemInterface i : rental.getItems()) {
      System.out.println(((MovieAbtractClass) i).getStrategy());
    }

    // print it
    System.out.println(customer.statement());
    System.out.println();
    System.out.println(customer.toXML());
    System.out.println();
    System.out.println(rental.toXML());

  }

}
