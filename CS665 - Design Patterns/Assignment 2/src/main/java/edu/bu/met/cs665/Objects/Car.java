package edu.bu.met.cs665.Objects;

/**
 * Car class, subclass of driver. Can carry food.
 */
public class Car extends Driver{
    public Car(int driverID, String name) {
        super(driverID, name);
        this.setType("Car");
        this.setCarryFood(true);
        this.setCarryPerson(false);
    }
}
