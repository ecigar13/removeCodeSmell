package concreteClasses;

import genre.Genre;
import itemInterfaces.MovieAbtractClass;

public class MovieRegular extends MovieAbtractClass {

  private int baseDay = 2;
  private double basePrice = 2.0;
  private double pricePerDay = 1.5;
  protected double sellPrice;

  public MovieRegular(String title, int daysRented, double sellPrice, Genre... genreList) {
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

  public void setDaysRented(int daysRented) {
    this.daysRented = daysRented;
  }

}
