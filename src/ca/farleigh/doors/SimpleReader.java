package ca.farleigh.doors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SimpleReader {

  private final BufferedReader reader;

  public SimpleReader(final InputStream input) {
    this.reader = new BufferedReader(new InputStreamReader(input));
  }

  /**
   * Read from the input.
   * @return The string that is read from the inputstream.
   */
  public String read() {
    try {
      return reader.readLine();
    } catch (IOException ex) {
      // do some logging and potentially rethrow exception
      return null;
    }
  }
}
