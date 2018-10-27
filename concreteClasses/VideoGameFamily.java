package concreteClasses;

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
  }

  @Override
  public double calculateAmount() {
    // TODO Auto-generated method stub
    return 0;
  }

}
