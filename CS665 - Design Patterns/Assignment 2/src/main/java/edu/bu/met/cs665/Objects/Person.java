package edu.bu.met.cs665.Objects;

/**
 * Person class, subclass of an item.
 */
public class Person extends Item{
    public Person(String name, double price) {
        super(name, price);
        this.setFood(false);
        this.setPeople(true);
    }
}
