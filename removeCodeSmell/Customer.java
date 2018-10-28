package removeCodeSmell;

import itemInterfaces.ItemInterface;
import order.Order;
import order.OrderInterface;

public class Customer {
  private String name;
  private OrderInterface rental;
  private int frequentRenterPoints;

  public Customer(String name, int frequentRenterPoints) {
    this.name = name;
    this.frequentRenterPoints = frequentRenterPoints;
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

  /**
   * Since movie rental is usually short, this just redo all calculations.
   * 
   * @return
   */
  public String statement() {
    StringBuffer result = new StringBuffer();
    result.append("Rental record for " + getName() + "\n");
    result.append("You have " + frequentRenterPoints + " point" + "\n");
    double totalAmount = 0.0;

    result.append("Items in cart: \n");
    for (ItemInterface m : rental.getRentals()) {
      double thisAmount = 0.0;
      thisAmount += m.calculateAmount();
      result.append(String.format("%30s", m.getTitle()) + "\t\t" + String.format("%6.2f", thisAmount));
      result.append(m.getDaysRented() + "\n");
      // calculate amounts for each line
      totalAmount += thisAmount;
    }

    this.frequentRenterPoints += rental.calculateTotalPoint();

    // add footer lines
    result.append(String.format("%30s", "Amount owed is ") + "\t\t" + String.format("%6.2f", totalAmount) + "\n");
    result.append("You earned " + String.valueOf(rental.calculateTotalPoint()) + " frequent renter points.\n");
    result.append("You have " + frequentRenterPoints + " point(s)." + "\n");
    return result.toString();
  }

  public String toXML() {
    return "<name>" + this.name + "</name>" + "<point>" + this.frequentRenterPoints + "</point>";
  }

}