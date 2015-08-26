package ca.farleigh.doors;

public class SimpleLock implements LockingMechanism {
  private final Authenticator authenticator;
  private final Authorizer authorizer;
  private final Role role;
  private boolean locked = true;

  public SimpleLock(final Authenticator authenticator, final Authorizer authorizer, final Role role) {
    this.authenticator = authenticator;
    this.authorizer = authorizer;
    this.role = role;
  }

  @Override
  public boolean unlock() {
    final User user = authenticator.authenticate();
    if (!locked || user == null || !authorizer.isAuthorized(user, role)) {
      return false;
    }
    locked = false;
    return true;
  }

  @Override
  public boolean lock() {
    if (locked) {
      return false;
    }
    locked = true;
    return true;
  }

  @Override
  public boolean isUnlocked() {
    return !locked;
  }
}