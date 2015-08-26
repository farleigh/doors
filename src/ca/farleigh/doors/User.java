package ca.farleigh.doors;

import java.util.Collection;
import java.util.Collections;

public class User {

  private final Collection<Credentials> credentials;
  private final Collection<Role> roles;
  private final String username;

  /**
   * Main constructor for the user class.
   * 
   * @param credentials
   *          Used to authenticate user
   * @param roles
   *          A collection of roles used for authorization.
   */
  public User(final String username, final Collection<Credentials> credentials, final Collection<Role> roles) {
    // Set credentials
    if (credentials != null) {
      this.credentials = Collections.unmodifiableCollection(credentials);
    } else {
      this.credentials = Collections.emptyList();
    }
    // Set roles
    if (roles != null) {
      this.roles = Collections.unmodifiableCollection(roles);
    } else {
      this.roles = Collections.emptyList();
    }
    this.username = username;
  }

  public String getName() {
    return this.username;
  }
  
  /**
   * Verifies that this user also has the @paramref passcode.
   * 
   * @param passcode
   *          The passcode to check.
   * @return True if the user has the same passcode.
   */
  public boolean authenticate(Credentials credential) {
    return credentials.stream().anyMatch(c -> c.isMatch(credential));
  }
  
  /**
   * Returns true if the user has the @paramref role.
   * 
   * @param role
   *          The role to check if user is a member of
   * @return True if the user is a member of @paramref role
   */
  public boolean hasRole(final Role role) {
    return roles.stream().anyMatch(r -> r.isMatch(role));
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof User)) {
      return false;
    }
    final User user = (User) obj;
    return this.username == null ? user.username == null : this.username.equals(user.username);
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + this.username == null ? 0 : this.username.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return this.username;
  }
}
