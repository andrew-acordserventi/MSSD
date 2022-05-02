package edu.bu.met.cs665.customers;

/**
 * VIP customer class. Subclass of customer. Should encrypt emails by default.
 */
public class VIPCustomer extends Customer {

    public VIPCustomer(String name, int customerID) {
        super(name, customerID);
        this.setType("vipcustomer");
        this.setEncryptEMails(true);
    }
}
