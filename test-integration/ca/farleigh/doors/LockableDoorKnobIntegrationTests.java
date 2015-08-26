package ca.farleigh.doors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

public class LockableDoorKnobIntegrationTests {
  
  /**
   * Go through the happy path for the door and its lock(s).  
   * Assume a single lock is enough as multiple locks have been tested in test unit tests.
   */
  @Test
  public void testUnlockAndOpenDoorAndThenCloseDoorAndLock() {
    //Set up locked door
    final DoorOperator doorOperator = new SimpleDoorOperator();
    final AuthenticationProvider authenticationProvider = new UserRepositoryAuthenticationProvider(UserRepository.getInstance());
    final PrintStream output = mock(PrintStream.class);
    final SimpleReader reader = mock(SimpleReader.class);
    when(reader.read()).thenReturn("jacob").thenReturn("Password");
    final SimpleWriter writer = new SimpleWriter(output);
    final Authenticator authenticator = new TouchKeyPad(authenticationProvider, reader, writer);
    final Authorizer authorizer = new SimpleAuthorizer();
    final Role role = new SimpleRole("All");
    final LockingMechanism lock = new SimpleLock(authenticator, authorizer, role);
    final Collection<LockingMechanism> locks = Arrays.asList(new LockingMechanism[] { lock });
    final DoorKnob doorKnob = new LockableDoorKnob(doorOperator, locks);
    // First attempt to unlock lock
    assertTrue(lock.unlock());
    assertTrue(lock.isUnlocked());
    // Next attempt to open door
    assertTrue(doorKnob.open());
    // Next try to close door
    assertTrue(doorKnob.close());
    // Finally, try to lock door
    assertTrue(lock.lock());
  }

  /**
   * Attempt to lock the door before closing it.
   * This will work since the system does not prevent this.
   */
  @Test
  public void testLockAndCloseDoor() {
    //Set up locked door
    final DoorOperator doorOperator = new SimpleDoorOperator();
    final AuthenticationProvider authenticationProvider = new UserRepositoryAuthenticationProvider(UserRepository.getInstance());
    final PrintStream output = mock(PrintStream.class);
    final SimpleReader reader = mock(SimpleReader.class);
    when(reader.read()).thenReturn("jacob").thenReturn("Password");
    final SimpleWriter writer = new SimpleWriter(output);
    final Authenticator authenticator = new TouchKeyPad(authenticationProvider, reader, writer);
    final Authorizer authorizer = new SimpleAuthorizer();
    final Role role = new SimpleRole("All");
    final LockingMechanism lock = new SimpleLock(authenticator, authorizer, role);
    final Collection<LockingMechanism> locks = Arrays.asList(new LockingMechanism[] { lock });
    final DoorKnob doorKnob = new LockableDoorKnob(doorOperator, locks);
    // First attempt to unlock lock
    assertTrue(lock.unlock());
    assertTrue(lock.isUnlocked());
    // Next attempt to open door
    assertTrue(doorKnob.open());
    // Finally, try to unlock the unlocked door
    assertTrue(lock.lock());
    // Next try to close door
    assertTrue(doorKnob.close());
  }
  
  /**
   * Check for an invalid user.
   * Assume a single lock is enough as multiple locks have been tested in test unit tests.
   */
  @Test
  public void testInvalidUser() {
    //Set up locked door
    final AuthenticationProvider authenticationProvider = new UserRepositoryAuthenticationProvider(UserRepository.getInstance());
    final PrintStream output = mock(PrintStream.class);
    final SimpleReader reader = mock(SimpleReader.class);
    when(reader.read()).thenReturn("thief").thenReturn("Password");
    final SimpleWriter writer = new SimpleWriter(output);
    final Authenticator authenticator = new TouchKeyPad(authenticationProvider, reader, writer);
    final Authorizer authorizer = new SimpleAuthorizer();
    final Role role = new SimpleRole("All");
    final LockingMechanism lock = new SimpleLock(authenticator, authorizer, role);
    // First attempt to unlock lock
    assertFalse(lock.unlock());
    assertFalse(lock.isUnlocked());
  }
  
  /**
   * Check for an invalid user.
   * Assume a single lock is enough as multiple locks have been tested in test unit tests.
   */
  @Test
  public void testUserRole() {
    //Set up locked door
    final DoorOperator doorOperator = new SimpleDoorOperator();
    final AuthenticationProvider authenticationProvider = new UserRepositoryAuthenticationProvider(UserRepository.getInstance());
    final PrintStream output = mock(PrintStream.class);
    final SimpleReader reader = mock(SimpleReader.class);
    when(reader.read()).thenReturn("jacob").thenReturn("Password");
    final SimpleWriter writer = new SimpleWriter(output);
    final Authenticator authenticator = new TouchKeyPad(authenticationProvider, reader, writer);
    final Authorizer authorizer = new SimpleAuthorizer();
    final Role role = new SimpleRole("Super Awesome Role");
    final LockingMechanism lock = new SimpleLock(authenticator, authorizer, role);
    // First attempt to unlock lock
    assertFalse(lock.unlock());
    assertFalse(lock.isUnlocked());
  }
}
