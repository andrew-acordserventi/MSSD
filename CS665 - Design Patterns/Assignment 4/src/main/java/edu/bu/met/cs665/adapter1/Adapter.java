package edu.bu.met.cs665.adapter1;

import edu.bu.met.cs665.customer.Customer;

/**
 * Provides the blueprint to adapt our getCustomer method, taking in two variables.
 */
public interface Adapter {
  public Customer getCustomer(String email, String phoneNumber);
}
