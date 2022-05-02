package edu.bu.met.cs665.adapter1;

import edu.bu.met.cs665.customer.Customer;
import java.util.LinkedList;

/**
 * Old database with customer information. Being phased out.
 * Has a linked list with customers built into it.
 */
public class CustomerDataOld{
  private LinkedList<Customer> customers;
  //private LinkedList<Customer> customers = new LinkedList<>();


  // constructor just creates a new linkedlist (initializes)
  public CustomerDataOld() {
    // removed the below codeline and added new LinkedList to the variable...
    // below codeline produced a bug, writing to a static field from an instance...
    customers = new LinkedList<>();
  }

  // adds a customer to the linked list
  public void addCustomer(Customer customer) {
    customers.add(customer);
  }

  /**
   * Takes an email and returns the correct customer. Must be static (list is classwide).
   * Made it protected, so it cannot be accessed outside of the package.
   * @param email - customer email address
   * @return - returns the customer object that matches the email passed
   */
  protected Customer getCustomer(String email) {
    for (int i =0; i < customers.size(); i++) {
      if(customers.get(i).getEmail().equals(email)) {
        return customers.get(i);
      }
    }
    return customers.get(0);
  }
}

