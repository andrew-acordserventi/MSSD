package edu.bu.met.cs665;

import edu.bu.met.cs665.Builder.Stock;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.DecimalFormat;

/**
 * Facade to build a stock. Takes a stock name and a file name. Reads from a file, and grabs
 * relevant data from the file to build a stock object, using builder pattern.
 */
public class BuildStock {
  public static Stock buildStockFromFile(String fileName, String stockName) {
    // new bufferedreader
    BufferedReader br = null;

    // placeholder to store each line
    String line = "";

    double high = 0;
    double low = 0;
    double totVolume = 0;
    int entries = 0;
    double avgVolume;
    double currPrice = 0;

    String split[] = null;
    double currentValue = 0;
    double currentVolume = 0;

    try {
      // sets the reader to read from our pathway
      br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));

      // reads the firstline and tosses it (since first line is header)
      br.readLine();

      // critical code: while the file still has lines, keep going through, line by line of the file
      while ((line = br.readLine()) != null) {

        // splits the line by commas
        split = line.split(",");

        // tries to turn the close price into a double
        try {
          currentValue = Double.parseDouble(split[4]);
        } catch (Exception e) {
          e.printStackTrace();
        }

        // if the close price of the line is > high, it becomes the new high
        if (currentValue > high) {
          high = currentValue;
        }

        // if the close price of the line is < low, it becomes the new low (0 to initialize low)
        if (currentValue < low || low == 0) {
          low = currentValue;
        }

        // converts the line volume point into a double
        try {
          currentVolume = Double.parseDouble(split[6]);
        } catch (Exception e) {
          e.printStackTrace();
        }

        // adds up volume
        totVolume += currentVolume;
        // adds up number of entries
        entries++;
        // last line's will hold current price, so current price = the last close price value
        currPrice = currentValue;
      }
    }
    // catches error if the file does not exist
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    // catches the error if the IO is incorrect
    catch (IOException e) {
      e.printStackTrace();
    }

    // final steps, try to close the writer/reader
    finally {
      // assuming the reader wasn't empty, try to close the reader
      if (br != null) {
        try {
          br.close();
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    // gets average volume and formats it
    avgVolume = totVolume / entries;

    // builds the stock using the builder pattern; note that things can be removed easily
    Stock stock = new Stock.StockBuilder(stockName)
        .currPrice(currPrice)
        .avgVolume(avgVolume)
        .high(high)
        .low(low)
        .build();

    return stock;
  }
}
