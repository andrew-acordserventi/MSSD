package edu.bu.met.cs665.factorysingleton;

import edu.bu.met.cs665.EMail;
import edu.bu.met.cs665.customers.*;

/**
 * Factory to create emails. Receives a customer, then generates an e-mail for that customer, based
 * on their name, customer ID, and what type of customer it is. Sets encryption on the email by default.
 */
public class EMailGenerationFactory implements EMailFactory{
    @Override
    public EMail getEmail(Customer customer) {
        if(customer.getType() == null) {
            return null;
        }
        if(customer.getType().equals("businesscustomer")) {
            String header = "This is the header for a business customer!";
            String body = "This is the body for a business customer!";
            String footer = "This is the footer for a business customer!";
            return new EMail(customer.getName(), customer.getCustomerID(),
                    header, body, footer,
                    customer.isEncryptEMails());
        }
        else if(customer.getType().equals("frequentcustomer")) {
            String header = "This is the header for a frequent customer!";
            String body = "This is the body for a frequent customer!";
            String footer = "This is the footer for a frequent customer!";
            return new EMail(customer.getName(), customer.getCustomerID(),
                    header, body, footer,
                    customer.isEncryptEMails());
        }
        else if(customer.getType().equals("newcustomer")) {
            String header = "This is the header for a new customer!";
            String body = "This is the body for a new customer!";
            String footer = "This is the footer for a new customer!";
            return new EMail(customer.getName(), customer.getCustomerID(),
                    header, body, footer,
                    customer.isEncryptEMails());
        }
        else if(customer.getType().equals("returningcustomer")) {
            String header = "This is the header for a returning customer!";
            String body = "This is the body for a returning customer!";
            String footer = "This is the footer for a returning customer!";
            return new EMail(customer.getName(), customer.getCustomerID(),
                    header, body, footer,
                    customer.isEncryptEMails());
        }
        else if(customer.getType().equals("vipcustomer")) {
            String header = "This is the header for a VIP customer!";
            String body = "This is the body for a VIP customer!";
            String footer = "This is the footer for a VIP customer!";
            return new EMail(customer.getName(), customer.getCustomerID(),
                    header, body, footer,
                    customer.isEncryptEMails());
        }
        else{
            String header = "This is the header for a default customer!";
            String body = "This is the body for a default customer!";
            String footer = "This is the footer for a default customer!";
            return new EMail(customer.getName(), customer.getCustomerID(),
                    header, body, footer,
                    customer.isEncryptEMails());
        }
    }
}
