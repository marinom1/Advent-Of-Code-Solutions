package day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * program by marinom1 on github
 * working solution for day8 part 1 advent of code
 */
public class day8 {
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
		int accumulator = 0;
		int currentIndex = 0;
		String currentLine;
		String instruction;
		char direction;
		int number;
		boolean[] visited = new boolean[array.size()]; // array of booleans to keep track of what instructions were
														// already executed

		while (true) {
			currentLine = array.get(currentIndex);
			instruction = currentLine.substring(0, 3);
			direction = currentLine.charAt(4);
			number = Integer.parseInt(currentLine.substring(5));
			if (visited[currentIndex] == true) {
				System.out.printf("the instruction at index %d already ran once, accumulator is: %d\n", currentIndex,
						accumulator);
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
		File myObj = new File("src/day8/day8input.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			a.add(data);
		}
		myReader.close();
		return a;
	}
}



