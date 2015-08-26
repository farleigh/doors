package ca.farleigh.doors;

import java.util.Collection;
import java.util.Collections;

public class LockableDoorKnob extends DoorKnob {

  private final Collection<LockingMechanism> locks;

  public LockableDoorKnob(final DoorOperator operator, final Collection<LockingMechanism> locks) {
    super(operator);
    this.locks = Collections.unmodifiableCollection(locks);
  }

  /**
   * Check that the door is openable and then verify that the door is unlocked.
   */
  @Override
  protected boolean isOpenable() {
    if (!super.isOpenable()) {
      return false;
    }
    return locks.stream().allMatch(l -> l.isUnlocked());
  }
}
