package ca.farleigh.doors;

public class SimpleRole implements Role {

  private final String role;

  public SimpleRole(final String role) {
    this.role = role;
  }

  @Override
  public boolean isMatch(Role role) {
    return this.equals(role);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof SimpleRole)) {
      return false;
    }
    final SimpleRole role = (SimpleRole) obj;
    return this.role == null ? role.role == null : this.role.equals(role.role);
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + this.role.hashCode();
    return result;
  }
}
