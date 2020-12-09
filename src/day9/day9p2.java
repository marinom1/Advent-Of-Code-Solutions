package day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * made by marinom1 on github
 * Working solution for day9 part 2 Advent of Code 2020
 */
public class day9p2 {
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>(700); // holds data from input file, 1 line per element
		try {
			array = readFileAndStoreInArray(array);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < array.size(); i++) { // loop to print contents of array
			System.out.printf("array[" + i + "] is: %s\n", array.get(i));
		}

		int invalidNumber = 0;
		int indexOfInvalidNumber = 0;
		int currentLowestIndex = 0;
		boolean foundInvalid = false;
		while (!(foundInvalid)) {

			Queue<Integer> q = new LinkedList<>();
			for (int i = currentLowestIndex; i < 25 + currentLowestIndex; i = i + 1) {
				q.add(Integer.parseInt(array.get(i)));
			}
//			System.out.printf("The q is: %s\n", q);
			int sum = Integer.parseInt(array.get(25 + currentLowestIndex));
			System.out.printf("sum is: %d\n", sum);
			int num1 = 0;
			int num2 = 0;
			Iterator iterator = q.iterator();
			int[] current25 = new int[25];
			for (int i = 0; i < 25; i = i + 1) {
				current25[i] = (int) iterator.next();
//            	System.out.printf("current25["+i+"] is: %d\n", current25[i]);
			}

			boolean valid = false;
			for (int i = 0; i < 25; i = i + 1) {
				num1 = current25[i];
				for (int j = 0; j < 25; j = j + 1) {
					num2 = current25[j];
					if (num1 + num2 == sum & i != j) {
//        				System.out.printf("Sum: %d - num1: %d - num2: %d\n", sum,num1,num2);
						valid = true;
					}
				}
			}
			if (valid == false) {
				System.out.printf("Found number that doesnt have 2 pairs add to it: %d\n", sum);
				invalidNumber = sum;
				indexOfInvalidNumber = 25+currentLowestIndex;
				foundInvalid = true;
			}
			currentLowestIndex = currentLowestIndex + 1;
		}
		
		System.out.printf("The invalid number is: %d\n", invalidNumber);
		System.out.printf("The indexOfInvalidnumber is: %d\n", indexOfInvalidNumber);
		boolean foundContiguous = false;
		int lowIndex = 0;
		int highIndex = 1;

		for (int g = lowIndex; g < indexOfInvalidNumber; g = g + 1 ) {
			ArrayList<String> currentArray =  new ArrayList<String>(1100);
			highIndex = lowIndex+1;
			for (int i = lowIndex; i < highIndex; i = i + 1) {		
				currentArray.add(array.get(i));
				for (int e = 0; e < currentArray.size(); e++) { // loop to print contents of array
//					System.out.printf("currentArray[" + e + "] is: %s\n", currentArray.get(e));
				}
				if (sumValuesInArray(currentArray)== invalidNumber) { //found the correct contiginous sequence
					System.out.printf("Found the contiguous sequence!\n");
					int smallestNumberInContiguous = 0;
					int largestNumberInContiguous = 0;
					smallestNumberInContiguous = findSmallestNumberInArray(currentArray);
					largestNumberInContiguous = findLargestNumberInArray(currentArray);
					System.out.printf("The smallest number is: %d\n", smallestNumberInContiguous);
					System.out.printf("The largest number is: %d\n", largestNumberInContiguous);
					System.out.printf("The sum of these smallest and biggest numbers (puzzle answer) is: %d\n", smallestNumberInContiguous+largestNumberInContiguous);
					System.exit(0);
				}
				else {
					System.out.printf("did not find correct contiguous. that sum was: %d\n", sumValuesInArray(currentArray));
				}
				highIndex = highIndex + 1;
				if (highIndex > indexOfInvalidNumber) { //no need to check the numbers after
					break;
				}
			}
			lowIndex = lowIndex + 1;
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * This method will read the string data in the input file, and store it into an
	 * ArrayList with each line in the file corresponding to one element in the
	 * array
	 * 
	 * @param a
	 * @return a
	 * @throws FileNotFoundException
	 */
	public static ArrayList<String> readFileAndStoreInArray(ArrayList<String> a) throws FileNotFoundException {
		File myObj = new File("src/day9/day9input.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			a.add(data);
		}
		myReader.close();
		return a;
	}
	
	public static int sumValuesInArray(ArrayList<String> currentArray) {
		int sum = 0;
		for (int i = 0; i < currentArray.size(); i = i + 1) {
			sum = sum + Integer.parseInt(currentArray.get(i));
		}
		return sum;
	}
	public static int findSmallestNumberInArray (ArrayList<String> a) {
		int smallest = Integer.parseInt(a.get(0));
		for (int i = 0; i < a.size(); i = i + 1) {
			if (Integer.parseInt(a.get(i))< smallest  ) {
				smallest = Integer.parseInt(a.get(i));
			}
		}
		return smallest;
		
	}
	public static int findLargestNumberInArray (ArrayList<String> a) {
		int smallest = 0;
		for (int i = 0; i < a.size(); i = i + 1) {
			if (Integer.parseInt(a.get(i)) > smallest  ) {
				smallest = Integer.parseInt(a.get(i));
			}
		}
		return smallest;
		
	}
}
