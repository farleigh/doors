package ca.farleigh.doors;

public abstract class AbstractAuthenticator implements Authenticator {
  
  private final AuthenticationProvider authenticationProvider;
  
  public AbstractAuthenticator(AuthenticationProvider authenticationProvider) {
    this.authenticationProvider = authenticationProvider;
  }
  
  /**
   * Authenticate the user.
   * @return True if user is found that matches the provided credentials.
   */
  @Override
  public User authenticate() {
    return authenticationProvider.authenticate(getCredentials());
  }
  
  /**
   * Can be overridden to return the appropriate credentials for the user and the system.
   */
  protected abstract Credentials getCredentials();
  
  /**
   * Get the authentication provider for use in subclasses if needed.
   */
  protected AuthenticationProvider getAuthenticationProvider() {
    return authenticationProvider;
  }
}
