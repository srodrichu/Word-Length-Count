package com.synalogik.runner;
import java.io.IOException;
import java.util.Scanner;

import com.synalogik.formatMap.*;
import com.synalogik.readFile.*;

public class Runner {

	public static void main(String[] args) throws IOException{
			
//			Take in user input for file path
			Scanner obj = new Scanner(System.in);
		    try {
		    	while(true) {
		    		
		    		ReadFile file = null;
		    		String path;
		    		boolean validPath;
		    		
		    		do {
		    			validPath = true;
		    			try {
							System.out.println("Enter path to plain text file: ");
			//		    Instantiate classes and run program
							path = obj.nextLine();
							file = new ReadFile(path);
							file.evalFile();
		    			} catch(IOException e) {
							validPath = false;
							System.out.println("Invalid path input. Error: " + e);
						}
		    		} while(!validPath);
		    		
		    		FormatMap build = new FormatMap();
					
	//			Print results
					System.out.println(build.getFormatString(file));
	
					String res;
					
	//			Asks user if they want to run another file / handles invalid input
					while (true) {
						System.out.println("Do you want to run this program again? (y / n)");
						res = obj.nextLine();
						if (res.equalsIgnoreCase("n") || res.equalsIgnoreCase("y")) break;
						System.out.println("Invalid input, please try again.");
					}
					
	//			Handles valid response
					if (res.equalsIgnoreCase("n")) break;
					else if (res.equalsIgnoreCase("y")) continue;
		    	}
			} finally {
				obj.close();
			}

	}
	
}
