package itemInterfaces;

import java.util.HashSet;

import genre.Genre;
import strategies.StrategyInterface;

public interface ItemInterface {
  final HashSet<Genre> genres = new HashSet<Genre>();

  public boolean isGenre(Genre genre);

  public String getTitle();

  public double calculateAmount();
  
  public void setStrategy(StrategyInterface s);

  int compareTo(MovieAbtractClass o);

}
