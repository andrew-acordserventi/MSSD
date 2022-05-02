package edu.bu.met.cs665.facade3;

/**
 * Facade pattern. Allows us to access all the sub commands through orderProcessing.
 */
public class OrderProcessor {

  public OrderProcessor() {
  }

  // accesses our list of steps through the orderprocessing interface; KEY COMPONENT
  public void execute(OrderProcessing orderProcessing) {
    orderProcessing.execute();
  }
}
