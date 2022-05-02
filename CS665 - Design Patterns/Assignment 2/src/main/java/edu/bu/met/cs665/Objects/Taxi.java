package edu.bu.met.cs665.Objects;

/**
 * Taxi class, subclass of driver. Can carry people.
 */
public class Taxi extends Driver{
    public Taxi(int driverID, String name) {
        super(driverID, name);
        this.setType("Taxi");
        this.setCarryFood(false);
        this.setCarryPerson(true);
    }
}
