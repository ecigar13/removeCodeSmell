package concreteClasses;

import genre.Genre;
import itemInterfaces.ItemInterface;
import itemInterfaces.MovieAbtractClass;

public class MovieChildren extends MovieAbtractClass {

  private double pricePerDay = 1.5;
  private double basePrice = 3.0;
  private int baseDay = 3;

  public MovieChildren(String title, int daysRented, Genre... genreList) {
    this.title = title;
    this.daysRented = daysRented;
    for (Genre g : genreList) {
      genres.add(g);
    }
  }

  public void setDaysRented(int daysRented) {
    this.daysRented = daysRented;
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
