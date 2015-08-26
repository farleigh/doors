package ca.farleigh.doors;

public class KeyCardVerifier extends AbstractAuthenticator {
  
  private final SimpleReader reader;
  
  public KeyCardVerifier(final AuthenticationProvider authenticationProvider, final SimpleReader reader) {
    super(authenticationProvider);
    this.reader = reader;
  }
  
  @Override
  protected Credentials getCredentials() {
    final String keyCodeSequence = reader.read();
    return new KeyCardCredentials(keyCodeSequence);
  }
}
