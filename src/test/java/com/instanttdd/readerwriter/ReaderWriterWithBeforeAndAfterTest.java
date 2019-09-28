package com.instanttdd.readerwriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReaderWriterWithBeforeAndAfterTest {

  private File writtenFile;
  private File tempFolder;

  @Before
  public void setUp() throws Exception {
    // with a temporary folder to write to
    tempFolder = File.createTempFile("tmp", "file");
    tempFolder.delete();
    tempFolder.mkdir();
  }

  @After
  public void teardown() throws Exception {
    // and the tidy up is successful
    assertTrue(writtenFile.delete());
    assertTrue(tempFolder.delete());
  }

  @Test
  public void readLinesItWrote() throws Exception {
    // when we write the file
    List<String> someLines = Arrays.asList("One", "Two", "Three");
    writtenFile = ReaderWriter.write(tempFolder, "MyFile", someLines);

    // then we can read it back
    List<String> readLines = ReaderWriter.read(writtenFile);

    // and they match
    assertEquals(someLines, readLines);
  }

  @Test
  public void readZeroLinesItWrote() throws Exception {
    // when we write the file
    List<String> someLines = Arrays.asList();
    writtenFile = ReaderWriter.write(tempFolder, "MyFile", someLines);

    // then we can read it back
    List<String> readLines = ReaderWriter.read(writtenFile);

    // and they match
    assertEquals(someLines, readLines);
  }
}
