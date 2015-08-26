package ca.farleigh.doors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TouchKeyPadTests {
  
  @Test
  public void testWriter() {
    // Mock authentication provider
    final AuthenticationProvider ap = mock(AuthenticationProvider.class);
    // Mock input
    final SimpleReader reader = mock(SimpleReader.class);
    // Mock output
    final SimpleWriter writer = mock(SimpleWriter.class);
    // Run test
    final Authenticator keyPad = new TouchKeyPad(ap, reader, writer);
    keyPad.authenticate();
    verify(writer).write(TouchKeyPad.enterUsernameText);
    verify(writer).write(TouchKeyPad.enterPasswordText);   
  }
  
  @Test
  public void testAuthenticated() {
    // Mock authentication provider
    final AuthenticationProvider ap = mock(AuthenticationProvider.class);
    final Collection<Role> roles = Arrays.asList(new Role[]{new SimpleRole("Test Role")});
    final Credentials realCreds = new UsernamePasswordCredentials("william", "1234");
    final List<Credentials> credentials = Arrays.asList(new Credentials[] { realCreds });
    final User william = new User("william", credentials, roles);
    when(ap.authenticate(realCreds)).thenReturn(william);
    // Mock input
    final SimpleReader reader = mock(SimpleReader.class);
    when(reader.read()).thenReturn("william").thenReturn("1234");   
    // Mock output
    final SimpleWriter writer = mock(SimpleWriter.class);
    // Run test
    final Authenticator keyPad = new TouchKeyPad(ap, reader, writer);
    final User user = keyPad.authenticate();
    assertNotNull(user);
  }
  
  @Test
  public void testNotAuthenticated() {
    // Mock authentication provider
    final AuthenticationProvider ap = mock(AuthenticationProvider.class);
    final Credentials enteredCreds = new UsernamePasswordCredentials("william", "1234");
    final Credentials realCreds = new UsernamePasswordCredentials("william", "not 1234");
    final List<Credentials> credentials = Arrays.asList(new Credentials[] { realCreds });
    final Collection<Role> roles = Arrays.asList(new Role[]{new SimpleRole("Test Role")});
    final User william = new User("william", credentials, roles);
    when(ap.authenticate(enteredCreds)).thenReturn(null);
    when(ap.authenticate(realCreds)).thenReturn(william);
    // Mock input
    final SimpleReader reader = mock(SimpleReader.class);
    when(reader.read()).thenReturn("william").thenReturn("1234");   
    // Mock output
    final SimpleWriter writer = mock(SimpleWriter.class);
    // Run test
    final Authenticator keyPad = new TouchKeyPad(ap, reader, writer);
    final User user = keyPad.authenticate();
    assertNull(user);
  }
}
