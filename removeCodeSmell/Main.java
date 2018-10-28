package removeCodeSmell;

import actions.CustomerOrder;
import concreteClasses.MovieChildren;
import concreteClasses.MovieNew;
import concreteClasses.MovieRegular;
import customer.Customer;
import genre.Genre;
import itemInterfaces.ItemInterface;
import strategies.BuyStrategy;
import strategies.RentStrategy;

public class Main {

  public static void main(String[] args) {

    // create customer
    Customer customer = new Customer("Thomas", 1);
    // create rental
    CustomerOrder transaction = new CustomerOrder();
    customer.setRental(transaction);
    // create movie
    ItemInterface item = new MovieNew("Starbucks Wars", 3, 20.0, Genre.HORROR, Genre.ROMANCE);
    item.setStrategy(new RentStrategy());
    transaction.addItem(item);

    item = new MovieChildren("Peter Pot", 5, 30.0, Genre.CHILREN);
    item.setStrategy(new BuyStrategy());
    transaction.addItem(item);

    item = new MovieRegular("Chronicles of Nah Nah", 4, 50.0, Genre.ROMANCE, Genre.NERD);
    item.setStrategy(new RentStrategy());
    transaction.addItem(item);


    // print it
    System.out.println(customer.statement());
    System.out.println();
    System.out.println(customer.toXML());
    System.out.println(transaction.toXML());

  }

}
