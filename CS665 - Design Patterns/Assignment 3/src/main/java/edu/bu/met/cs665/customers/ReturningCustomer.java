package edu.bu.met.cs665.customers;

/**
 * Returning customer class. Subclass of customer.
 */
public class ReturningCustomer extends Customer {

    public ReturningCustomer(String name, int customerID) {
        super(name, customerID);
        this.setType("returningcustomer");
    }
}
