package itemClasses;

import genre.Genre;
import itemInterfaces.MovieAbtractClass;

public class MovieNew extends MovieAbtractClass {

  public MovieNew(String title, int daysRented, double sellPrice, Genre... genreList) {
    this.title = title;
    this.daysRented = daysRented;
    this.sellPrice = sellPrice;
    for (Genre g : genreList) {
      genres.add(g);
    }
    baseDay = 1;
    basePrice = 3.0;

    pricePerDay = 3.0;

  }

  @Override
  public double calculateAmount() {
    return strategy.calculateAmount(this);
  }

  public void setDaysRented(int daysRented) {
    this.daysRented = daysRented;
  }

}
