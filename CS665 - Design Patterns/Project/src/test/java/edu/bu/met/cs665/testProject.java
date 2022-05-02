package edu.bu.met.cs665;

import edu.bu.met.cs665.Builder.Stock;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class testProject {
  @Test
  public void test() {
    LinkedList<Stock> stocks = new LinkedList<>();

    stocks.add(BuildStock.buildStockFromFile("CLOV.csv", "Clover Healthcare"));
    stocks.add(BuildStock.buildStockFromFile("MSFT.csv", "Microsoft"));
    stocks.add(BuildStock.buildStockFromFile("AMZN.csv", "Amazon"));

    assertEquals(stocks.get(0).getCurrPrice(), 8.4101,1);
    assertEquals(stocks.get(1).getHigh(), 291.660004,1);
    assertEquals(stocks.get(2).getLow(), 2951.949951,1);
  }
}
