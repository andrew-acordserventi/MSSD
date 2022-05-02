package edu.bu.met.cs665.customers;

/**
 * Frequent customer class. Subclass of customer.
 */
public class FrequentCustomer extends Customer {

    public FrequentCustomer(String name, int customerID) {
        super(name, customerID);
        this.setType("businesscustomer");
    }
}
