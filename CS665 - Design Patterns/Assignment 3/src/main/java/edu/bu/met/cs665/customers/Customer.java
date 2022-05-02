package edu.bu.met.cs665.customers;

import java.util.Scanner;

/**
 * Customer abstract class. Contains the default blueprint for generating a customer.
 * Contains name, customerID, type, and whether the emails should be encrypted by default or not (based on
 * customer type).
 */
public abstract class Customer {
    private String name;
    private int customerID;
    private String type;
    private boolean encryptEMails = false;

    // default constructor
    public Customer(String name, int customerID) {
        this.setName(name);
        this.setCustomerID(customerID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isEncryptEMails() {
        return encryptEMails;
    }

    public void setEncryptEMails(boolean encryptEMails) {
        this.encryptEMails = encryptEMails;
    }
}
