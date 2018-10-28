package itemClasses;

import genre.Genre;
import itemInterfaces.ItemInterface;
import itemInterfaces.MovieAbtractClass;

public class MovieChildren extends MovieAbtractClass {

  public MovieChildren(String title, int daysRented, double sellPrice, Genre... genreList) {
    this.title = title;
    this.daysRented = daysRented;
    this.sellPrice = sellPrice;
    for (Genre g : genreList) {
      genres.add(g);
    }
    baseDay = 3;
    basePrice = 3.0;
    pricePerDay = 1.5;
  }

  @Override
  public double calculateAmount() {
    return strategy.calculateAmount(this);
  }

}
