package concreteClasses;

import genre.Genre;
import itemInterfaces.BookAbstractClass;

public class BookNew extends BookAbstractClass {
  protected double pricePerDay = 2.5;
  protected double basePrice = 3.0;
  protected int baseDay = 1;
  protected double sellPrice;

  public BookNew(String title, int numberAvailable, int daysRented, double sellPrice, Genre... genreList) {
    this.title = title;
    this.numberAvailable = numberAvailable;
    this.daysRented = daysRented;
    this.sellPrice = sellPrice;
    for (Genre g : genreList) {
      genres.add(g);
    }
  }

  /**
   * The fixed price for renting only one day is $3. After that, it is $2.5 for
   * each day.
   */
  public double calculateAmount() {
    double thisAmount = basePrice;
    if (this.daysRented > baseDay) {
      thisAmount += (this.daysRented - baseDay) * pricePerDay;
    }
    return thisAmount;
  }

}
