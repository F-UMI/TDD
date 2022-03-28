package src.test.java.chap02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import src.main.java.chap02.PasswordStrength;

class PasswordStrengthMeterTest {

  private PasswordStrengthMeter meter = new PasswordStrengthMeter();

  private void assertStrength(String password, PasswordStrength expStr) {
    PasswordStrength result = meter.meter(password);
    assertEquals(expStr, result);
  }

  @Test
  void meetsAllCriteria_Then_Strong() {
    assertStrength("ab12!@AB", PasswordStrength.STRONG);
    assertStrength("abc1!Add", PasswordStrength.STRONG);
  }

  @Test
  void meetsOtherCriteria_except_for_Length_Then_Normal() {
    assertStrength("ab12!@A", PasswordStrength.NORMAL);
    assertStrength("Ab12!c", PasswordStrength.NORMAL);
  }

  @Test
  void meetsOtherCriteria_except_for_number_Then_Normal() {
    assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);

  }

  @Test
  void nullnput_Then_Invaild() {
    assertStrength(null, PasswordStrength.INVAILD);
  }

  @Test
  void emptyInput_Then_Invaild() {
    assertStrength("", PasswordStrength.INVAILD);
  }

  @Test
  void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
    assertStrength("ab12!@df", PasswordStrength.NORMAL);
  }

  @Test
  void meetsOnlyLengthCriteria_Then_Weak() {
    assertStrength("abcdefghi", PasswordStrength.WEAK);
  }

  @Test
  void meetsOnlyNumCriteria_Then_Weak() {
    assertStrength("12345", PasswordStrength.WEAK);
  }

  @Test
  void meetsOnlyUpperCriteria_Then_Weak() {
    assertStrength("ABCDF", PasswordStrength.WEAK);
  }

  @Test
  void meetsNoCriteria_Then_Weak() {
    assertStrength("abc", PasswordStrength.WEAK);
  }
}