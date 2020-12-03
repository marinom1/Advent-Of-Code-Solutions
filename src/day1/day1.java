package day1;

import java.io.*;
import java.util.*;

/* This is my solution to theadventofcode.com/2020/day/1/ coding challenge.
 * At first I had an inefficient but working solution. The current version has it so 
 * two number combinations aren't checked twice and the program
 * terminates when the solution is found, as the possible combinations after don't matter.
 * By: marinom1 on github
 */
public class day1 {
	public static void main(String[] args) {
		
		//First, read the puzzle input and store them as ints into an ArrayList data structure
		try {
			File myObj = new File("src/day1/day1input.txt");
			Scanner myReader = new Scanner(myObj);
			ArrayList<Integer> array = new ArrayList<Integer>(300);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				int goodData = Integer.parseInt(data);
				array.add(goodData);

			}
		      //This prints helpful info used during the devlopment of this solution
		      /*for (int i = 0; i < array.size(); i = i + 1) {
	    		  System.out.println(array.get(i)); //all numbers are stored in array at this point
	    	  } 
		      System.out.printf("The number of elements in array is: %d\n", array.size()); */
		      
			//Go through each number combination to find the 
			for (int i = 0; i < array.size(); i = i + 1) {
				int firstNumber = array.get(i);
				for (int j = i; j < array.size(); j = j + 1) {
					int secondNumber = array.get(j);
					int sum = firstNumber + secondNumber;
					if (sum == 2020) {
						System.out.printf("The two numbers that add to 2020 are: %d and %d\n", firstNumber,
								secondNumber);
						System.out.printf("The product of these two numbers is: %d\n", firstNumber * secondNumber);
						System.exit(0);
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
