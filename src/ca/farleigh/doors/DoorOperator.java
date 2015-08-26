package ca.farleigh.doors;

public interface DoorOperator {
  /**
   * Open the door.
   * @return true if the door opens
   */
  boolean open();

  /**
   * Close the door.
   * @return true if the doors closes
   */
  boolean close();

  /**
   * Gets the current state of the door.
   * @return true if the door is open
   */
  boolean isOpen();
}
