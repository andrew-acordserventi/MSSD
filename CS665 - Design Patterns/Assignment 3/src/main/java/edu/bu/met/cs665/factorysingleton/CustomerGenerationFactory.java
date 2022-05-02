package edu.bu.met.cs665.factorysingleton;

import edu.bu.met.cs665.customers.*;

/**
 * Generates new customers, based on the type of customer input. Will create a new customer, and input the
 * customer's name and ID.
 */
public class CustomerGenerationFactory implements CustomerFactory {

    public Customer getCustomer(String name, int customerID, String type) {
        if(type == null) {
            return null;
        }
        if(type.toLowerCase().equals("businesscustomer")) {
            return new BusinessCustomer(name, customerID);
        }
        else if(type.toLowerCase().equals("frequentcustomer")) {
            return new FrequentCustomer(name, customerID);
        }
        else if(type.toLowerCase().equals("newcustomer")) {
            return new NewCustomer(name, customerID);
        }
        else if(type.toLowerCase().equals("returningcustomer")) {
            return new ReturningCustomer(name, customerID);
        }
        else if(type.toLowerCase().equals("vipcustomer")) {
            return new VIPCustomer(name, customerID);
        }
        return null;
    }
}
