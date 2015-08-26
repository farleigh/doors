package ca.farleigh.doors;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleDoorOperatorTests {

  @Test
  public void testDoorOperatorStartsClosed() {
    DoorOperator operator = new SimpleDoorOperator();
    assertFalse(operator.isOpen());
  }

  @Test
  public void testOpenDoor() {
    DoorOperator operator = new SimpleDoorOperator();
    assertTrue(operator.open());
    assertTrue(operator.isOpen());
  }

  @Test
  public void testCloseDoor() {
    DoorOperator operator = new SimpleDoorOperator();
    assertTrue(operator.open());
    assertTrue(operator.close());
  }

  @Test
  public void testOpenOpenedDoor() {
    DoorOperator operator = new SimpleDoorOperator();
    assertTrue(operator.open());
    assertFalse(operator.open());
    assertTrue(operator.isOpen());
  }

  @Test
  public void testCloseClosedDoor() {
    DoorOperator operator = new SimpleDoorOperator();
    assertFalse(operator.close());
    assertFalse(operator.isOpen());
  }
}
