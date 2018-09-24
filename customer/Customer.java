package customer;

import actions.Rental;
import movies.*;

public class Customer {
  private String name;
  private Rental rental;
  private int frequentRenterPoints;

  public Customer(String name, int frequentRenterPoints) {
    this.name = name;
    this.frequentRenterPoints = frequentRenterPoints;
  }

  public void setRental(Rental arg) {
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
    String result = "Rental Record for " + getName() + "\n";
    result += "You have " + frequentRenterPoints +" point"+ "\n";
    double totalAmount = 0.0;
    
    for(Movie m : rental.getRentals()) {
      double thisAmount = 0.0;
      thisAmount += m.calculateAmount(); 
      result += "\t" + m.getTitle() + "\t" + String.format("%9.2f", thisAmount);
      result += "\t" + m.getDaysRented()+ "\n";
      // calculate amounts for each line
      totalAmount += thisAmount;
    }
      
    this.frequentRenterPoints += rental.calculateTotalPoint();

    // add footer lines
    result += "Amount owed is " + String.format("%9.2f", totalAmount) + "\n";
    result += "You earned " + String.valueOf(rental.calculateTotalPoint()) + " frequent renter points\n";
    result += "You have " + frequentRenterPoints +" point"+ "\n";
    return result;
  }
  
  public String toXML() {
    return "<name>" + this.name + "</name>" + "<point>" + this.frequentRenterPoints + "</point>";
  }

  
}