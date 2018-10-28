package order;

import java.util.TreeSet;

import itemInterfaces.ItemInterface;

public class OrderDiscountDecorator implements OrderInterface {
  protected OrderInterface order;
  protected double discountPercentage = 0.0;

  public double getDiscountPercentage() {
    return discountPercentage;
  }

  public void setDiscountPercentage(double discountPercentage) {
    this.discountPercentage = discountPercentage;
  }

  public OrderDiscountDecorator(OrderInterface order) {
    this.order = order;
  }

  /**
   * Apply discount on entire order.
   */
  @Override
  public double calculateTotal() {
    return order.calculateTotal() * (100 - discountPercentage) / 100;
  }

  @Override
  public TreeSet<ItemInterface> getRentals() {
    return order.getRentals();
  }

  @Override
  public int calculateTotalPoint() {
    return order.calculateTotalPoint();
  }

  @Override
  public String toXML() {
    return order.toXML();
  }

}
