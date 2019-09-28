package com.instanttdd.junit.assertions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Refactored to use assertThat and Hamcrest - most of which is automatically included by JUnit in
 * "hamcrest-core" though "hamcrest-all" has been added to the project to support comparison of
 * doubles.
 */
public class AssertionHamcrestTest {
  @Test
  public void tryAssertTrue() {
    Rectangle rectangle = new Rectangle(10, 10);
    assertThat(rectangle.isSquare(), is(true));
  }

  @Test
  public void tryAssertFalse() {
    Rectangle rectangle = new Rectangle(10, 9);
    assertThat(rectangle.isSquare(), is(false));
  }

  @Test
  public void tryAssertTrue2() {
    Rectangle rectangle = new Rectangle(10, 10);
    assertThat(
        "Rectangle with same width and height should be square", rectangle.isSquare(), is(true));
  }

  @Test
  public void tryAssertNull() {
    Object value = null;
    assertThat(value, nullValue());
  }

  @Test
  public void tryAssertNotNull() {
    Object value = new Rectangle(1, 1);
    assertThat(value, is(not(nullValue())));
  }

  @Test
  public void tryAssertEquals() {
    assertThat(new Rectangle(2, 8).getArea(), is(16));
    assertThat(new Rectangle(2, 8).getArea(), equalTo(16));
    assertThat(new Rectangle(2, 8).getArea(), is(equalTo(16)));
  }

  @Test
  public void tryAssertEqualsWithStrings() {
    assertThat("Hello\nWorld\nOla", is("Hello\nWorld\nOla"));
  }

  @Test
  public void tryAssertNotEquals() {
    assertThat(new Rectangle(2, 8).getArea(), is(not(equalTo(13))));
  }

  @Test
  public void tryAssertEqualsWithDouble() {
    double aspectRatio = new Rectangle(1, 3).getAspectRatio();
    assertThat(aspectRatio, closeTo(0.333333333333333, 0.01));
  }

  @Test
  public void tryAssertEqualsWithObject() {
    assertThat(new Rectangle(1, 3), is(new Rectangle(1, 3)));
  }

  @Test
  public void tryAssertSame() {
    Rectangle rectangle1 = new Rectangle(1, 1);
    Rectangle rectangle2 = rectangle1;
    assertThat(rectangle1, is(sameInstance(rectangle2)));

    Rectangle rectangleDuplicateAsRectangle1 = new Rectangle(1, 1);
    assertThat(rectangle1, is(not(sameInstance(rectangleDuplicateAsRectangle1))));
    assertThat(rectangle1, equalTo(rectangleDuplicateAsRectangle1));
  }

  @Test
  public void tryAssertArray() {
    Rectangle rectangle = new Rectangle(2, 3);
    // assertThat(rectangle.getSides(), arrayContaining(2, 3));
    // !!! there's no easy way to do this
    // external matcher library - or convert
  }

  @Test
  public void tryAssertList() {
    Rectangle rectangle = new Rectangle(2, 3);
    assertThat(rectangle.getSidesList(), contains(2, 3));
  }
}
