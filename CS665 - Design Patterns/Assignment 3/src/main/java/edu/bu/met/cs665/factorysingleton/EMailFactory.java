package edu.bu.met.cs665.factorysingleton;

import edu.bu.met.cs665.EMail;
import edu.bu.met.cs665.customers.Customer;

// Email factory interface for our email generation factory
public interface EMailFactory {
    public EMail getEmail(Customer customer);

}
