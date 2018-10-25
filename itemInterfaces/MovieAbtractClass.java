package itemInterfaces;

import genre.Genre;
import strategies.StrategyInterface;

public abstract class MovieAbtractClass implements ItemInterface, Comparable<ItemInterface> {
  protected int daysRented;
  protected StrategyInterface strategy;
  protected String title;

  public int getDaysRented() {
    return this.daysRented;
  }

  public void setStrategy(StrategyInterface strategy) {
    this.strategy = strategy;
  }

  @Override
  public int compareTo(MovieAbtractClass o) {
    return this.getTitle().compareTo(o.getTitle());
  }

  public boolean isGenre(Genre genre) {
    return genres.contains(genre);
  }

  public String getTitle() {
    return this.title;
  }

}
