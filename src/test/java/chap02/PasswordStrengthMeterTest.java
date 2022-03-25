package src.test.java.chap02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PasswordStrengthMeterTest {

  @Test
  void meetsAllCriteria_Then_Strong() {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();
    PasswordStrength result = meter.meter("ab12!@AB");
    assertEquals(PasswordStrength.STRONG, result);
    PasswordStrength result2 = meter.meter("abc1!Add");
    assertEquals(PasswordStrength.STRONG, result2);

  }
}