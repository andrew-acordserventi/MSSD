package edu.bu.met.cs665.facade3;

import edu.bu.met.cs665.facade3.orders.Order;

/**
 * Package delivery. In the real world, may have multiple sub-steps. Execute should
 * do these substeps, but instead, it just sets the flag to true for an order.
 */
public class PackageDelivery implements OrderProcessing{
  Order order;

  public PackageDelivery(Order order) {
    this.order = order;
  }

  // ideally this perform the task - for testing purposes, we just set the task to complete
  @Override
  public void execute() {
    order.setDelivered(true);
  }
}
