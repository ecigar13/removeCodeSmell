package concreteClasses;

import genre.Genre;
import itemInterfaces.ItemInterface;
import itemInterfaces.MovieAbtractClass;

public class MovieRegular extends MovieAbtractClass {

  private String title;
  private int daysRented = 0;

  public void setDaysRented(int daysRented) {
    this.daysRented = daysRented;
  }

  private double pricePerDay = 1.5;
  private double basePrice = 2.0;
  private int baseDay = 2;

  public MovieRegular(String title, int daysRented, Genre... genreList) {
    this.title = title;
    this.daysRented = daysRented;
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

  @Override
  public int compareTo(ItemInterface o) {
    // TODO Auto-generated method stub
    return 0;
  }


}
