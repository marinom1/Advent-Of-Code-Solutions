package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * solution by marinom1 on github
 * Working program to solve advent of code 2020 day 6 part 1
 * 
 */
public class day6 {
	
	public static void main(String[] args) throws FileNotFoundException {
		int totalCharCounter = 0; //this is what we want to give as answer
		File myObj = new File("src/day6/day6input.txt");
		Scanner myReader;

		myReader = new Scanner(myObj);
		ArrayList<String> array = new ArrayList<String>(1100);
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			array.add(data);
		}
//		for (int i = 0; i < array.size(); i = i + 1) { //loop to print initial data in array
//			System.out.printf("array[" + i + "] is: %s\n", array.get(i));
//		}
		
		int a = 0; //keeps track what index of array we are on
		String currentLine = array.get(a);	
		String charTracker = "";
		while (a < array.size()) { //loop through all groups
			while (currentLine.isEmpty() == false) { //loop iterates through one group
				
				
				for (int i = 0; i < currentLine.length(); i = i + 1) { //loop through each char in currentLine
			        if (!charTracker.contains(String.valueOf(currentLine.charAt(i)))) {
			            charTracker += currentLine.charAt(i);
			        }       
			    }
				System.out.printf("charTracker at this point counted: %d unique chars\n", charTracker.length());
				a = a + 1;
				if (a == array.size()) { //stops program before reaching index out of bounds error
					totalCharCounter = totalCharCounter + charTracker.length();
					System.out.printf("The totalCharCount is: %d\n" , totalCharCounter);
					System.exit(0);
				}
				currentLine = array.get(a);
			}
			
			totalCharCounter = totalCharCounter + charTracker.length();
			charTracker = "";	
			System.out.printf("The totalCharCount so far is: %d\n", totalCharCounter);
			a = a + 1;
			currentLine = array.get(a);
		}
			
			
		System.out.printf("The totalCharCount is: %d\n", totalCharCounter);
		
		
		
		
		
	}
}
