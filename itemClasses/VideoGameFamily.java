package itemClasses;

import genre.Genre;
import itemInterfaces.VideoGameAbstract;

public class VideoGameFamily extends VideoGameAbstract {

  public VideoGameFamily(String title, int daysRented, double sellPrice, Genre... genreList) {
    this.title = title;
    this.daysRented = daysRented;
    this.sellPrice = sellPrice;
    for (Genre g : genreList) {
      genres.add(g);
    }

    baseDay = 7;
    basePrice = 6.0;
    pricePerDay = 2.5;
  }

  @Override
  public double calculateAmount() {
    return strategy.calculateAmount(this);
  }

}
