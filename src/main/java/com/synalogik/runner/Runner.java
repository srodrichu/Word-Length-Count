package com.synalogik.runner;
import java.io.IOException;
import java.util.Scanner;

import com.synalogik.formatMap.*;
import com.synalogik.readFile.*;

public class Runner {

	public static void main(String[] args) throws IOException {
		
		
		while (true) {
			
//			Take in user input for file path
			
		    Scanner obj = new Scanner(System.in);  
		    System.out.println("Enter path to plain text file: ");
		    String path = obj.nextLine();
			
		    
			ReadFile file = new ReadFile(path);
			file.evalFile();
			FormatMap build = new FormatMap();
			
//			Print results
			System.out.println(build.getWordCount(file));
			
//			Asks user if they want to run another file
			System.out.println("Do you want to run this program again? (y / n)");
			String res = obj.nextLine();
			
//			Evaluates user input
			if (res.equalsIgnoreCase("n")) break;
				
		}
		

	}
	
}
