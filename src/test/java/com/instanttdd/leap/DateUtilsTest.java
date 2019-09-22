package com.instanttdd.leap;

import static com.instanttdd.leap.DateUtils.isLeapYear;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DateUtilsTest {

  @Test
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
  }

}
