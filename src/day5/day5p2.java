package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class day5p2 {
	public static void main(String[] args) {
		try {
			File myObj = new File("src/day5/day5input.txt");
			Scanner myReader = new Scanner(myObj);
			ArrayList<String> array = new ArrayList<String>(760);
			ArrayList<Integer> listOfSeatIDs = new ArrayList<Integer>(760);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				array.add(data);
			}
//			System.out.printf("The size of array is: %d\n", array.size());
//			for (int i = 0; i < 10; i = i + 1) { //loop to print what's inside array at this point
//				System.out.printf("array["+i+"] is: %s\n", array.get(i));
//			}
			int highestSeatID = 0;
			int lowerRange = 0;
			int upperRange = 127;
			int row;
			int column;

			for (int a = 0; a < array.size(); a = a + 1) {
				String binaryString = "";
				String binaryColumnString = "";

				String currentLine = array.get(a);
				System.out.printf("The currentLine is: %s\n", currentLine); // F's are zeros, B's are ones
				for (int i = 0; i < 7; i = i + 1) {
					if (currentLine.charAt(i) == 'F') {
						binaryString = binaryString + "0";
					} else {
						binaryString = binaryString + "1";
					}
				}
				System.out.printf("binaryString at this point is: %s\n", binaryString);
				row = Integer.parseInt(binaryString, 2);
				System.out.printf("The row here is: %d\n", row);

				for (int i = 7; i < 10; i = i + 1) { // L is zero, R is one
					if (currentLine.charAt(i) == 'L') {
						binaryColumnString = binaryColumnString + "0";
					} else {
						binaryColumnString = binaryColumnString + "1";
					}
				}
				System.out.printf("binaryColumnString at this point is: %s\n", binaryColumnString);
				column = Integer.parseInt(binaryColumnString, 2);
				System.out.printf("The column here is: %d\n", column);

				int currentSeatID = row * 8 + column;
				System.out.printf("The currentSeatID is: %d\n", currentSeatID);

				listOfSeatIDs.add(currentSeatID);
			}
//			for (int i = 0; i < 10; i = i + 1) { //loop to print what's inside array at this point
//				System.out.printf("listOfSeatIDs["+i+"] is: %s\n", listOfSeatIDs.get(i));
//			}
			Collections.sort(listOfSeatIDs);

			for (int i = 0; i < listOfSeatIDs.size(); i = i + 1) { // loop to print what's inside array at this point
				System.out.printf("listOfSeatIDs[" + i + "] is: %s\n", listOfSeatIDs.get(i));
			}

			for (int i = 0; i < listOfSeatIDs.size(); i = i + 1) {
				if (i+49 == listOfSeatIDs.get(i)) {
//					
				}
				else {
					System.out.printf("i+49 here is: %d and listOfSearIDs.get(i) here is: %d\n",i+49,listOfSeatIDs.get(i));
					System.out.printf("This number is missing: %d\n", i+49);
					break;
				}
			}


			// code above here
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
