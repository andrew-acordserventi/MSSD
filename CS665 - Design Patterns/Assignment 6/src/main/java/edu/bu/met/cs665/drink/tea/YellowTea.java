package edu.bu.met.cs665.drink.tea;

import edu.bu.met.cs665.drink.Drink;

/**
 * Yellow tea. Subclass of Tea. Contains price, number of milk, and number of sugar.
 */
public class YellowTea extends Tea{
  public YellowTea() {
    this.milk = 0;
    this.sugar = 0;
    this.price = 2.5;
  }

  @Override
  public String toString() {
    return "Yellow tea{" +
        "milk = " + milk +
        ", sugar = " + sugar +
        ", price = " + price +
        '}';
  }

  @Override
  public void addMilk() {
    // only adds if the drink has less than 4 units
    if (this.milk < MAXCONDIMENTS) {
      this.milk += 1;
      this.price += MILKPRICE;
    }
  }

  @Override
  public int getMilk() {
    return this.milk;
  }

  @Override
  public void addSugar() {
    // only adds if the drink has less than 4 units
    if (this.sugar < MAXCONDIMENTS) {
      this.sugar += 1;
      this.price += SUGARPRICE;
    }
  }

  @Override
  public int getSugar() {
    return this.sugar;
  }

  @Override
  public int getCondimentNumber() {
    return (this.milk + this.sugar);
  }

  @Override
  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public double getPrice() {
    return this.price;
  }
}
