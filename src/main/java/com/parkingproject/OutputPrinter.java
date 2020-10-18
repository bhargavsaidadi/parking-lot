package com.parkingproject;

/**
 * Printer to help in printing the output back to the user. Output medium can be changed here
 * anytime without affecting any of the other code. Currently, System.out is used. Tomorrow if file
 * has to be used to output, it can be changed here easily.
 */
public class OutputPrinter {

  public void notFound() {
    printWithNewLine("null");
  }

  public void parkingLotFull() {
    printWithNewLine("Sorry, parking lot is full");
  }

  public void parkingLotEmpty() {
    printWithNewLine("Parking lot is empty");
  }

  public void invalidFile() {
    printWithNewLine("Invalid file given.");
  }

  public void printWithNewLine(final String msg) {
    System.out.println(msg);
  }
}
