package ca.farleigh.doors;

public interface Credentials {
  /**
   * Determines whether these credentials are a match the provided credentials.
   * @param other The provided credentials to compare.
   * @return True if credentials match.
   */
  boolean isMatch(final Credentials other);
}
