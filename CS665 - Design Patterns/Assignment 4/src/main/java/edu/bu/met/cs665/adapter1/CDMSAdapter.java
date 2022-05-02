package edu.bu.met.cs665.adapter1;

import edu.bu.met.cs665.customer.Customer;

/**
 * Adapter design pattern. Takes a email and phone number, then passes that to the database
 * with just email to get the customer in the database.
 */
public class CDMSAdapter implements Adapter{

  private CustomerDataOld legacy;

  public CDMSAdapter(CustomerDataOld oldData) {
    this.legacy = oldData;
  }

  public Customer getCustomer(String email, String phoneNumber) {
    return getCustomerOld(email);
  }

  private Customer getCustomerOld(String email) {
    return this.legacy.getCustomer(email);
  }
}
