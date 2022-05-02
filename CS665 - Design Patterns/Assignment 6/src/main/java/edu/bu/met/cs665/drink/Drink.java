package edu.bu.met.cs665.drink;

/**
 * Drink interface. Lays the blueprint for subclasses coffees and teas.
 */
public interface Drink {

  public void addMilk();
  public int getMilk();
  public void addSugar();
  public int getSugar();
  public int getCondimentNumber();
  public void setPrice(double price);
  public double getPrice();
}
