package edu.bu.met.cs665.facade3.orders;

/**
 * Order object. Order has an orderID and the flags to show where in processing it is.
 */
public class Order {
  private int orderID;
  private boolean isDelivered = false;
  private boolean isPickup = false;
  private boolean isPackaged = false;

  public Order(int orderID) {
    this.setOrderID(orderID);
  }

  public int getOrderID() {
    return orderID;
  }

  public void setOrderID(int orderID) {
    this.orderID = orderID;
  }

  public boolean isDelivered() {
    return isDelivered;
  }

  public void setDelivered(boolean delivered) {
    isDelivered = delivered;
  }

  public boolean isPickup() {
    return isPickup;
  }

  public void setPickup(boolean pickup) {
    isPickup = pickup;
  }

  public boolean isPackaged() {
    return isPackaged;
  }

  public void setPackaged(boolean packaged) {
    isPackaged = packaged;
  }
}
