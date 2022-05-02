package edu.bu.met.cs665.command2.orderProcessing;

import edu.bu.met.cs665.customer.Customer;

/**
 * executes or undos a customer's welcome email; real world, this would execute the task AND
 * set the customer's flag; subclass to CustomerProcessing, which is accessed through the
 * invoker Processor
 */
public class WelcomeEmail implements CustomerProcessing {

  Customer customer;

  public WelcomeEmail(Customer customer) {
    this.customer = customer;
  }

  // ideally this perform the task - for testing purposes, we just set the task to complete
  @Override
  public void execute() {
    customer.setWelcomeEmailSent(true);
  }

  @Override
  public void undo() {
    customer.setWelcomeEmailSent(false);
  }
}
