package ca.farleigh.doors;

public class KeyCardCredentials implements Credentials {

  private final String keySequence;

  public KeyCardCredentials(final String keySequence) {
    this.keySequence = keySequence;
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
    if (!(obj instanceof KeyCardCredentials)) {
      return false;
    }
    KeyCardCredentials other = (KeyCardCredentials) obj;
    return this.keySequence == null ? other.keySequence == null : this.keySequence.equals(other.keySequence);
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = result * 31 + this.keySequence == null ? 0 : this.keySequence.hashCode();
    return result;
  }
}
