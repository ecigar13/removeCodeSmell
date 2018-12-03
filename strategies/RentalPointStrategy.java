package strategies;

import java.util.TreeSet;

import itemInterfaces.ItemInterface;

public interface RentalPointStrategy {
  public int calculateTotalPoint(TreeSet<ItemInterface> rentals);

}
