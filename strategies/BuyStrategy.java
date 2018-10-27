package strategies;

import itemInterfaces.ItemInterface;

public class BuyStrategy implements StrategyInterface {

  public BuyStrategy() {
  }

  @Override
  public double calculatePrice(ItemInterface i) {
    return i.getSellPrice();
  }

}
