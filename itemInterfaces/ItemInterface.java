package itemInterfaces;

import java.util.HashSet;

import genre.Genre;
import strategies.StrategyInterface;

public interface ItemInterface extends Comparable<ItemInterface> {
  final HashSet<Genre> genres = new HashSet<Genre>();

  public double calculateAmount();

  int compareTo(ItemInterface o);

  public int getBaseDay();

  public double getBasePrice();

  public int getDaysRented();

  public double getPricePerDay();

  public double getSellPrice();

  public String getTitle();

  public boolean isGenre(Genre genre);

  public void setStrategy(StrategyInterface s);
}
