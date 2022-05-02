package edu.bu.met.cs665.drink.coffee;

import edu.bu.met.cs665.drink.Drink;

/**
 * Coffee abstract class. Parent class for coffee types. Contains the price for sugar and milk,
 * the maximum number of condiments allowed, and allows the coffee to brew.
 */
public abstract class Coffee implements Drink {

  protected final static int MAXCONDIMENTS = 3;
  protected final static double SUGARPRICE = 0.3;
  protected final static double MILKPRICE = 0.25;

  protected int milk;
  protected int sugar;
  protected double price;

  public void brew(){
    System.out.println("Now brewing your coffee..." + toString());
  }
}
