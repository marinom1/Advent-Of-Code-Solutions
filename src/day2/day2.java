package day2;

import java.io.*;
import java.util.*;
/*
 * AdventOfCode Day2 Solution by marinom1 on github
 * Current program will output correct answer, but print statements and code can be cleaned up or 
 * maybe more efficient. 
 * 
 */
public class day2 {
	public static void main (String [] args) {
		int numberOfValidPasswords = 0;
		try {
			File myObj = new File("src/day2/day2input.txt");
			Scanner myReader = new Scanner(myObj);
			ArrayList<String> array = new ArrayList<String>(1000);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				array.add(data);
			}
			for (int x = 0; x < 1000; x = x + 1) {
				String currentLine = array.get(x);
				//3 cases 1-3 1-11 10-12
				int intMin;
				int intMax;
				char charMin;
				char charMin2;
				char charMax;
				char charMax2;
				int passwordStart; //variable that keeps track of what index the actual password starts on
				char charToCheck; //variable that keeps track of what index the char to check is on
				char checkLetter;
				int count;
				
				if (currentLine.charAt(1) == '-') { // if min number is single digit
					
					if (currentLine.charAt(4) == ' ') { //Case 2: if min number is single digit and if max number is double digit
						passwordStart = 8;
						charToCheck = 5;
						//Get minimum value and store in intMin	
						charMin = currentLine.charAt(0);
						String stringMin = String.valueOf(charMin);
						intMin = Integer.parseInt(stringMin);
						
						//Get max value and store in intMax
						charMax = currentLine.charAt(2);
						String stringMax = String.valueOf(charMax);
						 charMax2 = currentLine.charAt(3);
						String stringMax2 = String.valueOf(charMax2);
						stringMax = stringMax.concat(stringMax2);				
						intMax = Integer.parseInt(stringMax);
					}
					else { //Case 1: if min number is single digit and if max number is single digit
						passwordStart = 7;
						charToCheck = 4;
						//Get minimum value and store in intMin	
						charMin = currentLine.charAt(0);
						String stringMin = String.valueOf(charMin);
						intMin = Integer.parseInt(stringMin);
						
						//Get max value and store in intMax
						charMax = currentLine.charAt(2);
						String stringMax = String.valueOf(charMax);				
						intMax = Integer.parseInt(stringMax);
					}
				}
				else { // Case 3: if min number is double digit then max number must also be double digit by default
					passwordStart = 9;
					charToCheck = 6;
					//Get minimum value and store in intMin	
					charMin = currentLine.charAt(0);
					String stringMin = String.valueOf(charMin);
					charMin2 = currentLine.charAt(1);
					String stringMin2 = String.valueOf(charMin2);
					stringMin = stringMin.concat(stringMin2);		
					intMin = Integer.parseInt(stringMin);
					
					//Get max value and store in intMax
					charMax = currentLine.charAt(3);
					String stringMax = String.valueOf(charMax);
					charMax2 = currentLine.charAt(4);
					String stringMax2 = String.valueOf(charMax2);
					stringMax = stringMax.concat(stringMax2);				
					intMax = Integer.parseInt(stringMax);
				}
				System.out.printf("The min value is: %d and the max value is: %d\n", intMin, intMax);
				checkLetter = currentLine.charAt(charToCheck);
				//Get the char to check
				System.out.printf("The letter to count is: %c\n", checkLetter);
				
				count = -1;
				for (int i = 0; i < currentLine.length(); i = i + 1) {
					if (currentLine.charAt(i)== checkLetter) {
						count = count + 1;
					}
				}
				System.out.printf("The number of %c's in the password is: %d\n", checkLetter, count);
				
				if ((count >= intMin) && (count <= intMax)) {
					numberOfValidPasswords = numberOfValidPasswords + 1;
				}
				System.out.printf("The number of valid passwords is: %d\n",  numberOfValidPasswords);
				
				
			}
			
			myReader.close();
		}
		
		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}