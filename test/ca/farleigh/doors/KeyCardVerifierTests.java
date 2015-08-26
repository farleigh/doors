package ca.farleigh.doors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class KeyCardVerifierTests {
  @Test
  public void testAuthenticated() {
    // Mock authentication provider
    final AuthenticationProvider ap = mock(AuthenticationProvider.class);
    final Collection<Role> roles = Arrays.asList(new Role[]{new SimpleRole("Test Role")});
    final Credentials creds = new KeyCardCredentials("1234");
    final List<Credentials> credentials = Arrays.asList(new Credentials[] { creds });
    final User william = new User("william", credentials, roles);
    when(ap.authenticate(creds)).thenReturn(william);
    // Mock input
    final SimpleReader reader = mock(SimpleReader.class);
    when(reader.read()).thenReturn("1234");
    // Run test
    final Authenticator keyPad = new KeyCardVerifier(ap, reader);
    final User user = keyPad.authenticate();
    assertNotNull(user);
  }
  
  @Test
  public void testNotAuthenticated() {
    // Mock authentication provider
    final AuthenticationProvider ap = mock(AuthenticationProvider.class);
    final Credentials enteredCreds = new KeyCardCredentials("1234");
    final Credentials realCreds = new KeyCardCredentials("not 1234");
    final List<Credentials> credentials = Arrays.asList(new Credentials[] { realCreds });
    final Collection<Role> roles = Arrays.asList(new Role[]{new SimpleRole("Test Role")});
    final User william = new User("william", credentials, roles);
    when(ap.authenticate(enteredCreds)).thenReturn(null);
    when(ap.authenticate(realCreds)).thenReturn(william);
    // Mock input
    final SimpleReader reader = mock(SimpleReader.class);
    when(reader.read()).thenReturn("1234");  
    // Run test
    final Authenticator keyPad = new KeyCardVerifier(ap, reader);
    final User user = keyPad.authenticate();
    assertNull(user);
  }
}
