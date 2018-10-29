package removeCodeSmell;

import genre.Genre;
import itemClasses.ItemDiscountDecorator;
import itemClasses.MovieChildren;
import itemClasses.MovieNew;
import itemClasses.MovieRegular;
import itemInterfaces.ItemInterface;
import order.Order;
import order.OrderComposite;
import order.OrderDiscountDecorator;
import order.OrderInterface;
import order.OrderToXMLDecorator;
import strategies.BuyStrategy;
import strategies.RentStrategy;

public class Main {

  public static void main(String[] args) {
    // use one of the two lines below
    // originalCode();
    strategyAndDecorator();
    // compositePattern();

  }

  public static void compositePattern() {
    // create customer
    Customer customer = new Customer("Thomas", 1);
    Order transaction = new Order();
    OrderComposite orderComposite = new OrderComposite();
    customer.setRental(orderComposite);

    System.out.println("Applying item level discount: ");
    ItemInterface item = new MovieNew("Starbucks Wars", 3, 20.0, Genre.HORROR, Genre.ROMANCE);
    item.setStrategy(new RentStrategy());
    ItemDiscountDecorator discountedItem = new ItemDiscountDecorator(item);
    discountedItem.setDiscountPercent(30.0);
    transaction.addItem(discountedItem);

    item = new MovieChildren("Peter Pots and Pans", 5, 30.0, Genre.CHILREN);
    item.setStrategy(new BuyStrategy());
    discountedItem = new ItemDiscountDecorator(item);
    discountedItem.setDiscountPercent(5.0);
    transaction.addItem(item);

    item = new MovieRegular("Chronicles of Nah Nah", 4, 50.0, Genre.ROMANCE, Genre.NERD);
    item.setStrategy(new RentStrategy());
    discountedItem = new ItemDiscountDecorator(item);
    discountedItem.setDiscountPercent(10.0);
    transaction.addItem(item);

    orderComposite.addOrder(transaction);
    // assign transaction to customer

    OrderDiscountDecorator discountedOrder = new OrderDiscountDecorator(transaction);
    discountedOrder.setDiscountPercentage(10.0);
    System.out.println(customer.statement());

    orderComposite.addOrder(discountedOrder);

    // assign discounted/decorated transaction to customer
    System.out.println("Applying 10% statement discount: ");
    System.out.println(customer.statement());

    System.out.println("The number of point changes because statement() was called twice for demonstration purpose.");

    // assign discounted/decorated transaction to customer
    System.out.println("Applying 10% statement discount: ");
    customer.setRental(discountedOrder);
    System.out.println(customer.statement());
    // print in XML

    OrderToXMLDecorator xmlOrder = new OrderToXMLDecorator(discountedOrder);
    System.out.println();
    System.out.println(customer.toXML());
    System.out.println(xmlOrder.toXML());

  }

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

    item = new MovieChildren("Peter Pots and Pans", 5, 30.0, Genre.CHILREN);
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

  public static void originalCode() {
    // create customer
    Customer customer = new Customer("Thomas", 1);
    // create rental
    Order rental = new Order();
    // create movie
    rental.addItem(new MovieNew("Starbucks Wars", 3, 20.0, Genre.HORROR, Genre.ROMANCE));
    rental.addItem(new MovieChildren("Peter Pots and Pans", 5, 30.0, Genre.CHILREN));
    rental.addItem(new MovieRegular("Chronicles of Nah Nah", 4, 50.0, Genre.ROMANCE, Genre.NERD));

    customer.setRental(rental);

    // print it
    System.out.println(customer.statement());
    System.out.println();
    System.out.println(customer.toXML());
    System.out.println(rental.toXML());

  }

}
