package order;

import java.util.TreeSet;

import itemClasses.*;
import itemInterfaces.ItemInterface;

public class Order implements OrderInterface {
  private TreeSet<ItemInterface> rentals = new TreeSet<ItemInterface>();
  private int frequentRenterPoint = 0;

  public int getFrequentRenterPoint() {
    return frequentRenterPoint;
  }

  public TreeSet<ItemInterface> getRentals() {
    return rentals;
  }

  public boolean addItem(ItemInterface m) {
    return rentals.add(m);
  }

  /**
   * Calculate price based on the number of days.
   */
  public double calculateTotal() {
    double total = 0.0;
    for (ItemInterface m : rentals) {
      total += m.calculateAmount();
    }
    return total;
  }

  public String toXML() {
    StringBuffer sBuffer = new StringBuffer();
    for (ItemInterface movie : rentals) {
      sBuffer
          .append("<movie>" + movie.getTitle() + "</movie>" + "<daysRented>" + movie.getDaysRented() + "</daysRented>");
      sBuffer.append("<amount>" + movie.calculateAmount() + "</amount>" + '\n');
    }

    sBuffer.append("<total>" + calculateTotal() + "</total>");
    return sBuffer.toString();
  }

  public int calculateTotalPoint() {
    int total = 0;
    for (ItemInterface m : rentals) {
      total += calculateFrequentRenterPoint(m);
    }
    return total;
  }

  public int calculateFrequentRenterPoint(ItemInterface m) {
    int point = 1;

    // add bonus for a two day new release rental
    if ((m instanceof MovieNew) && (m.getDaysRented() > 1)) {
      point++;
    }
    return point;
  }
}