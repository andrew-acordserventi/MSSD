package edu.bu.met.cs665.Objects;

/**
 * Food class, subclass of an item.
 */
public class Food extends Item{
    public Food(String name, double price) {
        super(name, price);
        this.setFood(true);
        this.setPeople(false);
    }
}
