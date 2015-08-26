package ca.farleigh.doors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * A hardcoded set of users.
 */
public class UserRepository {

  private static final UserRepository repository = new UserRepository();
  
  private final Collection<User> users = new ArrayList<User>();

  /**
   * Private constructor - we don't want people instantiating this class directly.
   */
  private UserRepository() {
    final List<Role> roles = new ArrayList<Role>();
    roles.add(new SimpleRole("All"));
    final List<Credentials> jacobCreds = new ArrayList<Credentials>();
    jacobCreds.add(new UsernamePasswordCredentials("jacob", "Password"));
    final User jacob = new User("jacob", jacobCreds, roles);
    final List<Credentials> williamCreds = new ArrayList<Credentials>();
    williamCreds.add(new UsernamePasswordCredentials("william", "Password2"));   
    final User william = new User("william", williamCreds, Collections.emptyList());
    users.add(jacob);
    users.add(william);
  }

  /**
   * A static "factory method" (as discussed in Bloch's Effective Java 2nd Ed.).
   * In this implementation it is used to enforce UserRepository as a singleton.
   */
  public static UserRepository getInstance() {
    return repository;
  }

  /**
   * Get all users in the system.
   * @return All users in the system.
   */
  public Collection<User> getUsers() {
    return Collections.unmodifiableCollection(users);
  }
}
