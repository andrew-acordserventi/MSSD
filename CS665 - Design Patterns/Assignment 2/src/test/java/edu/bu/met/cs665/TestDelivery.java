package edu.bu.met.cs665;

import edu.bu.met.cs665.Objects.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestDelivery {
    /**
     * Creates drivers and tests them.
     */
    @Test
    public void TestDrivers() {
        List<Driver> drivers = new ArrayList<>();

        Driver driver1 = new Van(1, "Bob");
        drivers.add(driver1);
        Driver driver2 = new Taxi(2, "John");
        drivers.add(driver2);
        Driver driver3 = new Car(3, "Mary");
        drivers.add(driver3);

        assertEquals(drivers.get(0).getName(), "Bob");
        assertEquals(drivers.get(2).getDriverID(), 3);
        assertEquals(drivers.get(1).getType(), "Taxi");
    }

    /**
     * Creates a shop and drivers. Registers drivers as observers.
     * Creates 3 delivery requests, sends out notification, and then assertion tests the requests.
     * Lastly, assigns items to drivers
     */
    @Test
    public void TestShop() {
       // creating new drivers
        Driver driver1 = new Van(1, "Bob");
        Driver driver2 = new Taxi(2, "John");
        Driver driver3 = new Car(3, "Mary");

        // creating a new shop
        Shop myShop = new Shop("MyShop", "123 Fake Street");

        // registering the drivers with the shop
        myShop.registerObserver(driver1);
        myShop.registerObserver(driver2);
        myShop.registerObserver(driver3);

        List<Item> items = new ArrayList<>();
        // creating new items and delivery order requests
        Item item1 = new Person("Sam", 5.99);
        items.add(item1);
        myShop.createDeliveryRequest(1,
                myShop.getAddress(),
                "1234 False Street",
                item1,
                2030);

        Item item2 = new Food("Beer", 12.99);
        items.add(item2);
        myShop.createDeliveryRequest(2,
                myShop.getAddress(),
                "123 Spooner Street",
                item2,
                2100);

        Item item3 = new Goods("Board Game", 20.99);
        items.add(item3);
        myShop.createDeliveryRequest(3,
                myShop.getAddress(),
                "123 Happy Street",
                item3,
                1700);

        // testing the shop and the delivery orders
        assertEquals(myShop.getAddress(), "123 Fake Street");
        assertEquals(myShop.getAllRequests().get(1).getDeliveryAddress(), "123 Spooner Street");
        assertEquals(myShop.getAllRequests().get(1).getTimeDue(), 2100);
        assertEquals(myShop.getAllRequests().get(0).getDeliveryAddress(), "1234 False Street");
        assertEquals(myShop.getAllRequests().get(2).getOrderID(), 3);

        // assigning items to drivers
        // TODO In a real program, assignment of items would need to be improved; this is a crude implementation
        for(int i = 0; i <= items.size()-1; i++) {
            if (items.get(i).isFood() == true) {
                driver3.setCurrItem(items.get(i));
            } else if (items.get(i).isPeople() == true) {
                driver2.setCurrItem(items.get(i));
            } else {
                driver1.setCurrItem(items.get(i));
            }
        }
        assertEquals(driver1.getCurrItem().getName(), "Board Game");
        assertEquals(driver2.getCurrItem().getName(), "Sam");
        assertEquals(driver3.getCurrItem().getName(), "Beer");
    }
}
