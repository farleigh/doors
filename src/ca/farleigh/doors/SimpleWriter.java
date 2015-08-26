package ca.farleigh.doors;

import java.io.PrintStream;

public class SimpleWriter {
  
  private final PrintStream printer;
  
  public SimpleWriter(final PrintStream printer) {
    this.printer = printer;
  }
  
  public void write(final String output) {
    printer.print(output);
  }
}
