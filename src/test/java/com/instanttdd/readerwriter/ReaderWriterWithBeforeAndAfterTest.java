package com.instanttdd.readerwriter;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;
import org.junit.Test;

public class ReaderWriterTest {
  @Test
  public void readLinesItWrote() throws Exception {
    // with a temporary folder to write to
    File tempFolder = File.createTempFile("tmp", "file");
    tempFolder.delete();
    tempFolder.mkdir();

    // when we write the file
    List<String> someLines = asList("One", "Two", "Three");
    File writtenFile = ReaderWriter.write(tempFolder, "MyFile", someLines);

    // then we can read it back
    List<String> readLines = ReaderWriter.read(writtenFile);

    // and they match
    assertEquals(someLines, readLines);

    // and the tidy up is successful
    assertTrue(writtenFile.delete());
    assertTrue(tempFolder.delete());
  }
}
