package itemClasses;

import genre.Genre;
import itemInterfaces.MovieAbtractClass;

public class MovieRegular extends MovieAbtractClass {

  public MovieRegular(String title, int daysRented, double sellPrice, Genre... genreList) {
    this.title = title;
    this.daysRented = daysRented;
    this.sellPrice = sellPrice;
    for (Genre g : genreList) {
      genres.add(g);
    }

    baseDay = 3;
    basePrice = 2.0;
    pricePerDay = 1.5;

  }

  @Override
  public double calculateAmount() {
    return strategy.calculateAmount(this);
  }

  public void setDaysRented(int daysRented) {
    this.daysRented = daysRented;
  }

}
