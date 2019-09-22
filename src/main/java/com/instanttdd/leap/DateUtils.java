package com.instanttdd.leap;

public class DateUtils {

  /**
   * Is leap year
   *
   * @param year 4 digit year
   * @return true if leap year
   */
  public static boolean isLeapYear(int year) {
    return isDivisibleBy(year, 4)
        && (!isDivisibleBy(year, 100)
        || isDivisibleBy(year, 400));
  }

  public static boolean isDivisibleBy(int year, int divisor) {
    return year % divisor == 0;
  }
}
