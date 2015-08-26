package ca.farleigh.doors;

public class SimpleAuthorizer implements Authorizer {

  /**
   * Determines whether the user is authorized for the given role.
   */
  @Override
  public boolean isAuthorized(final User user, final Role role) {
    return user.hasRole(role);
  }

}
