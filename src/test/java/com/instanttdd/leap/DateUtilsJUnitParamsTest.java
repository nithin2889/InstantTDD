package com.instanttdd.leap;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class DateUtilsJUnitParamsTest {

  private Object parametersForIsLeapYear() {
    return new Object[][] {{1992, true}, {1996, true}, {1991, false}, {1900, false}, {2000, true}};
  }

  @Test
  @Parameters
  @TestCaseName("The year {0} should have leap year as {1}")
  public void isLeapYear(int year, boolean shouldBeLeap) {
    assertThat(DateUtils.isLeapYear(year)).isEqualTo(shouldBeLeap);
  }
}
