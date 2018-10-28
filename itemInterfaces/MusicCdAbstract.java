package itemInterfaces;

import genre.Genre;
import strategies.StrategyInterface;

public abstract class MusicCdAbstract implements ItemInterface {
  protected String artist;
  protected int baseDay;
  protected double basePrice;
  protected int daysRented;
  protected int numberAvailable;
  protected double popularityFactor;
  protected double pricePerDay;
  protected double sellPrice;
  protected StrategyInterface strategy;

  protected String title;

  @Override
  public int compareTo(ItemInterface o) {
    return this.getTitle().compareTo(o.getTitle());
  }

  public String getArtist() {
    return artist;
  }

  public int getBaseDay() {
    return baseDay;
  }

  public double getBasePrice() {
    return basePrice;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public int getNumberAvailable() {
    return numberAvailable;
  }

  public double getPopularityFactor() {
    return popularityFactor;
  }

  public double getPricePerDay() {
    return pricePerDay;
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

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public void setDaysRented(int daysRented) {
    this.daysRented = daysRented;
  }

  public void setNumberAvailable(int numberAvailable) {
    this.numberAvailable = numberAvailable;
  }

  public void setPopularityFactor(double popularityFactor) {
    this.popularityFactor = popularityFactor;
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
