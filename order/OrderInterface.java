package order;

import itemInterfaces.ItemInterface;

public interface OrderInterface {
  public double calculateTotal();

  public ItemInterface getRentals();
}
