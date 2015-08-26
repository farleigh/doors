package ca.farleigh.doors;

/**
 * Provides a simple door opening and closing ability.
 */
public class SimpleDoorOperator implements DoorOperator {

  private boolean isOpen = false;

  @Override
  public boolean open() {
    if (isOpen()) {
      return false;
    }
    isOpen = true;
    return isOpen;
  }

  @Override
  public boolean close() {
    if (!isOpen()) {
      return false;
    }
    isOpen = false;
    return !isOpen;
  }

  @Override
  public boolean isOpen() {
    return isOpen;
  }
}
