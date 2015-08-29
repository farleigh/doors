package ca.farleigh.doors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class KeyCardCredentialsTests {

  @Test
  public void testIsMatch() {
    final KeyCardCredentials cred = new KeyCardCredentials("1234");
    final KeyCardCredentials cred2 = new KeyCardCredentials("1234");
    assertTrue(cred.isMatch(cred2));
  }

  @Test
  public void testIsNotMatch() {
    final KeyCardCredentials cred = new KeyCardCredentials("1234");
    final KeyCardCredentials cred2 = new KeyCardCredentials("0123");
    assertFalse(cred.isMatch(cred2));
  }

  @Test
  public void testReflexive() {
    final KeyCardCredentials cred = new KeyCardCredentials("1234");
    assertEquals(cred, cred);
  }

  @Test
  public void testEquals() {
    final KeyCardCredentials cred = new KeyCardCredentials("1234");
    final KeyCardCredentials cred2 = new KeyCardCredentials("1234");
    assertTrue(cred.equals(cred2));
    assertTrue(cred2.equals(cred));

  }

  @Test
  public void testNotEquals() {
    final KeyCardCredentials cred = new KeyCardCredentials("1234");
    final KeyCardCredentials cred2 = new KeyCardCredentials("12345");
    assertFalse(cred.equals(cred2));
    assertFalse(cred2.equals(cred));

  }

  @Test
  public void testSameHashCode() {
    final KeyCardCredentials cred = new KeyCardCredentials("1234");
    final KeyCardCredentials cred2 = new KeyCardCredentials("1234");
    assertEquals(cred.hashCode(), cred2.hashCode());
  }

  @Test
  public void testNotSameHashCode() {
    final KeyCardCredentials cred = new KeyCardCredentials("1234");
    final KeyCardCredentials cred2 = new KeyCardCredentials("12345");
    assertFalse(cred.hashCode() == cred2.hashCode());
  }

}
