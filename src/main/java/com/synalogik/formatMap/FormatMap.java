package com.synalogik.formatMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.synalogik.readFile.*;

public class FormatMap {
	
	private String getHighFreq(HashMap<Integer,Integer> map) {
		
		String res;
		
		int max = Collections.max(map.values()); // Get the highest value in the map
		String strTemplate = "The most frequently occurring word length is " + max + ", ";
		
		List<Integer> maxKeys = new ArrayList<Integer>();
		
//		Loop through the map to find the keys with the highest value
		
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue()==max) {
				maxKeys.add(entry.getKey());
			}
		}
		
//		Handle change in language based on whether or not there are 1, 2 or more max key variables
		if (maxKeys.size() == 1) res = strTemplate + "for word length of " + maxKeys.get(0);
		else if (maxKeys.size() == 2) res = strTemplate + "for word lengths of " + maxKeys.get(0) + " & " + maxKeys.get(1);
		else {
			int lastInd = maxKeys.size() - 1;
			int lastInt = maxKeys.get(lastInd);
			maxKeys.remove(lastInd);
			
//			Join list of maxKeys
			String joined = maxKeys
					.stream().map(String::valueOf)
				    .collect(Collectors.joining(", "));

			res = strTemplate + "for word lengths of " + joined + " & " + lastInt;
		}
		
		return res;
	}
	
	public String getFormatString(ReadFile file) throws IOException {
		
		
		HashMap<Integer, Integer> lenMap = file.lengthFreq; // Instantiate Map
		
		StringBuilder str = new StringBuilder();
		
		// Format strings
		
		str.append("Word count = " + file.wordCount + "\n");
		str.append("Average word length = " + file.averageLen + "\n");
		
		for (Map.Entry<Integer, Integer> entry : lenMap.entrySet()) {
			
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			
			str.append("Number of words of length " + key + " is " + value + "\n");
			
		}
		
		str.append(getHighFreq(lenMap));
		
		return str.toString();
	}
	
	
}
