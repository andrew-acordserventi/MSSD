package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;

import edu.bu.met.cs665.adapter1.*;
import edu.bu.met.cs665.command2.*;
import edu.bu.met.cs665.command2.orderProcessing.*;
import edu.bu.met.cs665.customer.Customer;
import edu.bu.met.cs665.facade3.OrderProcessor;
import edu.bu.met.cs665.facade3.PackageDelivery;
import edu.bu.met.cs665.facade3.ProductPackaging;
import edu.bu.met.cs665.facade3.ProductPickup;
import edu.bu.met.cs665.facade3.orders.Order;
import org.junit.Test;

public class test {
  /**
   * test the adapter pattern for question 1. note that the database implementation is
   * crude.
   */
  @Test
  public void TestAdapterPattern(){
    // creating new instance of our database and our adapter to use
    CustomerDataOld customerDataOld = new CustomerDataOld();
    Adapter adapter = new CDMSAdapter(customerDataOld);

    // creating new customers to add to our database
    Customer customer1 = new Customer("Bob", "bob@yahoo.com", "123");
    customerDataOld.addCustomer(customer1);
    Customer customer2 = new Customer("Mary", "mary@yahoo.com", "1234");
    customerDataOld.addCustomer(customer2);
    Customer customer3 = new Customer("Fred", "fred@yahoo.com", "12345");
    customerDataOld.addCustomer(customer3);

    // adapter test - not sending it to the old data, but rather the new database name
    // note that the adapter is called and its passing two variables
    // note that our old database system will only work if one variable is passed
    Customer testCustomer = adapter.getCustomer("fred@yahoo.com", "12345");
    // name should equal fred
    assertEquals(testCustomer.getName(), "Fred");

    // one more test
    Customer testCustomer2 = adapter.getCustomer("bob@yahoo.com", "123");
    assertEquals(testCustomer2.getName(), "Bob");

    // note that the below does NOT work, since the method is protected
    // Customer testCustomer3 = CustomerDataOld.getCustomer("mary@yahoo.com");
  }


  /**
   * Testing Command pattern
   */
  @Test
  public void TestCommandPattern() {
    // creating new customers to add to our database
    Customer customer1 = new Customer("Bob", "bob@yahoo.com", "123");
    Customer customer2 = new Customer("Mary", "mary@yahoo.com", "1234");
    Customer customer3 = new Customer("Fred", "fred@yahoo.com", "12345");

    // testing command pattern
    // new processor to handle requests (invoker)
    Processor p = new Processor();
    // executes a new background check on customer and checks it
    p.execute(new BackgroundCheck(customer1));
    assertEquals(customer1.isBackgroundCheck(), true);
    // tests undo functionality
    p.undo(new BackgroundCheck(customer1));
    assertEquals(customer1.isBackgroundCheck(), false);

    // test 2
    assertEquals(customer2.isWelcomeEmailSent(), false);
    p.execute(new WelcomeEmail(customer2));
    assertEquals(customer2.isWelcomeEmailSent(), true);
    p.undo(new WelcomeEmail(customer2));
    assertEquals(customer2.isWelcomeEmailSent(), false);
  }

  /**
   * Testing order processing facade.
   */
  @Test
  public void testFacadePattern(){
    // creating new orders
    Order order1 = new Order(1);
    Order order2 = new Order(2);
    Order order3 = new Order(3);

    // creating a new order processor to process our orders
    OrderProcessor O = new OrderProcessor();

    // testing our simple O.execute(command(order)) on our more complex systems
    assertEquals(order1.isPickup(), false);
    O.execute(new ProductPickup(order1));
    assertEquals(order1.isPickup(), true);
    assertEquals(order1.isPackaged(), false);
    O.execute(new ProductPackaging(order1));
    assertEquals(order1.isPackaged(), true);

    // test #2
    assertEquals(order3.isDelivered(), false);
    O.execute(new PackageDelivery(order3));
    assertEquals(order3.isDelivered(), true);
  }

}
