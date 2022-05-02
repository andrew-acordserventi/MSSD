package edu.bu.met.cs665.command2.orderProcessing;

import edu.bu.met.cs665.customer.Customer;

/**
 * executes or undos a customer's background check; real world, this would execute the task AND
 * set the customer's flag; subclass to CustomerProcessing, which is accessed through the
 * invoker Processor
 */
public class BackgroundCheck implements CustomerProcessing {
  Customer customer;

  public BackgroundCheck(Customer customer) {
    this.customer = customer;
  }

  // ideally this perform the task - for testing purposes, we just set the task to complete
  @Override
  public void execute() {
    customer.setBackgroundCheck(true);
  }

  @Override
  public void undo() {
    customer.setBackgroundCheck(false);
  }
}
