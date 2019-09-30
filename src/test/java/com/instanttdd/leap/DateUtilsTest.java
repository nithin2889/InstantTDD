package com.instanttdd.leap;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DateUtilsTest {

  @Parameter(0)
  public int year;

  @Parameter(1)
  public boolean shouldBeLeap;

  @Parameters(name = "The year {0,number,####} should have leap year as {1}")
  public static Object[][] parameters() {
    return new Object[][] {{1992, true}, {1996, true}, {1991, false}, {1900, false}, {2000, true}};
  }

  @Test
  public void isLeapYear() {
    assertThat(DateUtils.isLeapYear(year)).isEqualTo(shouldBeLeap);
  }

  /*@Test
  public void normalLeapYearIsLeap() {
    assertTrue(isLeapYear(1992));
  }

  @Test
  public void normalLeapYearExample2IsLeap() {
    assertTrue(isLeapYear(1996));
  }

  @Test
  public void nonLeapYearIsNotLeap() {
    assertFalse(isLeapYear(1991));
  }

  @Test
  public void centuryYearsAreNotLeap() {
    assertFalse(isLeapYear(1900));
  }

  @Test
  public void year2000WasLeap() {
    assertTrue(isLeapYear(2000));
  }*/

}
