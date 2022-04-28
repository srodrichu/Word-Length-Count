package com.synalogik.testing.readFile;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.synalogik.readFile.ReadFile;

public class ReadFileTest {
	
	String path1 = "src/test/resources/readfiletest.txt";
	Map<Integer, Integer> map1 = new HashMap<Integer,Integer>();
	
	@Before
	public void init() {
		
		map1.put(1, 3);
		map1.put(2, 3);
		map1.put(3, 2);
		map1.put(4, 3);
		map1.put(5, 4);
		map1.put(6, 1);
		map1.put(10, 4);
		
		}
	
	@Test
	public void evalFileTest1() throws IOException{
		
		ReadFile file = new ReadFile(path1);
		
		assertEquals(map1, file.evalFile());
		
	}

}
