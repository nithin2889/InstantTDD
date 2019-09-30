package com.instanttdd.junit.assertions;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.IOException;
import org.junit.Test;

public class AssertExceptionsAssertJTest {
  private static void willThrow() throws IOException {
    throw new IOException("Bang!!");
  }

  @Test
  public void willThrowThrows() throws Exception {
    assertThatThrownBy(AssertExceptionsAssertJTest::willThrow)
        .isInstanceOf(IOException.class)
        .hasMessage("Bang!!");

    // We can do final checks here which is not possible in Hamcrest and JUnit
  }
}
