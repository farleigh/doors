package ca.farleigh.doors;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UserTests {
  
  @Test
  public void testUsername() {
    final Collection<Role> roles = Arrays.asList(new Role[] { new SimpleRole("My Role") });
    final Credentials cred = new UsernamePasswordCredentials("william", "not 1234");
    final List<Credentials> credentials = Arrays.asList(new Credentials[] { cred });
    final User william = new User("william", credentials, roles);
    assertEquals("william", william.getName());
  }

  @Test
  public void testPasscode() {
    final Collection<Role> roles = Arrays.asList(new Role[] { new SimpleRole("My Role") });
    final Credentials cred = new UsernamePasswordCredentials("william", "My Password");
    final List<Credentials> credentials = Arrays.asList(new Credentials[] { cred });
    final User william = new User("william", credentials, roles);
    assertTrue(william.authenticate(new UsernamePasswordCredentials("william", "My Password")));
  }

  @Test
  public void testInvalidPasscode() {
    final Collection<Role> roles = Arrays.asList(new Role[] { new SimpleRole("My Role") });
    final Credentials cred = new UsernamePasswordCredentials("william", "Password");
    final List<Credentials> credentials = Arrays.asList(new Credentials[] { cred });
    final User william = new User("william", credentials, roles);
    assertFalse(william.authenticate(new UsernamePasswordCredentials("william", "Not Password")));
  }

  @Test
  public void testHasRole() {
    final Collection<Role> roles = Arrays.asList(new Role[] { new SimpleRole("My Role") });
    final Credentials cred = new UsernamePasswordCredentials("william", "Password");
    final List<Credentials> credentials = Arrays.asList(new Credentials[] { cred });
    final User william = new User("william", credentials, roles);
    assertTrue(william.hasRole(new SimpleRole("My Role")));
  }

  @Test
  public void testDoesNotHaveRole() {
    final Collection<Role> roles = Arrays.asList(new Role[] { new SimpleRole("My Role") });
    final Credentials cred = new UsernamePasswordCredentials("william", "Password");
    final List<Credentials> credentials = Arrays.asList(new Credentials[] { cred });
    final User william = new User("william", credentials, roles);
    assertFalse(william.hasRole(new SimpleRole("Not My Role")));
  }

  @Test
  public void testEqualsReflexive() {
    final User jake = new User("jake", null, null);
    assertTrue(jake.equals(jake));
  }

  @Test
  public void testEqualsIfSameUsername() {
    final Collection<Role> roles = Arrays.asList(new Role[] { new SimpleRole("My Role") });
    final Credentials cred = new UsernamePasswordCredentials("jacob", "Password");
    final List<Credentials> credentials = Arrays.asList(new Credentials[] { cred });
    final User jacob1 = new User("jacob", credentials, roles);
    final User jacob2 = new User("jacob", credentials, roles);
    assertTrue(jacob1.equals(jacob2));
    assertTrue(jacob2.equals(jacob1));
  }

  @Test
  public void testNotEqualIfDifferentUsername() {
    final Collection<Role> roles1 = Arrays.asList(new Role[] { new SimpleRole("My Role") });
    final Credentials cred1 = new UsernamePasswordCredentials("william", "Password");
    final List<Credentials> credentials1 = Arrays.asList(new Credentials[] { cred1 });
    final Collection<Role> roles2 = Arrays.asList(new Role[] { new SimpleRole("My Role") });
    final Credentials cred2 = new UsernamePasswordCredentials("jacob", "Password 2");
    final List<Credentials> credentials2 = Arrays.asList(new Credentials[] { cred2 });
    final User william = new User("william", credentials1, roles1);
    final User jacob = new User("jacob", credentials2, roles2);
    assertFalse(william.equals(jacob));
  }

  @Test
  public void testHashCodeEqual() {
    final Collection<Role> roles1 = Arrays.asList(new Role[] { new SimpleRole("My Role 1") });
    final Credentials cred1 = new UsernamePasswordCredentials("jacob", "Password 1");
    final List<Credentials> credentials1 = Arrays.asList(new Credentials[] { cred1 });
    final Collection<Role> roles2 = Arrays.asList(new Role[] { new SimpleRole("My Role 2") });
    final Credentials cred2 = new UsernamePasswordCredentials("jacob", "Password 2");
    final List<Credentials> credentials2 = Arrays.asList(new Credentials[] { cred2 });
    final User jacob1 = new User("jacob", credentials1, roles1);
    final User jacob2 = new User("jacob", credentials2, roles2);
    assertTrue(jacob1.hashCode() == jacob2.hashCode());
  }

  @Test
  public void testToString() {
    final Collection<Role> roles = Arrays.asList(new Role[] { new SimpleRole("My Role") });
    final Credentials cred = new UsernamePasswordCredentials("william", "Password");
    final List<Credentials> credentials = Arrays.asList(new Credentials[] { cred });
    final User william = new User("william", credentials, roles);
    assertEquals("william", william.toString());
  }
}
