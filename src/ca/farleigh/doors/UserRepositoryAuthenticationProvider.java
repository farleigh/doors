package ca.farleigh.doors;

import java.util.Optional;
import java.util.stream.Stream;

public class UserRepositoryAuthenticationProvider implements AuthenticationProvider {

  private final UserRepository repository;

  public UserRepositoryAuthenticationProvider(final UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public User authenticate(final Credentials credentials) {
    Stream<User> users = repository.getUsers().stream().filter(user -> authenticate(user, credentials));
    final Optional<User> user = users.findFirst();
    if (!user.isPresent()) {
      return null;
    }
    return user.get();
  }

  private static boolean authenticate(final User user, final Credentials credentials) {
    if (user == null || credentials == null) {
      return false;
    }
    return user.authenticate(credentials);
  }
}
