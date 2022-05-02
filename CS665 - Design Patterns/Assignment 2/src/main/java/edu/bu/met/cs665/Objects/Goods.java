package edu.bu.met.cs665.Objects;

/**
 * Goods class, subclass of an item.
 */
public class Goods extends Item{
    public Goods(String name, double price){
        super(name, price);
        this.setFood(false);
        this.setPeople(false);
    }
}
