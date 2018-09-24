package actions;

import java.util.TreeSet;

import movies.*;

public class Rental {
  private TreeSet<Movie> rentals = new TreeSet<Movie>();
  private int frequentRenterPoint = 0;

  public int getFrequentRenterPoint() {
    return frequentRenterPoint;
  }

  public TreeSet<Movie> getRentals() {
    return rentals;
  }

  public boolean addMovie(Movie m) {
    return rentals.add(m);
  }

  /*
   * Calculate price based on the number of days.
   */
  public double calculateTotal() {
    double total = 0.0;
    for (Movie m : rentals) {
      total += m.calculateAmount();
    }
    return total;
  }

  public String toXML() {
    StringBuffer sBuffer = new StringBuffer();
    for (Movie movie : rentals) {
      sBuffer.append("<movie>" + movie.getTitle() + "</movie>" + "<daysRented>" + movie.getDaysRented() + "</daysRented>");
      sBuffer.append("<amount>" + String.format("%9.2f", movie.calculateAmount()) + "</amount>" + '\n');
    }
    
    sBuffer.append("<total>"  + String.format("%9.2f", calculateTotal()) + "</total>");
    return sBuffer.toString();
  }

  public int calculateTotalPoint() {
    int total=0;
    for (Movie m : rentals) {
      total += calculateFrequentRenterPoint(m);
    }
    return total;
  }
  
  public int calculateFrequentRenterPoint(Movie m) {
    int point = 1;

    // add bonus for a two day new release rental
    if ((m instanceof MovieNew) && (m.getDaysRented() > 1)) {
      point++;
    }
    return point;
  }
}