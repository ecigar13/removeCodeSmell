package itemInterfaces;

import java.util.HashSet;

import genre.Genre;
import strategies.StrategyInterface;

public interface ItemInterface extends Comparable<ItemInterface> {
  final HashSet<Genre> genres = new HashSet<Genre>();

  public boolean isGenre(Genre genre);

  public String getTitle();

  public double calculateAmount();

  public void setStrategy(StrategyInterface s);

  int compareTo(ItemInterface o);

  public double getSellPrice();

  public double getPricePerDay();

  public double getBasePrice();

  public int getDaysRented();

  public int getBaseDay();
}
