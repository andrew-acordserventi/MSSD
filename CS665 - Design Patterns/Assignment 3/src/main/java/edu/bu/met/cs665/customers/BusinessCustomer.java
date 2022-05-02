package edu.bu.met.cs665.customers;

/**
 * Business customer class. Subclass of customer. Should encrypt emails by default.
 */
public class BusinessCustomer extends Customer{

    public BusinessCustomer(String name, int customerID) {
        super(name, customerID);
        this.setType("businesscustomer");
        this.setEncryptEMails(true);
    }
}
