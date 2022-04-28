package com.synalogik.testing.formatMap;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.synalogik.formatMap.FormatMap;
import com.synalogik.readFile.ReadFile;

public class FomatMapTest {
	
	String path1 = "src/test/resources/formatMapTest1.txt";
	ReadFile file1 = new ReadFile(path1);
	
	String path2 = "src/test/resources/formatMapTest2.txt";
	ReadFile file2 = new ReadFile(path2);
	
	String path3 = "src/test/resources/formatMapTest3.txt";
	ReadFile file3 = new ReadFile(path3);
	
	
	
	@Test
	public void formatMapTest1() throws IOException {
		
		file1.evalFile();
		
		FormatMap build = new FormatMap();
		String str = "Word count = 20\nAverage word length = 4.65\nNumber of words of length 1 is 3\nNumber of words of length 2 is 3\nNumber of words of length 3 is 2\nNumber of words of length 4 is 3\nNumber of words of length 5 is 4\nNumber of words of length 6 is 1\nNumber of words of length 10 is 4\nThe most frequently occurring word length is 4, for word lengths of 5 & 10";
		
		assertEquals(str, build.getWordCount(file1));
	}
	
	@Test
	public void formatMapTest2() throws IOException {
		
		file2.evalFile();
		
		FormatMap build = new FormatMap();
		String str = "Word count = 21\nAverage word length = 4.6666665\nNumber of words of length 1 is 3\nNumber of words of length 2 is 3\nNumber of words of length 3 is 2\nNumber of words of length 4 is 3\nNumber of words of length 5 is 5\nNumber of words of length 6 is 1\nNumber of words of length 10 is 4\nThe most frequently occurring word length is 5, for word length of 5";
		
		assertEquals(str, build.getWordCount(file2));
		
	}
	
	@Test
	public void formatMapTest3() throws IOException {
		
		file3.evalFile();
		
		FormatMap build = new FormatMap();
		String str = "Word count = 21\nAverage word length = 4.6190476\nNumber of words of length 1 is 3\nNumber of words of length 2 is 3\nNumber of words of length 3 is 2\nNumber of words of length 4 is 4\nNumber of words of length 5 is 4\nNumber of words of length 6 is 1\nNumber of words of length 10 is 4\nThe most frequently occurring word length is 4, for word lengths of 4, 5 & 10";
		
		assertEquals(str, build.getWordCount(file3));
		
	}
	
}
