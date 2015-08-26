package ca.farleigh.doors;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoorKnobTests {
  @Test
  public void testDoorOpen() {
    final DoorOperator operator = new SimpleDoorOperator();
    final DoorKnob door = new DoorKnob(operator);
    assertTrue(door.open());
    assertTrue(operator.isOpen());
  }

  @Test
  public void testDoorClosed() {
    final DoorOperator operator = new SimpleDoorOperator();
    final DoorKnob door = new DoorKnob(operator);
    door.open();
    assertTrue(door.close());
    assertFalse(operator.isOpen());
  }
}
