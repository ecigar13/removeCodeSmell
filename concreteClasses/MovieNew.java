package concreteClasses;

import genre.Genre;
import itemInterfaces.MovieAbtractClass;

public class MovieNew extends MovieAbtractClass {
  private double pricePerDay = 3.0;
  protected double sellPrice;

  public MovieNew(String title, int daysRented, double sellPrice, Genre... genreList) {
    this.title = title;
    this.daysRented = daysRented;
    this.sellPrice = sellPrice;
    for (Genre g : genreList) {
      genres.add(g);
    }
  }

  @Override
  public double calculateAmount() {
    double thisAmount = this.daysRented * pricePerDay;
    return thisAmount;
  }

  public void setDaysRented(int daysRented) {
    this.daysRented = daysRented;
  }

}
