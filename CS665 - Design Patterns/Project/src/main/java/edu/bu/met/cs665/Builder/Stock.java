package edu.bu.met.cs665.Builder;

import java.text.DecimalFormat;

/**
 * Stock object. Built using builder design pattern. Has a name, price, volume, high, and low.
 */
public class Stock {
  private final String name;
  private final double currPrice;
  private final double avgVolume;
  private final double high;
  private final double low;

  // private constructor so builder works
  private Stock(StockBuilder builder) {
    this.name = builder.name;
    this.currPrice = builder.currPrice;
    this.avgVolume = builder.avgVolume;
    this.high = builder.high;
    this.low = builder.low;
  }

  public String getName() {
    return name;
  }

  public double getCurrPrice() {
    return currPrice;
  }

  public double getAvgVolume() {
    return avgVolume;
  }

  public double getHigh() {
    return high;
  }

  public double getLow() {
    return low;
  }

  @Override
  public String toString() {
    String format = new DecimalFormat("###,###,###,###.00").format(avgVolume);
    return "Stock{" +
        "Name = " + name + '\'' +
        ", Current Price = " + currPrice +
        ", Average Volume = " + format +
        ", High = " + high +
        ", Low = " + low +
        '}';
  }

  public static class StockBuilder {

    private String name;
    private double currPrice;
    private double avgVolume;
    private double high;
    private double low;

    // initial constructor to build the stock
    public StockBuilder(String name) {
      this.name = name;
    }

    // adds the currprice if available
    public StockBuilder currPrice(double currPrice) {
      this.currPrice = currPrice;
      return this;
    }

    // adds the avgVolume if available
    public StockBuilder avgVolume(double avgVolume) {
      this.avgVolume = avgVolume;
      return this;
    }

    // adds the high if available
    public StockBuilder high(double high) {
      this.high = high;
      return this;
    }

    // adds the low if available
    public StockBuilder low(double low) {
      this.low = low;
      return this;
    }

    // builds the stock
    public Stock build() {
      Stock stock = new Stock(this);
      return stock;
    }
  }
}
