package removeCodeSmell;

import genre.Genre;
import itemClasses.ItemDiscountDecorator;
import itemClasses.MovieChildren;
import itemClasses.MovieNew;
import itemClasses.MovieRegular;
import itemInterfaces.ItemInterface;
import order.Order;
import order.OrderDiscountDecorator;
import strategies.BuyStrategy;
import strategies.RentStrategy;
import toXML.OrderToXMLDecorator;

public class Main {

  public static void main(String[] args) {

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

    System.out.println("Applying 10% statement discount: ");
    // assign discounted/decorated transaction to customer
    customer.setRental(discountedOrder);

    System.out.println(customer.statement());
    System.out.println("The number of point changes because statement() was called twice for demonstration purpose.");

    // print in XML

    OrderToXMLDecorator xmlOrder = new OrderToXMLDecorator(discountedOrder);
    System.out.println();
    System.out.println(customer.toXML());
    System.out.println(xmlOrder.toXML());

  }

}
