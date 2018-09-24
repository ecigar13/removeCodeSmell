package movies;

public class MovieChildren implements Movie, Comparable<Movie> {

  private String title;
  private int daysRented = 0;

  private double pricePerDay = 1.5;
  private double basePrice = 3.0;
  private int baseDay = 3;

  public MovieChildren(String title, int daysRented, Genre... genreList) {
    this.title = title;
    this.daysRented = daysRented;
    for(Genre g: genreList) {
      genres.add(g);
    }
  }

  public void setDaysRented(int daysRented) {
    this.daysRented = daysRented;
  }

  @Override
  public String getTitle() {
    return this.title;
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
  public boolean isGenre(Genre genre) {
    return genres.contains(genre);
  }

  @Override
  public int getDaysRented() {
    return this.daysRented;
  }

  @Override
  public int compareTo(Movie o) {
    return this.getTitle().compareTo(o.getTitle());
  }

}
