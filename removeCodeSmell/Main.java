package removeCodeSmell;

import actions.Transaction;
import concreteClasses.MovieChildren;
import concreteClasses.MovieNew;
import concreteClasses.MovieRegular;
import customer.Customer;
import genre.Genre;

public class Main {

  public static void main(String[] args) {

    // create customer
    Customer customer = new Customer("Thomas", 1);
    // create rental
    Transaction rental = new Transaction();
    // create movie
    rental.addMovie(new MovieNew("Starbucks Wars", 3, 20.0, Genre.HORROR, Genre.ROMANCE));
    rental.addMovie(new MovieChildren("Peter Pot", 5, Genre.CHILREN));
    rental.addMovie(new MovieRegular("Chronicles of Nah Nah", 4, Genre.ROMANCE, Genre.ROMANCE));

    customer.setRental(rental);

    // print it
    System.out.println(customer.statement());
    System.out.println();
    System.out.println(customer.toXML());
    System.out.println(rental.toXML());

  }

}
