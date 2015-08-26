package ca.farleigh.doors;

public interface AuthenticationProvider {
  User authenticate(final Credentials credentials);
}
