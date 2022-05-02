package edu.bu.met.cs665.command2.orderProcessing;

import edu.bu.met.cs665.customer.Customer;

/**
 * executes or undos a customer's rejection email; real world, this would execute the task AND
 * set the customer's flag; subclass to CustomerProcessing, which is accessed through the
 * invoker Processor
 */
public class RejectionEmail implements CustomerProcessing {
  Customer customer;

  // ideally this perform the task - for testing purposes, we just set the task to complete
  public RejectionEmail(Customer customer) {
    this.customer = customer;
  }
  @Override
  public void execute() {
    customer.setWelcomeEmailSent(true);
  }

  @Override
  public void undo() {
    customer.setRejectionEmailSent(false);
  }
}
