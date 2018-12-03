package itemInterfaces;

import genre.Genre;
import strategies.ActivityStrategy;

public abstract class VideoGameAbstract implements ItemInterface {
  protected int baseDay;
  protected double basePrice;
  protected int daysRented;
  protected double pricePerDay;
  protected double sellPrice;
  protected ActivityStrategy strategy;

  protected String title;

  @Override
  public int compareTo(ItemInterface o) {
    return this.getTitle().compareTo(o.getTitle());
  }

  public int getBaseDay() {
    return baseDay;
  }

  public double getBasePrice() {
    return basePrice;
  }

  public int getDaysRented() {
    return this.daysRented;
  }

  public double getPricePerDay() {
    return pricePerDay;
  }

  public double getSellPrice() {
    return sellPrice;
  }

  public ActivityStrategy getStrategy() {
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

  public void setStrategy(ActivityStrategy strategy) {
    this.strategy = strategy;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
