package edu.bu.met.cs665.Objects;

import edu.bu.met.cs665.ObserverPattern.Observer;
import edu.bu.met.cs665.ObserverPattern.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Shop class. Has a name, address, list of observers, and list of requests.
 * Contains getters and setters.
 * Implements Subject interface for observers to be added/removed/notified.
 * Can register, remove, and update observers.
 * Can create a delivery request, which notifies all drivers and assigns a driver to the request.
 **/
public class Shop implements Subject {
    private String name;
    private String address;
    private List<Observer> observers;
    private List<DeliveryRequest> allRequests =  new ArrayList<>();

    public Shop(String name, String address) {
        this.setName(name);
        this.setAddress(address);
        observers = new ArrayList<Observer>();
    }

    /**
     * Registers an observer
     */
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Removes an observer from the list of observers
     */
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    /**
     * Takes in a new request and updates all observers on the request.
     */
    public void notifyObservers(DeliveryRequest newRequest) {
        for (Observer observer : observers) {
            observer.display(newRequest);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Takes in variables and creates a new delivery request.
     * Adds request to list of all requests, and updates observers
     * @param orderID - New request orderID, int
     * @param pickupAddress - New request pickup address, String
     * @param deliveryAddress - New request delivery address, String
     * @param deliveryItem - New request Item, custom Item class or subclass
     * @param timeDue - New request time due for delivery, Int
     */
    public void createDeliveryRequest(int orderID,
                                      String pickupAddress,
                                      String deliveryAddress,
                                      Item deliveryItem,
                                      int timeDue) {
        DeliveryRequest newRequest = new DeliveryRequest(orderID, pickupAddress, deliveryAddress, deliveryItem, timeDue);
        getAllRequests().add(newRequest);
        notifyObservers(newRequest);
    }

    public List<DeliveryRequest> getAllRequests() {
        return allRequests;
    }

    public void setAllRequests(List<DeliveryRequest> allRequests) {
        this.allRequests = allRequests;
    }
}
