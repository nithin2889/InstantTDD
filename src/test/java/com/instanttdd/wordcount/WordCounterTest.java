package com.instanttdd.wordcount;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordCounterTest {

  private WordCounter counter = new WordCounter();

  @Test
  public void emptyStringsHasNoWords() {
    counter.add("");
    assertEquals(0, counter.getUniqueWordsCount());
  }

  @Test
  public void singleWordStringHasOneWord() {
    counter.add("hello");
    assertEquals(1, counter.getUniqueWordsCount());
  }

  @Test
  public void twoSingleWordStringsHaveTwoWords() {
    counter.add("hello");
    counter.add("howdy");
    assertEquals(2, counter.getUniqueWordsCount());
  }

  @Test
  public void multiWordStringHasCorrectWordCount() {
    counter.add("one two three");
    assertEquals(3, counter.getUniqueWordsCount());
  }

  @Test
  public void spacedOutMultiWordStringHasCorrectWordCount() {
    counter.add("    one    two    three    ");
    assertEquals(3, counter.getUniqueWordsCount());
  }

  @Test
  public void severalMultiWordStringHasCorrectWordCount() {
    counter.add("one two three");
    counter.add("four five six");
    assertEquals(6, counter.getUniqueWordsCount());
  }

  @Test
  public void duplicateInputCountsOnlyIndividualCases() {
    counter.add("nine nine nine");
    assertEquals(1, counter.getUniqueWordsCount());
  }

  @Test
  public void duplicateMixedCaseInputCountsOnlyIndividualCases() {
    counter.add("Nine nine NINE");
    assertEquals(1, counter.getUniqueWordsCount());
  }

  @Test
  public void inputWithPunctuationStillSpotsDuplicates() {
    counter.add("Nine.");
    counter.add("Nine ten.");
    counter.add("Nine, ten, eleven.");
    assertEquals(3, counter.getUniqueWordsCount());
  }

}