package itemInterfaces;

import genre.Genre;
import strategies.StrategyInterface;

public abstract class MovieAbtractClass implements ItemInterface {
  protected int daysRented;
  protected double sellPrice;
  protected StrategyInterface strategy;
  protected String title;

  @Override
  public int compareTo(ItemInterface o) {
    return this.getTitle().compareTo(o.getTitle());
  }

  public int getDaysRented() {
    return this.daysRented;
  }

  public double getSellPrice() {
    return sellPrice;
  }

  public StrategyInterface getStrategy() {
    return strategy;
  }

  public String getTitle() {
    return this.title;
  }

  public boolean isGenre(Genre genre) {
    return genres.contains(genre);
  }

  public void setDaysRented(int daysRented) {
    this.daysRented = daysRented;
  }

  public void setSellPrice(double sellPrice) {
    this.sellPrice = sellPrice;
  }

  public void setStrategy(StrategyInterface strategy) {
    this.strategy = strategy;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
