package edu.bu.met.cs665.facade3;

import edu.bu.met.cs665.facade3.orders.Order;

/**
 * Packages a product. In the real world, may have multiple sub-steps. Execute should
 * do these substeps, but instead, it just sets the flag to true for an order.
 */
public class ProductPackaging implements OrderProcessing{
  Order order;

  public ProductPackaging(Order order) {
    this.order = order;
  }

  // ideally this perform the task - for testing purposes, we just set the task to complete
  @Override
  public void execute() {
    order.setPackaged(true);
  }
}
