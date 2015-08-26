package ca.farleigh.doors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class UsernamePasswordCredentialsTests {
  
  @Test
  public void testIsMatch() {
    final UsernamePasswordCredentials cred = new UsernamePasswordCredentials("William", "password");
    final UsernamePasswordCredentials cred2 = new UsernamePasswordCredentials("William", "password");
    assertTrue(cred.isMatch(cred2));
  }

  @Test
  public void testIsNotMatch() {
    final UsernamePasswordCredentials cred = new UsernamePasswordCredentials("William", "password");
    final UsernamePasswordCredentials cred2 = new UsernamePasswordCredentials("William", "password2");
    assertFalse(cred.isMatch(cred2));
  }
  
  @Test
  public void testReflexive() {
    final UsernamePasswordCredentials cred = new UsernamePasswordCredentials("William", "password");
    assertEquals(cred, cred);
  }

  @Test
  public void testEquals() {
    final UsernamePasswordCredentials cred = new UsernamePasswordCredentials("William", "password");
    final UsernamePasswordCredentials cred2 = new UsernamePasswordCredentials("William", "password");
    assertTrue(cred.equals(cred2));
    assertTrue(cred2.equals(cred));
  }

  @Test
  public void testNotEquals() {
    final UsernamePasswordCredentials cred = new UsernamePasswordCredentials("William", "password");
    final UsernamePasswordCredentials cred2 = new UsernamePasswordCredentials("William", "password2");
    assertFalse(cred.equals(cred2));
    assertFalse(cred2.equals(cred));
  }
  
  @Test
  public void testSameHashCode() {
    final UsernamePasswordCredentials cred = new UsernamePasswordCredentials("William", "password");
    final UsernamePasswordCredentials cred2 = new UsernamePasswordCredentials("William", "password");
    assertEquals(cred.hashCode(), cred2.hashCode());
  }

  @Test
  public void testNotSameHashCode() {
    final UsernamePasswordCredentials cred = new UsernamePasswordCredentials("William", "password");
    final UsernamePasswordCredentials cred2 = new UsernamePasswordCredentials("William", "password2");
    assertNotEquals(cred.hashCode(), cred2.hashCode());
  }
  
}
