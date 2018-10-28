package toXML;

import java.util.TreeSet;

import itemInterfaces.ItemInterface;
import order.OrderInterface;

public class OrderToXMLDecorator implements OrderInterface {
  protected OrderInterface order;

  public OrderToXMLDecorator(OrderInterface order) {
    this.order = order;
  }

  @Override
  public double calculateTotal() {
    return order.calculateTotal();
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
    StringBuffer sBuffer = new StringBuffer();
    for (ItemInterface movie : order.getRentals()) {
      sBuffer
          .append("<movie>" + movie.getTitle() + "</movie>" + "<daysRented>" + movie.getDaysRented() + "</daysRented>");
      sBuffer.append("<amount>" + movie.calculateAmount() + "</amount>" + '\n');
    }

    sBuffer.append("<total>" + String.format("%.2f", calculateTotal()) + "</total>");
    return sBuffer.toString();
  }

}
