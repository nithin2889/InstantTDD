package com.instanttdd.junit.assertions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AssertTimeout {
  public static int someLongRoutine() {
    while (true) {
      // this will take forever
    }
  }

  @Test(timeout = 100L)
  public void testThingThatMayRunForever() {
    assertEquals(42, someLongRoutine());
  }
}
