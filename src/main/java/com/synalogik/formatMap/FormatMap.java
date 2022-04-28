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
		
//		
		int max = Collections.max(map.values());
		String template = "The most frequently occurring word length is " + max + ", ";
		
		List<Integer> maxKeys = new ArrayList<Integer>();
		
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue()==max) {
				maxKeys.add(entry.getKey());
			}
		}
		
		if (maxKeys.size() == 1) res = template + "for word length of " + maxKeys.get(0);
		else if (maxKeys.size() == 2) res = template + "for word lengths of " + maxKeys.get(0) + " & " + maxKeys.get(1);
		else {
			int lastInd = maxKeys.size() - 1;
			int lastInt = maxKeys.get(lastInd);
			maxKeys.remove(lastInd);
			
			String joined = maxKeys
					.stream().map(String::valueOf)
				    .collect(Collectors.joining(", "));

			res = "for word lengths of " + joined + " & " + lastInt;
		}
		
		return res;
	}
	
	public String getWordCount(ReadFile file) throws IOException {
		
		HashMap<Integer, Integer> lenMap = file.lengthFreq;
		
		System.out.println("Word count = " + file.wordCount);
		System.out.println("Average word length = " + file.averageLen);
		
		for (Map.Entry<Integer, Integer> entry : lenMap.entrySet()) {
			
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			
			System.out.println("Number of words of length " + key + " is " + value);
			
		}
		
		return getHighFreq(lenMap);
		
	}
	
	
}
