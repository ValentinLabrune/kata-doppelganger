package info.dmerej;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class AcceptingAuthorizer implements Authorizer {
    @Override
    public boolean authorize() {
        return true;
    }
  }

  class RefusingAuthorizer implements Authorizer {
      @Override
      public boolean authorize() {
          return false;
      }
  }

public class SafeCalculatorTest {
  @Test
  void should_not_throw_when_authorized() {
    int left = 1;
    int right = 2;
    SafeCalculator safeCalculator = new SafeCalculator(new AcceptingAuthorizer());
    assertEquals(3, safeCalculator.add(left, right));
  }
    @Test
    void should_throw_when_not_authorized() {
        int left = 1;
        int right = 2;
        SafeCalculator safeCalculator = new SafeCalculator(new RefusingAuthorizer());
        assertEquals("Not authorized", safeCalculator.add(left, right));
    }
    @Test
    void should_not_throw_when_authorized_with_mock() {
      int left = 1;
      int right = 2;
      Authorizer authorizer = mock(Authorizer.class);
      when(authorizer.authorize()).thenReturn(true);;
      SafeCalculator safeCalculator = new SafeCalculator(authorizer);
      assertEquals(3, safeCalculator.add(left, right));

    }
    @Test
    void should_throw_when_not_authorized_with_mock() {
        int left = 1;
        int right = 2;
        Authorizer authorizer = mock(Authorizer.class);
        when(authorizer.authorize()).thenReturn(false);;
        SafeCalculator safeCalculator = new SafeCalculator(authorizer);
        assertEquals("Not authorized", safeCalculator.add(left, right));

  }
}




