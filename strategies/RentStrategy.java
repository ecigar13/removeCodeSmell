package strategies;

import itemInterfaces.ItemInterface;

public class RentStrategy implements StrategyInterface {

  public RentStrategy() {
  }

  @Override
  public double calculateAmount(ItemInterface i) {
    double thisAmount = i.getBasePrice();
    if (i.getDaysRented() > i.getBaseDay()) {
      thisAmount += (i.getDaysRented() - i.getBaseDay()) * i.getPricePerDay();
    }
    return thisAmount;
  }

}
