package ca.farleigh.doors;

public interface Authenticator {
  /**
   * Gets user if able to authenticate user.
   * Retrieving the credential information must be handled within the implementation of 
   * any classes that implement this interface.
   * @return The authenticated user.
   */
  public User authenticate();
}