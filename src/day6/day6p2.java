package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * solution by marinom1 on github
 * Working program to solve advent of code 2020 day 6 part 2
 * Used implementation of maps to handle counting characters and keeping a count of their frequency
 * 
 */
public class day6p2 {

	public static void main(String[] args) throws FileNotFoundException {
		int totalCharCounter = 0; // this is what we want to give as answer
		File myObj = new File("src/day6/day6input.txt");
		Scanner myReader;

		myReader = new Scanner(myObj);
		ArrayList<String> array = new ArrayList<String>(1100);
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			array.add(data);
		}
		int a = 0; // keeps track what index of array we are on
		String currentLine = array.get(a);
		while (a < array.size()) { // loop through all groups
			int people = 0;
			ArrayList<Character> charTracker = new ArrayList<Character>(1100); // charTracker keeps track of every char
																				// in one group at a time
			while (currentLine.isEmpty() == false) { // loop iterates through one group
				people = people + 1;

				for (int i = 0; i < currentLine.length(); i = i + 1) { // loop through each char in currentLine
					charTracker.add(currentLine.charAt(i));
				}
				System.out.printf("charTracker at this point contains: %s\n", charTracker.toString());
				a = a + 1;
				if (a == array.size()) { // stops program before reaching index out of bounds error
					int everyoneAnswered = countChars(charTracker.toString(), people);
					totalCharCounter = totalCharCounter + everyoneAnswered;
					System.out.printf("The totalCharCounter (answer) is: %d\n", totalCharCounter);
					System.exit(0);
				}
				currentLine = array.get(a);
			}

			System.out.printf("people at this point is: %d\n", people);
			int everyoneAnswered = countChars(charTracker.toString(), people);
			totalCharCounter = totalCharCounter + everyoneAnswered;
			System.out.printf("totalCharCounter here is: %d\n", totalCharCounter);
			a = a + 1;
			currentLine = array.get(a);
		}

		System.out.printf("The totalCharCounter (answer) is: %d\n", totalCharCounter);

	}

	public static int countChars(String message, int people) {
		int everyoneAnswered = 0;
		Map<Character, Integer> numCharMap = new HashMap<Character, Integer>();
		for (int i = 0; i < message.length(); i++) {
			// Take one character
			char c = message.charAt(i);
			// ignore these symbols
			if (c == ' ' || c == ',' || c == '[' || c == ']')
				continue;
			// If that character is already there in the map
			// then increase the value by 1
			if (numCharMap.containsKey(c)) {
				numCharMap.put(c, numCharMap.get(c) + 1);
			} else {
				// otherwise put that character in the map
				// with the value as 1
				numCharMap.put(c, 1);
			}
		}
		// Displaying the map values
		Set<Map.Entry<Character, Integer>> numSet = numCharMap.entrySet();
		for (Map.Entry<Character, Integer> m : numSet) {
			System.out.println("Char: " + m.getKey() + " Count: " + m.getValue());
			if (m.getValue() == people) {
				everyoneAnswered = everyoneAnswered + 1;
			}
		}
		return everyoneAnswered;
	}
}
