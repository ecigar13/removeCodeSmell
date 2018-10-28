package customer;

import actions.CustomerOrder;
import itemInterfaces.ItemInterface;

public class Customer {
  private String name;
  private CustomerOrder rental;
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
  public void setRental(CustomerOrder arg) {
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
    result.append("Rental Record for " + getName() + "\n");
    result.append("You have " + frequentRenterPoints + " point" + "\n");
    double totalAmount = 0.0;

    for (ItemInterface m : rental.getRentals()) {
      double thisAmount = 0.0;
      thisAmount += m.calculateAmount();
      result.append(m.getTitle() + "\t" + String.format("%9.2f", thisAmount));
      result.append(m.getDaysRented() + "\n");
      // calculate amounts for each line
      totalAmount += thisAmount;
    }

    this.frequentRenterPoints += rental.calculateTotalPoint();

    // add footer lines
    result.append("Amount owed is " + String.format("%9.2f", totalAmount) + "\n");
    result.append("You earned " + String.valueOf(rental.calculateTotalPoint()) + " frequent renter points\n");
    result.append("You have " + frequentRenterPoints + " point" + "\n");
    return result.toString();
  }

  public String toXML() {
    return "<name>" + this.name + "</name>" + "<point>" + this.frequentRenterPoints + "</point>";
  }

}