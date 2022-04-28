package com.synalogik.runner;
import java.io.IOException;
import java.util.Scanner;

import com.synalogik.formatMap.*;
import com.synalogik.readFile.*;

public class Runner {

	public static void main(String[] args) throws IOException {
		
	    Scanner obj = new Scanner(System.in);  
	    System.out.println("Enter path to plain text file: ");
	    String path = obj.nextLine();
		
		ReadFile file = new ReadFile(path);
		file.evalFile();
		FormatMap build = new FormatMap();
		
		System.out.println(build.getWordCount(file));
	}
	
}
