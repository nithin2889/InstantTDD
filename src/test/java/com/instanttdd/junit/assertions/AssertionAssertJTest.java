package com.instanttdd.junit.assertions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import org.junit.Test;

/** Assertion examples using assertJ */
public class AssertionAssertJTest {
  @Test
  public void tryAssertTrue() {
    Rectangle rectangle = new Rectangle(8, 8);
    assertThat(rectangle.isSquare()).isTrue();
  }

  @Test
  public void tryAssertFalse() {
    Rectangle rectangle = new Rectangle(2, 8);
    assertThat(rectangle.isSquare()).isFalse();
  }

  @Test
  public void tryAssertTrue2() {
    Rectangle rectangle = new Rectangle(10, 10);
    assertThat(rectangle.isSquare())
        .describedAs("Rectangle with same width and height should be a square")
        .isTrue();
  }

  @Test
  public void tryAssertNull() {
    Object value = null;
    assertThat(value).isNull();
  }

  @Test
  public void tryAssertNotNull() {
    Object value = new Rectangle(10, 2);
    assertThat(value).isNotNull();
  }

  @Test
  public void tryAssertEquals() {
    assertThat(new Rectangle(2, 4).getArea()).isEqualTo(8);
  }

  @Test
  public void tryAssertEqualsWithStrings() {
    assertThat("Hello\nWorld\nNow").isEqualTo("Hello\nWorld\nNow");
  }

  @Test
  public void tryAssertNotEquals() {
    assertThat(new Rectangle(3, 4).getArea()).isNotEqualTo(999);
  }

  @Test
  public void tryAssertEqualsWithDouble() {
    assertThat(new Rectangle(1, 3)
        .getAspectRatio())
        .isCloseTo(0.3333333333333, offset(0.01));
  }

  @Test
  public void tryAssertEqualsWithObject() {
    assertThat(new Rectangle(1, 1)).isEqualTo(new Rectangle(1, 1));
  }

  @Test
  public void tryAssertSame() {
    Rectangle rectangle1 = new Rectangle(2, 3);
    Rectangle rectangle2 = rectangle1;

    assertThat(rectangle1).isSameAs(rectangle2);

    Rectangle rectangleDuplicateAsRectangle1 = new Rectangle(2, 3);
    assertThat(rectangle1).isNotSameAs(rectangleDuplicateAsRectangle1);
    assertThat(rectangle1).isEqualTo(rectangleDuplicateAsRectangle1);
  }

  @Test
  public void tryAssertArray() {
    Rectangle rectangle = new Rectangle(5, 6);
    assertThat(rectangle.getSides()).containsExactly(5, 6);
  }

  @Test
  public void tryAssertList() {
    Rectangle rectangle = new Rectangle(7, 8);
    assertThat(rectangle.getSidesList()).containsExactly(7, 8);
  }
}
