package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * day2 part 2 solution by marinom1 on github
 * Program outputs correct solution, code may be currently messy
 */

public class day2p2 {
	public static void main(String[] args) {
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
				// 3 cases 1-3 1-11 10-12
				int firstIndex;
				int secondIndex;
				char charMin;
				char charMin2;
				char charMax;
				char charMax2;
				int passwordStart; // variable that keeps track of what index the actual password starts on
				char charToCheck; // variable that keeps track of what index the char to check is on.
				char checkLetter; // contains the actual char we need to check. 'r' 'h' 'k'
				int count;
				int validPasswords = 0;
				boolean isValidPassword = false;

				if (currentLine.charAt(1) == '-') { // if min number is single digit

					if (currentLine.charAt(4) == ' ') { // Case 2: if min number is single digit and if max number is
														// double digit
						passwordStart = 8;
						charToCheck = 5;
						// Get minimum value and store in intMin
						charMin = currentLine.charAt(0);
						String stringMin = String.valueOf(charMin);
						firstIndex = Integer.parseInt(stringMin);
						firstIndex = firstIndex - 1;

						// Get max value and store in intMax
						charMax = currentLine.charAt(2);
						String stringMax = String.valueOf(charMax);
						charMax2 = currentLine.charAt(3);
						String stringMax2 = String.valueOf(charMax2);
						stringMax = stringMax.concat(stringMax2);
						secondIndex = Integer.parseInt(stringMax);
						secondIndex = secondIndex - 1;
					} else { // Case 1: if min number is single digit and if max number is single digit
						passwordStart = 7;
						charToCheck = 4;
						// Get minimum value and store in intMin
						charMin = currentLine.charAt(0);
						String stringMin = String.valueOf(charMin);
						firstIndex = Integer.parseInt(stringMin);
						firstIndex = firstIndex - 1;

						// Get max value and store in intMax
						charMax = currentLine.charAt(2);
						String stringMax = String.valueOf(charMax);
						secondIndex = Integer.parseInt(stringMax);
						secondIndex = secondIndex - 1;
					}
				} else { // Case 3: if min number is double digit then max number must also be double
							// digit by default
					passwordStart = 9;
					charToCheck = 6;
					// Get minimum value and store in intMin
					charMin = currentLine.charAt(0);
					String stringMin = String.valueOf(charMin);
					charMin2 = currentLine.charAt(1);
					String stringMin2 = String.valueOf(charMin2);
					stringMin = stringMin.concat(stringMin2);
					firstIndex = Integer.parseInt(stringMin);
					firstIndex = firstIndex - 1;

					// Get max value and store in intMax
					charMax = currentLine.charAt(3);
					String stringMax = String.valueOf(charMax);
					charMax2 = currentLine.charAt(4);
					String stringMax2 = String.valueOf(charMax2);
					stringMax = stringMax.concat(stringMax2);
					secondIndex = Integer.parseInt(stringMax);
					secondIndex = secondIndex - 1;
				}
				System.out.printf("The firstIndex is: %d and the secondIndex is: %d\n", firstIndex, secondIndex);
				checkLetter = currentLine.charAt(charToCheck);
				// Get the char to check
				System.out.printf("The letter to check with is: %c\n", checkLetter);

				System.out.printf("The first letter I checked was: %c. The second letter I checked was %c\n",
						currentLine.charAt(firstIndex + passwordStart),
						currentLine.charAt(secondIndex + passwordStart));

				if ((currentLine.charAt(firstIndex + passwordStart) == checkLetter)
						^ (currentLine.charAt(secondIndex + passwordStart) == checkLetter)) { // ^ is XOR operator
					isValidPassword = true;
				} else { // if neither position has the letter
					isValidPassword = false;
				}
				System.out.printf("isValidPassword is: %b\n", isValidPassword);

				if (isValidPassword) {
					numberOfValidPasswords = numberOfValidPasswords + 1;
				}
				System.out.printf("The number of valid passwords is: %d\n", numberOfValidPasswords);

			}

			myReader.close();
		}

		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
