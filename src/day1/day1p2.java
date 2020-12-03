package day1;

import java.io.*;
import java.util.*;

/* Working solution to day1 part 2 puzzle. Make slight modifications to solution to part 1
 * and program will find 3 numbers to sum to 2020, then multiples them together.
 * 
 * By: marinom1 on github
 */
public class day1p2 {
	public static void main(String[] args) {

		// First, read the puzzle input and store them as ints into an ArrayList data
		// structure
		try {
			File myObj = new File("src/day1/day1input.txt");
			Scanner myReader = new Scanner(myObj);
			ArrayList<Integer> array = new ArrayList<Integer>(300);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				int goodData = Integer.parseInt(data);
				array.add(goodData);

			}

			for (int i = 0; i < array.size(); i = i + 1) {
				int firstNumber = array.get(i);
				for (int j = i; j < array.size(); j = j + 1) {
					int secondNumber = array.get(j);
					for (int k = 0; k < array.size(); k = k + 1) {
						int thirdNumber = array.get(k);
						int sum = firstNumber + secondNumber + thirdNumber;
						if (sum == 2020) {
							System.out.printf("The three numbers that add to 2020 are: %d and %d and %d\n", firstNumber,
									secondNumber, thirdNumber);
							System.out.printf("The product of these two numbers is: %d\n", firstNumber * secondNumber * thirdNumber);
							System.exit(0);
						}
					}
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
