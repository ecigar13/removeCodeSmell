package order;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import itemInterfaces.ItemInterface;

public class OrderComposite implements OrderInterface {
  List<OrderInterface> orderList = new ArrayList<>();

  /**
   * Add orders to the composite class.
   * 
   * @param o
   */
  public void addOrder(OrderInterface o) {
    orderList.add(o);
  }

  public OrderComposite() {
  }

  @Override
  public double calculateTotal() {
    double total = 0;
    for (OrderInterface o : orderList) {
      total += o.calculateTotal();
    }
    return total;
  }

  @Override
  public int calculateTotalPoint() {
    int total = 0;
    for (OrderInterface o : orderList) {
      total += o.calculateTotal();
    }
    return total;
  }

  @Override
  public String toXML() {
    StringBuffer s = new StringBuffer();
    for (OrderInterface o : orderList) {
      s.append(o.toXML());
    }
    return s.toString();
  }

  /**
   * This is intended to return a set of movies without duplicates. This is not
   * intended to be used to get rental days.
   */
  @Override
  public TreeSet<ItemInterface> getRentals() {
    TreeSet<ItemInterface> s = new TreeSet<>();
    for (OrderInterface o : orderList) {
      s.addAll(o.getRentals());
    }
    return s;
  }

}
