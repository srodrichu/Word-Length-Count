package com.synalogik.readFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class ReadFile {
	
	String path;
	public float averageLen;
	private int charCount;
	public int wordCount;
//	Instantiate the HashMap where we are going to store the word length frequencies
	public HashMap<Integer, Integer> lengthFreq = new HashMap<Integer,Integer>();
	
	public ReadFile(String path) {
		this.path = path;
		this.wordCount = 0;
		this.charCount = 0;
	}
	
//	Handles putting a word length into the map
	private void putWl(int wl) {
		// Handles instances of recurring invalid characters
		if (wl == 0) return;
		
		if (lengthFreq.containsKey(wl)) {
			lengthFreq.put(wl, lengthFreq.get(wl) + 1);
		} else {
			lengthFreq.put(wl, 1);
		}
		
		wordCount++;
		charCount += wl;
		
	}
	
//	Checks if the character is unconditionally the end of a word
	private boolean unconWordEnd(int val) {
		
		if (val >= 0 && val <= 34 ||
				val >= 39 && val <= 41 ||
				val == 59 || 
				val == 63) {
			return true; 
		} 
		return false;	
	}
	
//	Checks if the character is a conditional character
	private boolean condWordEnd(int val) {
		
		if (val >= 44 && val <= 47 ||
				val == 58) {
			return true;
		}
		return false;
	}
	
//	Checks if the character is a number
	private boolean isNum(int val) {
		
		if (val >= 48 && val <= 57) {
			return true;
		}
		return false;
	}
	
//	set averageLen
	private void setAverageLen() {
		
		averageLen = (float) charCount/ wordCount;
		
	}
	
	
//	Reading the plain text file and sets the word length in the lengthFreq map
	public HashMap<Integer, Integer> evalFile() throws IOException {
		
		//	Read text from character input stream
		BufferedReader reader = new BufferedReader(new FileReader(this.path));
		
		
		// Store the current value
		int value;
		// Store the previous value
		int prevChar = 2;
		// Current word length
		int wl = 0;
		
		
		
		while (reader.ready()) {
			// Reads single character as ASCII value
				value = reader.read();
			// Checks if the current value is a conditional word ending value and if the previous value is a number
			// This handles formatted numbers
			if (condWordEnd(value) && isNum(prevChar)) {
				
				int nextVal = reader.read();
				
				if (isNum(nextVal)) {
					wl += 2;
				} else if (unconWordEnd(nextVal) || condWordEnd(nextVal)) {
					putWl(wl);
					wl = 0;
				} else {
					putWl(wl);
					wl = 1;
				}
			// If word isn't a formatted number, the word ends and is stored in the map
			} else if (unconWordEnd(value) || condWordEnd(value)) {
				putWl(wl);
				wl = 0;
			// The value is an accepted character and the word length increases
			} else {
				wl ++; 
			}
			// Set the previous value variable to the current value in preparation for the next loop
			prevChar = value;
		}
		
		// Store the last word of the text file in the map
		putWl(wl);
		
		// Once text file has been processed set average length
		setAverageLen();
		
		// Close the stream
		reader.close();
		
		return lengthFreq;
	}
	
	
}
