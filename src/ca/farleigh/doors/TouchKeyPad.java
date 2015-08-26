package ca.farleigh.doors;

public class TouchKeyPad extends AbstractAuthenticator {

  private final SimpleReader reader;
  private final SimpleWriter writer;

  static final String enterUsernameText = "Please enter your username: ";
  static final String enterPasswordText = "Please enter your password: ";

  public TouchKeyPad(final AuthenticationProvider authenticationProvider, final SimpleReader reader,
      final SimpleWriter writer) {
    super(authenticationProvider);
    this.reader = reader;
    this.writer = writer;
  }
  
  @Override
  protected Credentials getCredentials() {
    final String username = getUsername(writer, reader);
    final String passcode = getPasscode(writer, reader);
    return new UsernamePasswordCredentials(username, passcode);
  }

  /**
   * Get username from a provided output and reader.
   * 
   * @param writer
   *          The output
   * @param reader
   *          A reader of the input
   * @return The user's provided username
   */
  private static String getUsername(final SimpleWriter writer, final SimpleReader reader) {
    writer.write(enterUsernameText);
    return reader.read();
  }

  /**
   * Get passcode from a provided output and reader.
   * 
   * @param out
   *          The output
   * @param reader
   *          A reader of the input
   * @return The user's provided passcode
   */
  private static String getPasscode(final SimpleWriter writer, final SimpleReader reader) {
    writer.write(enterPasswordText);
    return reader.read();
  }
}
