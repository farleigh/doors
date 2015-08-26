package ca.farleigh.doors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class SimpleAuthorizerTests {
  @Test
  public void testIsAuthorizedWhenAuthorized() {
    final SimpleAuthorizer authorizer = new SimpleAuthorizer();
    final User user = mock(User.class);
    final Role role = mock(Role.class);
    when(user.hasRole(role)).thenReturn(true);
    assertTrue(authorizer.isAuthorized(user, role));
  }

  @Test
  public void testIsAuthorizedWhenNotAuthorized() {
    final SimpleAuthorizer authorizer = new SimpleAuthorizer();
    final User user = mock(User.class);
    final Role role = mock(Role.class);
    when(user.hasRole(role)).thenReturn(false);
    assertFalse(authorizer.isAuthorized(user, role));
  }
}
