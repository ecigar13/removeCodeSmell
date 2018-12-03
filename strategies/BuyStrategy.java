package strategies;

import itemInterfaces.ItemInterface;

public class BuyStrategy implements ActivityStrategy {

  public BuyStrategy() {
  }

  @Override
  public double calculateAmount(ItemInterface i) {
    return i.getSellPrice();
  }

}
