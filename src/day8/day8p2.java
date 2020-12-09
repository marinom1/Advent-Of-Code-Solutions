package day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * program by marinom1 on github
 * working solution for day8 part 2 advent of code 2020
 * Main issue was figuring out why instructions weren't returning back to what they originally were
 * turns out I didn't realize I was just adding on elements to the end of my ArrayList of instructions
 */
public class day8p2 {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> array = new ArrayList<String>(700); // holds data from input file, 1 line per element

		try {
			array = readFileAndStoreInArray(array);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < array.size(); i++) { // loop to print contents of array
//			System.out.printf("array[" + i + "] is: %s\n", array.get(i));
		}
		int accumulator = 0;
		int currentIndex = 0;
		String currentLine;
		String instruction;
		char direction;
		int number;
		boolean[] visited = new boolean[array.size()]; // array of booleans to keep track of what instructions were
														// already executed
		ArrayList<Integer> indicesOfJmp = new ArrayList<Integer>(700); // indices of every jmp instruction
		ArrayList<Integer> indicesOfNop = new ArrayList<Integer>(700);
		indicesOfJmp = findIndices("jmp", array, indicesOfJmp);
		indicesOfNop = findIndices("nop", array, indicesOfNop);

		for (int i = 0; i < indicesOfJmp.size(); i = i + 1) {
			accumulator = 0; //reset accumulator after each run
			currentIndex = 0; //reset currentIndex after each run
			ArrayList<String> testArray = new ArrayList<String>(700);
			testArray = readFileAndStoreInArray(testArray); //reset array after finding a run that failed
			System.out.printf("testArray[65] is: %s\n", testArray.get(65));
			Arrays.fill(visited, false); //reset array of booleans after each run
			int indexToChange = indicesOfJmp.get(i);

			String currentInstructionString = testArray.get(indexToChange); // the ONE instruction we want to change before
																		// we do a run
			currentInstructionString = currentInstructionString.replaceFirst("jmp", "nop");
			testArray.set(indexToChange, currentInstructionString);
			System.out.printf("the new instruction at index %d is: %s\n", indexToChange, testArray.get(indexToChange));
			while (true) { // do a run
//				System.out.printf("does this run more than once???");
				if (currentIndex == 633) { // 633 since that index doesnt exist
					System.out.printf("That ended the program normally! accumulator is: %d\n", accumulator);
					System.exit(0);
				}
				currentLine = testArray.get(currentIndex);
				System.out.printf("The instruction about to be processed is: %s\n", currentLine);
				instruction = currentLine.substring(0, 3);
				direction = currentLine.charAt(4);
				number = Integer.parseInt(currentLine.substring(5));
				if (visited[currentIndex] == true) {
					System.out.printf(
							"the instruction at index %d already ran once meaning that wasn't the correct instruction to swap, accumulator is: %d\n",
							currentIndex, accumulator);
					break;
				} else {
					visited[currentIndex] = true;
				}

				if (instruction.equals("nop")) {
					currentIndex = currentIndex + 1;
				} else if (instruction.equals("acc")) {
					if (direction == '+') {
						accumulator = accumulator + number;
						currentIndex = currentIndex + 1;
					} else {
						accumulator = accumulator - number;
						currentIndex = currentIndex + 1;
					}
				} else if (instruction.equals("jmp")) {
					if (direction == '+') {
						currentIndex = currentIndex + number;
					} else {
						currentIndex = currentIndex - number;
					}
				}
			System.out.printf("accumulator here is: %d\n", accumulator);
			} //end while loop (end of run)
		} //end for loop
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
		File myObj = new File("src/day8/day8input.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			a.add(data);
		}
		myReader.close();
		for (int i = 0; i < a.size(); i++) { // loop to print contents of array
			System.out.printf("a[" + i + "] is: %s\n", a.get(i));
		}
		return a;
	}

	public static ArrayList<Integer> findIndices(String command, ArrayList<String> array,
			ArrayList<Integer> indicesOfJmp) {
		for (int i = 0; i < array.size(); i = i + 1) {
			if (array.get(i).contains(command)) {
				indicesOfJmp.add(i);
			}
		}
		return indicesOfJmp;
	}
}
