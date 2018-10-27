package itemInterfaces;

import genre.Genre;
import strategies.StrategyInterface;

public abstract class VideoGameAbstract implements ItemInterface {
  protected String title;
  protected int daysRented;
  protected StrategyInterface strategy;
  protected double sellPrice;

  public StrategyInterface getStrategy() {
    return strategy;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDaysRented(int daysRented) {
    this.daysRented = daysRented;
  }

  public void setSellPrice(double sellPrice) {
    this.sellPrice = sellPrice;
  }

  public double getSellPrice() {
    return sellPrice;
  }

  public void setStrategy(StrategyInterface strategy) {
    this.strategy = strategy;
  }

  @Override
  public int compareTo(ItemInterface o) {
    return this.getTitle().compareTo(o.getTitle());
  }

  public boolean isGenre(Genre genre) {
    return genres.contains(genre);
  }

  public String getTitle() {
    return this.title;
  }

  public int getDaysRented() {
    return this.daysRented;
  }

}
