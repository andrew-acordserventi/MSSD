package edu.bu.met.cs665.Objects;

/**
 * Van class, subclass of Driver. Cannot carry food or passengers (goods only).
 */
public class Van extends Driver{
    public Van(int driverID, String name) {
        super(driverID, name);
        this.setType("Van");
        this.setCarryFood(false);
        this.setCarryPerson(false);
    }
}
