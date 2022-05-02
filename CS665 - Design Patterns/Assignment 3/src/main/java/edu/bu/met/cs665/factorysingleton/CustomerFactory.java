package edu.bu.met.cs665.factorysingleton;

import edu.bu.met.cs665.customers.Customer;

// factory interface for our customer factory
public interface CustomerFactory {
    public Customer getCustomer(String name, int customerID, String type);
}
