package ca.farleigh.doors;

public interface LockingMechanism {
  
  /**
   * Lock the door.
   * @return True if the door locks
   */
  boolean lock();

  /**
   * Unlock the door.
   * @return True if the door unlocks
   */
  boolean unlock();

  /**
   * Returns true if the door is currently unlocked.
   */
  boolean isUnlocked();
}
