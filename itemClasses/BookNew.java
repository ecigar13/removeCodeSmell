package itemClasses;

import genre.Genre;
import itemInterfaces.BookAbstractClass;

public class BookNew extends BookAbstractClass {

  public BookNew(String title, int numberAvailable, int daysRented, double sellPrice, Genre... genreList) {
    this.title = title;
    this.numberAvailable = numberAvailable;
    this.daysRented = daysRented;
    this.sellPrice = sellPrice;
    for (Genre g : genreList) {
      genres.add(g);
    }

    pricePerDay = 2.5;
    basePrice = 3.0;
    baseDay = 1;
  }

  /**
   * The fixed price for renting only one day is $3. After that, it is $2.5 for
   * each day.
   */
  public double calculateAmount() {
    return strategy.calculateAmount(this);
  }

}
