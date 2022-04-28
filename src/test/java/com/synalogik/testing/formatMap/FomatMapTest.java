package com.synalogik.testing.formatMap;

import java.io.IOException;

import org.junit.Test;

import com.synalogik.formatMap.FormatMap;
import com.synalogik.readFile.ReadFile;

public class FomatMapTest {

	String path1 = "src/test/resources/readfiletest.txt";
	ReadFile file = new ReadFile(path1);
	
	
	@Test
	public void formatMapTest() throws IOException {
		
		FormatMap build = new FormatMap();
		build.getWordCount(file);
		
		
		
	}
	
}
