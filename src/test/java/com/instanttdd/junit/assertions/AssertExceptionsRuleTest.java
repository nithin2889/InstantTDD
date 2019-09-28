package com.instanttdd.junit.assertions;

import java.io.IOException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AssertExceptionsRuleTest {
  @Rule public ExpectedException expectedException = ExpectedException.none();

  private static void willThrow() throws IOException {
    throw new IOException("Bang");
  }

  @Test
  public void willThrowError() throws Exception {
    expectedException.expect(IOException.class);
    expectedException.expectMessage("ang");
    willThrow();
  }

  @Test
  public void willThrowError2() throws Exception {}
}
