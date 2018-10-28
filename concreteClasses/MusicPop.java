package concreteClasses;

import genre.Genre;
import itemInterfaces.MusicCdAbstract;

public class MusicPop extends MusicCdAbstract {

  public MusicPop(String title, String artist, int daysRented, int numberAvailable, double sellPrice,
      Genre... genreList) {
    this.title = title;
    this.artist = artist;
    this.daysRented = daysRented;
    this.numberAvailable = numberAvailable;
    this.popularityFactor = 1.5;
    this.sellPrice = sellPrice;
    for (Genre g : genreList) {
      genres.add(g);
    }

    baseDay = 2;
    basePrice = 2.0;
    pricePerDay = 1.5;
  }

  @Override
  public double calculateAmount() {
    return strategy.calculateAmount(this);
  }

}
