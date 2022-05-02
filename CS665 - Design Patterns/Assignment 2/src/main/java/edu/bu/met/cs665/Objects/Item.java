package edu.bu.met.cs665.Objects;

public abstract class Item {
    private String name;
    private double price;
    private boolean isFood;
    private boolean isPeople;

    public Item(String name, double price) {
        this.setName(name);
        this.setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isFood() {
        return isFood;
    }

    public void setFood(boolean food) {
        isFood = food;
    }

    public boolean isPeople() {
        return isPeople;
    }

    public void setPeople(boolean people) {
        isPeople = people;
    }

    public String description() {
        return "Item name: " + this.getName() + ", Price: " + this.getPrice();
    }
}
