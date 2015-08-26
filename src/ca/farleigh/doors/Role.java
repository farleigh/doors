package ca.farleigh.doors;

public interface Role {
  /**
   * Determines whether @paramref other role is a match for the current role
   * @param role The role to compare against.
   * @return The if @paramref other role matches this role.
   */
  boolean isMatch(final Role other);
}