package order;

import java.util.TreeSet;

import itemInterfaces.ItemInterface;

/**
 * A decorator class to apply discount to entire order.
 * 
 * @author khoa
 *
 */
public class OrderDiscountDecorator implements OrderInterface {
  protected OrderInterface order;
  protected double discountPercentage = 0.0;

  /**
   * Apply discount on entire order.
   */
  @Override
  public double calculateTotal() {
    return order.calculateTotal() * (100 - discountPercentage) / 100;
  }

  @Override
  public String toXML() {
    return order.toXML();
  }

  public double getDiscountPercentage() {
    return discountPercentage;
  }

  public void setDiscountPercentage(double discountPercentage) {
    this.discountPercentage = discountPercentage;
  }

  public OrderDiscountDecorator(OrderInterface order) {
    this.order = order;
  }

  @Override
  public int calculateTotalPoint() {
    return order.calculateTotalPoint();

  }

  @Override
  public TreeSet<ItemInterface> getItems() {
    return order.getItems();
  }

}
