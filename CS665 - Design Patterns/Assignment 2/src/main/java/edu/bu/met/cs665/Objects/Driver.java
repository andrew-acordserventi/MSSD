package edu.bu.met.cs665.Objects;

import edu.bu.met.cs665.ObserverPattern.Observer;

/**
 * Driver abstract class. Has an ID, name, and type. Getters/setters for all.
 * Blueprint for subclasses to implement different driver types.
 * Contains method to print a new request from a created delivery request.
 * Implements the observer interface (to display request info).
 */
public abstract class Driver implements Observer {
    private int driverID;
    private String name;
    private String type;
    private boolean carryFood;
    private boolean carryPerson;
    private Item currItem;

    public Driver(int driverID, String name) {
        this.setDriverID(driverID);
        this.setName(name);
    }

    /**
    Takes in a delivery request when created at a shop and prints it out.
     **/
    @Override
    public void display(DeliveryRequest newRequest) {
        System.out.println(newRequest.displayOrder());
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isCarryFood() {
        return carryFood;
    }

    public void setCarryFood(boolean carryFood) {
        this.carryFood = carryFood;
    }

    public boolean isCarryPerson() {
        return carryPerson;
    }

    public void setCarryPerson(boolean carryPerson) {
        this.carryPerson = carryPerson;
    }

    public Item getCurrItem() {
        return currItem;
    }

    public void setCurrItem(Item currItem) {
        this.currItem = currItem;
    }
}
