package movies;

import java.util.HashSet;

public interface Movie {

  final HashSet<Genre> genres = new HashSet<Genre>();
  
  public boolean isGenre(Genre genre);
  
  public String getTitle();
  
  public int getDaysRented();

  public double calculateAmount();
}
