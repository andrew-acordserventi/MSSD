package edu.bu.met.cs665.command2.orderProcessing;

import edu.bu.met.cs665.customer.Customer;

/**
 * executes or undos a customer's email verification; real world, this would execute the task AND
 * set the customer's flag; subclass to CustomerProcessing, which is accessed through the
 * invoker Processor
 */
public class EmailVerification implements CustomerProcessing {
  Customer customer;

  public EmailVerification(Customer customer) {
    this.customer = customer;
  }

  // ideally this perform the task - for testing purposes, we just set the task to complete
  @Override
  public void execute() {
    customer.setEmailVerification(true);
  }

  @Override
  public void undo() {
    customer.setBackgroundCheck(false);
  }
}
