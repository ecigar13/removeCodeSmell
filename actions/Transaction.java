package actions;

import java.util.TreeSet;

import concreteClasses.*;
import itemInterfaces.MovieAbtractClass;

public class Transaction {
  private TreeSet<MovieAbtractClass> rentals = new TreeSet<MovieAbtractClass>();
  private int frequentRenterPoint = 0;

  public int getFrequentRenterPoint() {
    return frequentRenterPoint;
  }

  public TreeSet<MovieAbtractClass> getRentals() {
    return rentals;
  }

  public boolean addMovie(MovieAbtractClass m) {
    return rentals.add(m);
  }

  /*
   * Calculate price based on the number of days.
   */
  public double calculateTotal() {
    double total = 0.0;
    for (MovieAbtractClass m : rentals) {
      total += m.calculateAmount();
    }
    return total;
  }

  public String toXML() {
    StringBuffer sBuffer = new StringBuffer();
    for (MovieAbtractClass movie : rentals) {
      sBuffer.append("<movie>" + movie.getTitle() + "</movie>" + "<daysRented>" + movie.getDaysRented() + "</daysRented>");
      sBuffer.append("<amount>" + String.format("%9.2f", movie.calculateAmount()) + "</amount>" + '\n');
    }
    
    sBuffer.append("<total>"  + String.format("%9.2f", calculateTotal()) + "</total>");
    return sBuffer.toString();
  }

  public int calculateTotalPoint() {
    int total=0;
    for (MovieAbtractClass m : rentals) {
      total += calculateFrequentRenterPoint(m);
    }
    return total;
  }
  
  public int calculateFrequentRenterPoint(MovieAbtractClass m) {
    int point = 1;

    // add bonus for a two day new release rental
    if ((m instanceof MovieNew) && (m.getDaysRented() > 1)) {
      point++;
    }
    return point;
  }
}