package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * solution made by marinom1 on github
 * Program does not "draw" more than what was given in the puzzle key. If program encounters the right edge of
 * the map, it will loop back over to the beginning of the map since the map is a repeat of itself infinitely.
 * 
 */
public class day3 {
	public static void main(String[] args) {
		try {
			File myObj = new File("src/day3/day3input.txt");
			Scanner myReader = new Scanner(myObj);
			ArrayList<String> array = new ArrayList<String>(1000);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				array.add(data);
			}
			int trees = 0;
			int x = 0; //x coordinate, zero indexed
			int y = 0; //y coordinate, zero indexed
			for (int i = 0; i < array.size(); i = i + 1) {
				x = x + 3;
				y = y + 1;
				
				if (x > 30) {
					x = x-31;
				}
				if (y > array.size()-1) { //stops program before it reaches the error
					System.out.printf("The program reached bottom. The final number of trees is: %d\n", trees);
					System.exit(0);
				}
				if (array.get(y).charAt(x)== '#') {
					trees = trees + 1;
				}
				
				System.out.printf("The number of trees I counted was: %d\n", trees);
			}
			
			
			//code above here
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
}