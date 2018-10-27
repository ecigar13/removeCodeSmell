package concreteClasses;

import genre.Genre;
import itemInterfaces.ItemInterface;
import itemInterfaces.MovieAbtractClass;

public class MovieChildren extends MovieAbtractClass {
  private int baseDay = 3;
  private double basePrice = 3.0;
  private double pricePerDay = 1.5;
  protected double sellPrice;

  public MovieChildren(String title, int daysRented, double sellPrice, Genre... genreList) {
    this.title = title;
    this.daysRented = daysRented;
    this.sellPrice = sellPrice;
    for (Genre g : genreList) {
      genres.add(g);
    }
  }

  @Override
  public double calculateAmount() {
    double thisAmount = basePrice;
    if (this.daysRented > baseDay) {
      thisAmount += (this.daysRented - baseDay) * pricePerDay;
    }
    return thisAmount;
  }

}
