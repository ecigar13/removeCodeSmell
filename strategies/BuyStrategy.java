package strategies;

import itemInterfaces.ItemInterface;

public class BuyStrategy implements StrategyInterface {

  public BuyStrategy() {
  }

  @Override
  public double calculateAmount(ItemInterface i) {
    return i.getSellPrice();
  }

}
