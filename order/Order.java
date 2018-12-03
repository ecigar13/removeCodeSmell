package order;

import java.util.TreeSet;
import itemClasses.*;
import itemInterfaces.ItemInterface;
import strategies.DefaultPointStrategy;
import strategies.DoublePointStrategy;
import strategies.RentalPointStrategy;

public class Order implements OrderInterface {
  private int frequentRenterPoint;
  private int freeItems = 0;
  private RentalPointStrategy pointStrategy = new DefaultPointStrategy();
  private TreeSet<ItemInterface> rentals;

  public Order() {
    rentals = new TreeSet<>();
    frequentRenterPoint = 0;
  }

  public Order(int freeItems) {
    this.freeItems = freeItems;
    this.rentals = new TreeSet<>();
    this.frequentRenterPoint = 0;
  }

  /**
   * Implement HWK 5
   * 
   * @param m
   * @return
   */
  public boolean addItem(ItemInterface m) {
    boolean diffCategory = false;
    if (rentals.size() != 0 && !rentals.getClass().isAssignableFrom(m.getClass().getSuperclass()))
      diffCategory = true;

    if (m instanceof MovieNew || m instanceof BookNew || diffCategory) {
      pointStrategy = new DoublePointStrategy();
    }
    return rentals.add(m);
  }

  public void setFreeItems(int freeItems) {
    this.freeItems = freeItems;
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

  public int calculateTotalPoint() {
    return pointStrategy.calculateTotalPoint(rentals);
  }

  public int getFrequentRenterPoint() {
    return frequentRenterPoint;
  }

  public TreeSet<ItemInterface> getItems() {
    return rentals;
  }

  public String toXML() {
    StringBuffer sBuffer = new StringBuffer();
    for (ItemInterface movie : rentals) {
      sBuffer
          .append("<movie>" + movie.getTitle() + "</movie>" + "<daysRented>" + movie.getDaysRented() + "</daysRented>");
      sBuffer.append("<amount>" + movie.calculateAmount() + "</amount>" + '\n');
    }

    frequentRenterPoint = pointStrategy.calculateTotalPoint(rentals);
    sBuffer.append("<point>" + frequentRenterPoint + "</point>");
    sBuffer.append("<total>" + calculateTotal() + "</total>");
    return sBuffer.toString();
  }
}