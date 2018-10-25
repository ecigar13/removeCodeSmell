package concreteClasses;

import genre.Genre;
import itemInterfaces.MovieAbtractClass;

public class MovieNew implements MovieAbtractClass, Comparable<MovieAbtractClass> {

  private String title;
  private int daysRented = 0;
  public void setDaysRented(int daysRented) {
    this.daysRented = daysRented;
  }

  private double pricePerDay = 3.0;

  public MovieNew(String title, int daysRented, Genre... genreList) {
    this.title = title;
    this.daysRented = daysRented;
    for (Genre g : genreList) {
      genres.add(g);
    }
  }

  @Override
  public String getTitle() {
    return this.title;
  }

  @Override
  public double calculateAmount() {
    double thisAmount = this.daysRented * pricePerDay;
    return thisAmount;
  }

  @Override
  public boolean isGenre(Genre genre) {
    return genres.contains(genre);
  }

  @Override
  public int getDaysRented() {
    return this.daysRented;
  }

  @Override
  public int compareTo(MovieAbtractClass o) {
    return this.getTitle().compareTo(o.getTitle());
  }
}
