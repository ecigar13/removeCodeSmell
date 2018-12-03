package itemClasses;

import genre.Genre;
import itemInterfaces.ItemInterface;
import strategies.ActivityStrategy;

public class ItemDiscountDecorator implements ItemInterface {
  protected ItemInterface item;
  protected double discountPercent = 0.0;

  /**
   * Only this needs to be implemented.
   */
  @Override
  public double calculateAmount() {
    return item.calculateAmount() * (100 - discountPercent) / 100;
  }

  public double getDiscountPercent() {
    return discountPercent;
  }

  public void setDiscountPercent(double discountPercent) {
    this.discountPercent = discountPercent;
  }

  public ItemDiscountDecorator(ItemInterface item) {
    this.item = item;
  }

  @Override
  public boolean isGenre(Genre genre) {
    return item.isGenre(genre);
  }

  @Override
  public String getTitle() {
    return item.getTitle();
  }

  @Override
  public void setStrategy(ActivityStrategy s) {
    item.setStrategy(s);

  }

  @Override
  public int compareTo(ItemInterface o) {
    return item.compareTo(o);
  }

  @Override
  public double getSellPrice() {
    return item.getSellPrice();
  }

  @Override
  public double getPricePerDay() {
    return item.getPricePerDay();
  }

  @Override
  public double getBasePrice() {
    return item.getBasePrice();
  }

  @Override
  public int getDaysRented() {
    return item.getDaysRented();
  }

  @Override
  public int getBaseDay() {
    return item.getBaseDay();
  }

}
