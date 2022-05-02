package edu.bu.met.cs665.drink.tea;

import edu.bu.met.cs665.drink.Drink;

/**
 * Tea abstract class. Parent class for tea types. Contains the price for sugar and milk,
 * the maximum number of condiments allowed, and allows the tea to steep.
 */
public abstract class Tea implements Drink {
  protected final static int MAXCONDIMENTS = 3;
  protected final static double SUGARPRICE = 0.3;
  protected final static double MILKPRICE = 0.25;

  protected int milk;
  protected int sugar;
  protected double price;

  public void brew(){
    System.out.println("Now steeping your tea..." + toString());
  }
}
