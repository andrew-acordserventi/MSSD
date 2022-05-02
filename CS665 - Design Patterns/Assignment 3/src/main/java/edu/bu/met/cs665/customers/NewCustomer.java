package edu.bu.met.cs665.customers;

/**
 * New customer class. Subclass of customer.
 */
public class NewCustomer extends Customer {

    public NewCustomer(String name, int customerID) {
        super(name, customerID);
        this.setType("newcustomer");
    }
}
