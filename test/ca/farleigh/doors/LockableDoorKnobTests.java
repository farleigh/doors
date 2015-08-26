package ca.farleigh.doors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

public class LockableDoorKnobTests {

  @Test
  public void testDoorOpenableWhenUnlocked() {
    final DoorOperator operator = new SimpleDoorOperator();
    final LockingMechanism lock = mock(LockingMechanism.class);
    when(lock.isUnlocked()).thenReturn(true);
    final Collection<LockingMechanism> locks = Arrays.asList(new LockingMechanism[] { lock });
    final DoorKnob door = new LockableDoorKnob(operator, locks);
    assertTrue(door.open());
  }

  @Test
  public void testDoorOpenableWhenAllLocksUnlocked() {
    final DoorOperator operator = new SimpleDoorOperator();
    final LockingMechanism lock = mock(LockingMechanism.class);
    when(lock.isUnlocked()).thenReturn(true);
    final LockingMechanism lock2 = mock(LockingMechanism.class);
    when(lock2.isUnlocked()).thenReturn(true);
    final Collection<LockingMechanism> locks = Arrays.asList(new LockingMechanism[] { lock, lock2 });
    final DoorKnob door = new LockableDoorKnob(operator, locks);
    assertTrue(door.open());
  }

  @Test
  public void testDoorNotOpenableWhenLocked() {
    final DoorOperator operator = new SimpleDoorOperator();
    final LockingMechanism lock = mock(LockingMechanism.class);
    when(lock.isUnlocked()).thenReturn(false);
    final Collection<LockingMechanism> locks = Arrays.asList(new LockingMechanism[] { lock });
    final DoorKnob door = new LockableDoorKnob(operator, locks);
    assertFalse(door.open());
  }

  @Test
  public void testDoorNotOpenableWhenAllLocksLocked() {
    final DoorOperator operator = new SimpleDoorOperator();
    final LockingMechanism lock = mock(LockingMechanism.class);
    when(lock.isUnlocked()).thenReturn(false);
    final LockingMechanism lock2 = mock(LockingMechanism.class);
    when(lock2.isUnlocked()).thenReturn(false);
    final Collection<LockingMechanism> locks = Arrays.asList(new LockingMechanism[] { lock, lock2 });
    final DoorKnob door = new LockableDoorKnob(operator, locks);
    assertFalse(door.open());
  }
  
  @Test
  public void testDoorNotOpenableWhenSomeLocksLocked() {
    final DoorOperator operator = new SimpleDoorOperator();
    final LockingMechanism lock = mock(LockingMechanism.class);
    when(lock.isUnlocked()).thenReturn(true);
    final LockingMechanism lock2 = mock(LockingMechanism.class);
    when(lock2.isUnlocked()).thenReturn(false);
    final Collection<LockingMechanism> locks = Arrays.asList(new LockingMechanism[] { lock, lock2 });
    final DoorKnob door = new LockableDoorKnob(operator, locks);
    assertFalse(door.open());
  }
}
