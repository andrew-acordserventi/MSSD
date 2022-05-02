package edu.bu.met.cs665;

import edu.bu.met.cs665.Builder.Stock;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Builds a stock from a file and displays relative data to a user.
 */
public class Main {
  static final LinkedList<Stock> stocks = new LinkedList<>();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in, "UTF-8");

    boolean exitFlag = false;

    String stockName = "";
    String fileName = "";

    // loop until exit
    while (exitFlag == false) {

      // get the stock's name; not provided in the file
      System.out.println("Stock name?");
      stockName = scanner.nextLine();

      // if the user types exit, this breaks the while loop to exit
      if (stockName.equals("exit")) {
        break;
      }

      // gets the filename
      System.out.println("File name? (ie, \"clov.csv\")");
      fileName = scanner.nextLine();

      // calls the buildstock method to read the file and build a stock class (facade)
      // adds it to the list of stocks
      stocks.add(BuildStock.buildStockFromFile(fileName, stockName));
      
      // prints the result
      System.out.println(stocks.get(stocks.size()-1).toString());
    }
  }
}
