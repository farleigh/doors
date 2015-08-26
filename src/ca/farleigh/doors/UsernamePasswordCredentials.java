package ca.farleigh.doors;

public class UsernamePasswordCredentials implements Credentials {
  private final String username;
  private final String passcode;

  public UsernamePasswordCredentials(final String username, final String passcode) {
    this.username = username;
    this.passcode = passcode;
  }

  @Override
  public boolean isMatch(final Credentials other) {
    return this.equals(other);
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof UsernamePasswordCredentials)) {
      return false;
    }
    UsernamePasswordCredentials other = (UsernamePasswordCredentials) obj;
    return (this.username == null ? other.username == null : this.username.equals(other.username))
        && (this.passcode == null ? other.passcode == null : this.passcode.equals(other.passcode));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + this.username == null ? 0 : this.username.hashCode();
    result = 31 * result + this.passcode == null ? 0 : this.passcode.hashCode();
    return result;
  }

  /**
   * Return only the identity (the public part of this).
   */
  @Override
  public String toString() {
    return this.username;
  }
}
