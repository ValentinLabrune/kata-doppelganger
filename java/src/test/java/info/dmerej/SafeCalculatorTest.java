package info.dmerej;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Assertions.*;


class AcceptingAuthorizer implements Authorizer {
    @Override
    public boolean authorize() {
        return true;
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
}
