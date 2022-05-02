package edu.bu.met.cs665;

import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.factorysingleton.CustomerGenerationFactory;
import edu.bu.met.cs665.factorysingleton.EMailGenerationFactory;
import edu.bu.met.cs665.factorysingleton.Singleton;

public class Main {
    /**
     * Tests the check email and encrypt option methods. Must be tested in main since it requires user input.
     */
    public static void main(String[] args) {
        CustomerGenerationFactory customerFactory = Singleton.getInstanceCustomer();
        EMailGenerationFactory eMailFactory = Singleton.getInstanceEmail();

        Customer business = customerFactory.getCustomer("Bob", 1, "businessCustomer");
        EMail email = eMailFactory.getEmail(business);
        System.out.println(email.generateEmail());
        email.checkEMail();
        System.out.println(email.generateEmail());
        email.encryptOption();
        System.out.println("Encryption test: " + email.isEncrypted());
    }
}

/**
 * Tests
 * Case 1:
 *
 * This is the header for a business customer!
 *
 * Dear Bob, Customer # 1:
 *
 * This is the body for a business customer!
 *
 * This is the footer for a business customer!
 *
 * Is this EMail okay to send send? (y/n)
 * n
 * Please input the header you would like to send, then press enter:
 * test header
 * Please input the body you would like to send, then press enter:
 * test body
 * Please input the footer you would like to send, then press enter:
 * test footer
 *
 * test header
 *
 * Dear Bob, Customer # 1:
 *
 * test body
 *
 * test footer
 *
 * Is this EMail okay to send send? (y/n)
 * y
 * test header
 *
 * Dear Bob, Customer # 1:
 *
 * test body
 *
 * test footer
 * Do you want to encrypt this email? (y/n)
 * y
 * Encryption test: true
 *
 * Process finished with exit code 0
 *
 * Case 2:
 *
 * This is the header for a business customer!
 *
 * Dear Bob, Customer # 1:
 *
 * This is the body for a business customer!
 *
 * This is the footer for a business customer!
 *
 * Is this EMail okay to send send? (y/n)
 * y
 * This is the header for a business customer!
 *
 * Dear Bob, Customer # 1:
 *
 * This is the body for a business customer!
 *
 * This is the footer for a business customer!
 * Do you want to encrypt this email? (y/n)
 * n
 * Encryption test: false
 *
 * Process finished with exit code 0
 */