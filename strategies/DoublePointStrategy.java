package strategies;

import java.util.TreeSet;

import itemClasses.MovieNew;
import itemInterfaces.ItemInterface;

public class DoublePointStrategy implements RentalPointStrategy {

  public DoublePointStrategy() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public int calculateTotalPoint(TreeSet<ItemInterface> rentals) {
    int total = 0;
    for (ItemInterface m : rentals) {
      total += calculateFrequentRenterPoint(m);
    }
    return total * 2;
  }

  /**
   * Calculate point for a single movie.
   * 
   * @param m
   * @return
   */
  public int calculateFrequentRenterPoint(ItemInterface m) {
    int point = 1;

    // add bonus for a two day new release rental
    if ((m instanceof MovieNew) && (m.getDaysRented() > 1)) {
      point++;
    }
    return point;
  }
}
