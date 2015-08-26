package ca.farleigh.doors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SimpleLockTests {
  
  @Test
  public void testUnlock() {
    // Mock authenticator
    final Role role = new SimpleRole("Test Role");
    final Collection<Role> roles = Arrays.asList(new Role[] { role });
    final Authenticator authenticator = mock(Authenticator.class);
    final Credentials cred = new UsernamePasswordCredentials("william", "Password");
    final List<Credentials> credentials = Arrays.asList(new Credentials[] { cred });
    final User user = new User("William", credentials, roles);
    when(authenticator.authenticate()).thenReturn(user);
    // Mock authorizer
    final Authorizer authorizer = mock(Authorizer.class);
    when(authorizer.isAuthorized(user, role)).thenReturn(true);
    // Test the locking mechanism
    final LockingMechanism lock = new SimpleLock(authenticator, authorizer, role);
    assertFalse(lock.isUnlocked());
    assertTrue(lock.unlock());
    assertTrue(lock.isUnlocked());
  }
  
  @Test
  public void testLock() {
    // Mock authenticator
    final Role role = new SimpleRole("Test Role");
    final Role role2 = new SimpleRole("Test Role");
    final Collection<Role> roles = Arrays.asList(new Role[] { role });
    final Authenticator authenticator = mock(Authenticator.class);
    final Credentials cred = new UsernamePasswordCredentials("william", "Password");
    final List<Credentials> credentials = Arrays.asList(new Credentials[] { cred });
    final User user = new User("William", credentials, roles);
    when(authenticator.authenticate()).thenReturn(user);
    // Mock authorizer
    final Authorizer authorizer = mock(Authorizer.class);
    when(authorizer.isAuthorized(user, role)).thenReturn(true);
    // Test the locking mechanism
    final LockingMechanism lock = new SimpleLock(authenticator, authorizer, role2);
    assertTrue(lock.unlock());
    assertTrue(lock.isUnlocked());
    assertTrue(lock.lock());
    assertFalse(lock.isUnlocked());
  }  
}
