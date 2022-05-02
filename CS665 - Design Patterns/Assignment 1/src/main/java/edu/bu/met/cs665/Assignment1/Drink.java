package edu.bu.met.cs665.Assignment1;

public class Drink {
    private String name;
    private int milk;
    private int sugar;
    private double price;
    private final static int MAXCONDIMENTS = 3;
    private final static double SUGARPRICE = 0.3;
    private final static double MILKPRICE = 0.25;

    // constructor
    public Drink(String name) {
        this.name = name;
        this.milk = 0;
        this.sugar = 0;
        this.price = setPrice();
    }

    // adds milk if maxcondiments if milk is less than max; updates price
    public void addMilk() {
        // only adds if the drink has less than 4 units
        if (this.milk <= MAXCONDIMENTS) {
            this.milk += 1;
            this.price += MILKPRICE;
        }
    }

    public int getMilk() {
        return this.milk;
    }

    // adds sugar if maxcondiments if sugar is less than max; updates price
    public void addSugar() {
        // only adds if the drink has less than 4 units
        if (this.sugar <= MAXCONDIMENTS) {
            this.sugar += 1;
            this.price += SUGARPRICE;
        }
    }

    public int getSugar() {
        return this.sugar;
    }

    // sets the default price, based on the name of drink; if no name is found, defaults to 3, or max price
    public double setPrice() {
        if (this.name.equals("Americano")) {
            return 2;
        }
        else if (this.name.equals("Espresso")) {
            return 2.5;
        }
        else if (this.name.equals("Latte Macchiato")) {
            return 3;
        }
        else if (this.name.equals("Black Tea")) {
            return 1.5;
        }
        else if (this.name.equals("Green Tea")) {
            return 2;
        }
        else if (this.name.equals("Yellow Tea")) {
            return 2.5;
        }
        // if the product is not found, it will default to the highest price
        else {
            return 3;
        }
    }

    // returns price
    public double getPrice() {
        return this.price;
    }

    // returns the number of condiments (milk + sugar)
    public int getCondimentNumber() {
        return (this.milk + this.sugar);
    }
}
