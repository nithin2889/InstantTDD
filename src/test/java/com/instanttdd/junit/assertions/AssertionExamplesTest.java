package com.instanttdd.junit.assertions;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore("Ignoring currently")
public class AssertionExamplesTest {
  @Test
  public void testAssertTrue() {
    Rectangle rectangle = new Rectangle(10, 10);
    assertTrue(rectangle.isSquare());
  }

  @Test
  public void testAssertFalse() {
    Rectangle rectangle = new Rectangle(11, 10);
    assertFalse(rectangle.isSquare());
  }

  @Test
  public void testAssertTrue2() {
    Rectangle rectangle = new Rectangle(10, 10);
    assertTrue("Rectangle with same width and height should be a square", rectangle.isSquare());
  }

  @Test
  public void testAssertNull() {
    Object value = null;
    assertNull(value);
  }

  @Test
  public void testAssertNotNull() {
    Object rectangle = new Rectangle(10,14);
    assertNotNull(rectangle);
  }

  @Test
  public void testAssertEquals() {
    Rectangle rectangle = new Rectangle(10,14);
    assertEquals(140, rectangle.getArea());
  }

  @Ignore("Ignoring currently")
  @Test
  public void testAssertEqualsWithString() {
    assertEquals("Hello\nWorld\nAgain", "Hello\nWORLD\nAgain");
  }

  @Test
  public void testAssertNotEquals() {
    Rectangle rectangle = new Rectangle(10,14);
    assertNotEquals(150, rectangle.getArea());
  }

  @Test
  public void testAssertEqualsWithDouble() {
    double aspectRatio = new Rectangle(1,3).getAspectRatio();
    assertEquals(0.33333333, aspectRatio, 0.0001);
  }

  @Test
  public void testAssertEqualsWithObject() {
    assertEquals(new Rectangle(1,1), new Rectangle(1,1));
  }

  @Test
  public void testAssertSame() {
    Rectangle ex1 = new Rectangle(4, 5);
    Rectangle ex2 = ex1;
    assertSame(ex1, ex2);

    Rectangle duplicateOfEx1 = new Rectangle(4, 5);
    assertNotSame(ex1, duplicateOfEx1);
    assertEquals(ex1, duplicateOfEx1);
  }

  @Test
  public void testAssertFail() {
    Assert.fail("This was never meant to happen.");
  }

  @Test
  public void testAssertArray() {
    Rectangle rectangle = new Rectangle(5, 6);
    assertArrayEquals(new int[] {5, 6}, rectangle.getSides());
  }

  @Test
  public void testAssertList() {
    Rectangle rectangle = new Rectangle(7, 8);
    assertEquals(asList(7, 8), rectangle.getSidesList());
  }
}
