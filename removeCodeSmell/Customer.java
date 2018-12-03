package removeCodeSmell;

import itemInterfaces.ItemInterface;
import order.OrderInterface;

public class Customer {
  private String name;
  private OrderInterface rental;
  private int frequentRenterPoints;
  private int freeItems = 0;

  public Customer(String name, int frequentRenterPoints) {
    this.name = name;
    this.frequentRenterPoints = frequentRenterPoints;
  }

  public Customer(String name, int frequentRenterPoints, int freeItems) {
    this.name = name;
    this.frequentRenterPoints = frequentRenterPoints;
    this.freeItems = freeItems;
  }

  /**
   * Set the transaction for the customer, allowing customer object to calculate
   * the amount of invoices.
   * 
   * @param arg
   */
  public void setRental(OrderInterface arg) {
    this.rental = arg;
  }

  public String getName() {
    return this.name;
  }

  public int getFreeItems() {
    return freeItems;
  }

  /**
   * Since movie rental is usually short, this just redo all calculations.
   * 
   * @return
   */
  public String statement() {
    StringBuffer result = new StringBuffer();
    result.append("Rental record for " + getName() + "\n");
    result.append("You have " + frequentRenterPoints + " point" + "\n");

    result.append("Items in cart: \n");
    for (ItemInterface m : rental.getItems()) {
      double thisAmount = 0.0;
      thisAmount += m.calculateAmount();
      result.append(String.format("%30s", m.getTitle()) + "\t\t" + String.format("%6.2f", thisAmount));
      result.append(m.getDaysRented() + "\n");
      // calculate amounts for each line
    }

    int pointEarned = rental.calculateTotalPoint();
    frequentRenterPoints += pointEarned;
    if (frequentRenterPoints > 10)
      freeItems += 1;

    // add footer lines
    result.append(
        String.format("%30s", "Amount owed is ") + "\t\t" + String.format("%6.2f", rental.calculateTotal()) + "\n");
    result.append("You earned " + pointEarned + " frequent renter points.\n");
    result.append("You have free rental " + freeItems + " items for next order.");
    return result.toString();
  }

  public String toXML() {
    return "<name>" + this.name + "</name>" + "<point>" + this.frequentRenterPoints + "</point>";
  }

}