package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * Made by marinom1 on github
 * Part 2 borrows similar implementations from part 1 for day5. This program stores all the SeatIDs in an
 * ArrayList and then sorts them. After sorting, we look through the list to see which number is missing
 * 
 * 
 */
public class day5p2 {
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>(760);
		ArrayList<Integer> listOfSeatIDs = new ArrayList<Integer>(760);
		try {
			array = readFileAndStoreInArray(array);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int row;
		int column;
		for (int a = 0; a < array.size(); a = a + 1) {
			String binaryString = "";
			String binaryColumnString = "";
			String currentLine = array.get(a);
			for (int i = 0; i < 7; i = i + 1) {
				if (currentLine.charAt(i) == 'F') {
					binaryString = binaryString + "0";
				} else {
					binaryString = binaryString + "1";
				}
			}
			row = Integer.parseInt(binaryString, 2);
			for (int i = 7; i < 10; i = i + 1) { // L is zero, R is one
				if (currentLine.charAt(i) == 'L') {
					binaryColumnString = binaryColumnString + "0";
				} else {
					binaryColumnString = binaryColumnString + "1";
				}
			}
			column = Integer.parseInt(binaryColumnString, 2);
			int currentSeatID = row * 8 + column;
			listOfSeatIDs.add(currentSeatID);
		}
		Collections.sort(listOfSeatIDs);
		for (int i = 0; i < listOfSeatIDs.size(); i = i + 1) { // loop to print what's inside array at this point
			System.out.printf("listOfSeatIDs[" + i + "] is: %s\n", listOfSeatIDs.get(i));
		}
		for (int i = 0; i < listOfSeatIDs.size(); i = i + 1) {
			if (!(i + 49 == listOfSeatIDs.get(i))) {
				System.out.printf("i+49 here is: %d and listOfSearIDs.get(i) here is: %d\n", i + 49,
						listOfSeatIDs.get(i));
				System.out.printf("This number is missing: %d\n", i + 49);
				break;
			}
		}

	}

	/**
	 * This method will read the string data in the input file, and store it into an
	 * ArrayList with each line in the file corresponding to one element in the array
	 * 
	 * @param a
	 * @return a
	 * @throws FileNotFoundException
	 */
	public static ArrayList<String> readFileAndStoreInArray(ArrayList<String> a) throws FileNotFoundException {
		File myObj = new File("src/day5/day5input.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			a.add(data);
		}
		myReader.close();
		return a;
	}
}
