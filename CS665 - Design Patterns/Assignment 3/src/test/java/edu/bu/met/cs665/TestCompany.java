package edu.bu.met.cs665;

import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.factorysingleton.CustomerGenerationFactory;
import edu.bu.met.cs665.factorysingleton.EMailGenerationFactory;
import edu.bu.met.cs665.factorysingleton.Singleton;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * JUnit tests to test customer and email generation factories, and default encryption for customer types.
 */
public class TestCompany {
    public CustomerGenerationFactory customerFactory;
    public EMailGenerationFactory eMailFactory;

    @Before
    public void createFactory() {
        this.customerFactory = Singleton.getInstanceCustomer();
        this.eMailFactory = Singleton.getInstanceEmail();
    }

    @Test
    public void TestBusinessCustomer(){
        Customer business = customerFactory.getCustomer("Bob", 1, "businessCustomer");
        EMail email = eMailFactory.getEmail(business);
        System.out.println(email.generateEmail());
        assertEquals(email.isEncrypted(), true);
    }

    @Test
    public void TestFrequentCustomer() {
        Customer frequent = customerFactory.getCustomer("Mary", 2, "frequentCustomer");
        EMail email = eMailFactory.getEmail(frequent);
        System.out.println(email.generateEmail());
        assertEquals(email.isEncrypted(), false);
    }

    @Test
    public void TestNewCustomer() {
        Customer newCustomer = customerFactory.getCustomer("Newbie", 3, "newCustomer");
        EMail email = eMailFactory.getEmail(newCustomer);
        System.out.println(email.generateEmail());
        assertEquals(email.isEncrypted(), false);
    }

    @Test
    public void TestReturningCustomer() {
        Customer returning = customerFactory.getCustomer("Returner", 4, "returningCustomer");
        EMail email = eMailFactory.getEmail(returning);
        System.out.println(email.generateEmail());
        assertEquals(email.isEncrypted(), false);
    }

    @Test
    public void TestVIPCustomer() {
        Customer VIP = customerFactory.getCustomer("Special", 5, "VIPCustomer");
        EMail email = eMailFactory.getEmail(VIP);
        System.out.println(email.generateEmail());
        assertEquals(email.isEncrypted(), true);
    }
}
