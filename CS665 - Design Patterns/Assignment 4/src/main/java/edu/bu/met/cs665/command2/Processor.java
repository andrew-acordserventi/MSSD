package edu.bu.met.cs665.command2;

import edu.bu.met.cs665.command2.orderProcessing.*;

/**
 * Allows us to process an order. Command pattern invoker. Key to accessing sub-commands
 */
public class Processor {

  // accesses our list of steps through the customerProcessing interface; KEY COMPONENT
  public void execute(CustomerProcessing customerProcessing) {
    customerProcessing.execute();
  }

  // accesses our list of undos through the customerProcessing interface; KEY COMPONENT
  public void undo(CustomerProcessing customerProcessing) {
    customerProcessing.undo();
  }
}
