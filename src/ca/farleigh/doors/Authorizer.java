package ca.farleigh.doors;

public interface Authorizer {
  /**
   * Determine whether a user is authorized for a given role
   * @param user The user to check the roles of.
   * @param role The role to check.
   * @return True if a @paramref user has a @paramref role.
   */
  boolean isAuthorized(final User user, final Role role);
}
