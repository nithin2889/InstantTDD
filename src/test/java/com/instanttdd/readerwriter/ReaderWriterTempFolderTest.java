package com.instanttdd.readerwriter;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class ReaderWriterTempFolderTest {

  @Rule public TemporaryFolder temporaryFolder = new TemporaryFolder();
  private File writtenFile;

  @After
  public void ensureFileIsGone() {
    assertTrue(writtenFile.delete());
  }

  @Test
  public void readLinesItWrote() throws Exception {
    // when we write the file
    List<String> someLines = asList("One", "Two", "Three");
    writtenFile = ReaderWriter.write(temporaryFolder.getRoot(), "MyFile", someLines);

    // then we can read it back
    List<String> readLines = ReaderWriter.read(writtenFile);

    // and they match
    assertEquals(someLines, readLines);
  }
}
