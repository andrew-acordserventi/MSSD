package edu.bu.met.cs665.command2.orderProcessing;

/**
 * Command pattern blueprint needed to execute processes or undo them. Specific commands
 * and how to perform them left to subclasses.
 */
public interface CustomerProcessing {
  void execute();
  void undo();
}
