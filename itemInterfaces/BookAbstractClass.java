package itemInterfaces;

import genre.Genre;
import strategies.StrategyInterface;

public abstract class BookAbstractClass implements ItemInterface {
  protected String author;
  protected int daysRented;
  protected int numberAvailable;
  protected double sellPrice;
  protected StrategyInterface strategy;

  protected String title;

  @Override
  public int compareTo(ItemInterface o) {
    return this.getTitle().compareTo(o.getTitle());
  }

  public String getAuthor() {
    return author;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public int getNumberAvailable() {
    return numberAvailable;
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

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setDaysRented(int daysRented) {
    this.daysRented = daysRented;
  }

  public void setNumberAvailable(int numberAvailable) {
    this.numberAvailable = numberAvailable;
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
