package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Solution made by marinom1 on github for adventofcode day3part2
 * Program does not "draw" more than what was given in the puzzle key. If program encounters the right edge of
 * the map, it will loop back over to the beginning of the map since the map is a repeat of itself infinitely.
 * This is similar to part 1, it just has the implemented loop to check each case given and multiplies all the
 * cases together to get the final product. An issue I ran into was my final product was overflowing my int
 * data type, so I switched from using ints to longs for the tree counts and calculating the final product.
 * Originally thought to use BigInteger class, but longs were sufficient for the scope of the final product.
 * 
 */
public class day3p2 {
	public static void main(String[] args) {
		try {
			File myObj = new File("src/day3/day3input.txt");
			Scanner myReader = new Scanner(myObj);
			ArrayList<String> array = new ArrayList<String>(1000);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				array.add(data);
			}
			int[][] moves = new int[5][5]; // first value is how many to move right, second value is how many to move
											// down
			moves[0][0] = 1;
			moves[0][1] = 1;
			moves[1][0] = 3;
			moves[1][1] = 1;
			moves[2][0] = 5;
			moves[2][1] = 1;
			moves[3][0] = 7;
			moves[3][1] = 1;
			moves[4][0] = 1;
			moves[4][1] = 2;

			long[] totalTrees = new long[5]; // store the number of trees from each slope
			for (int k = 0; k < 5; k = k + 1) {

				int trees = 0;
				int x = 0; // x coordinate, zero indexed
				int y = 0; // y coordinate, zero indexed
				for (int i = 0; i < array.size(); i = i + 1) {
					x = x + moves[k][0];;
					y = y + moves[k][1];

					if (x > 30) {
						x = x - 31;
					}
					if (y > array.size() - 1) { // stops this loop before it reaches the out of bounds error
						System.out.printf("The program reached bottom. The final number of trees for this slope is: %d\n", trees);
						break;
					}
					if (array.get(y).charAt(x) == '#') {
						trees = trees + 1;
					}
					totalTrees[k] = trees;
				}
				
			}
			System.out.printf("The number of trees from each slope is: %d %d %d %d %d\n",totalTrees[0],totalTrees[1],totalTrees[2],totalTrees[3],totalTrees[4]);

			long product = totalTrees[0] * totalTrees[1] *totalTrees[2] * totalTrees[3] * totalTrees[4];
			System.out.printf("The final product of all the tree totals is: %d\n", product);	
			
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
}