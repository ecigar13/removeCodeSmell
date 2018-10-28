package order;

import java.util.TreeSet;

import itemInterfaces.ItemInterface;

public interface OrderInterface {
  public double calculateTotal();

  public TreeSet<ItemInterface> getRentals();

  public int calculateTotalPoint();

  public String toXML();
}
