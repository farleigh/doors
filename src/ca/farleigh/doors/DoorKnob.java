package ca.farleigh.doors;

public class DoorKnob {

  private final DoorOperator operator;

  public DoorKnob(final DoorOperator operator) {
    this.operator = operator;
  }

  /**
   * Open the door.
   * 
   * @return True if the door knob opens or false if it remains shut
   */
  public final boolean open() {
    if (!isOpenable()) {
      return false;
    }
    return operator.open();
  }

  /**
   * Indicates that the door knob is openable. Generally the door is not
   * openable if it is closed. This method can be overridden in subclasses to
   * specialize behavior.
   * 
   * @return True if the door knob is currently openable
   */
  protected boolean isOpenable() {
    return true;
  }

  /**
   * Close the door.
   * 
   * @return True if the door knob closes or false if it remains open
   */
  public final boolean close() {
    if (!isCloseable()) {
      return false;
    }
    return operator.close();
  }

  /**
   * Determines whether the door is closeable. This method can be overridden in
   * subclasses to specialize behavior.
   * 
   * @return True if the door is closeable
   */
  protected boolean isCloseable() {
    return true;
  }
}
