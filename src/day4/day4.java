package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Solution by marinom1 on github
 * The program will first read the file and store the data in array. Then the program will iterate through 1 passport at a time,
 * storing each passport's details into currentPassport and then determining if the strings contain the attributes to determine a valid
 * passport or not. 
 * 
 */
public class day4 {
	public static void main(String[] args) {
		int validPassports = 0;
		boolean byr = false;
		boolean iyr = false;
		boolean eyr = false;
		boolean hgt = false;
		boolean hcl = false;
		boolean ecl = false;
		boolean pid = false;
		int a = 0; //a iterates through each line in the input
		try {
			File myObj = new File("src/day4/day4input.txt");
			Scanner myReader = new Scanner(myObj);
			ArrayList<String> array = new ArrayList<String>(1100);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				array.add(data);
			}
			System.out.printf("The size of array is: %d\n", array.size());
//			for (int i = 0; i < 10; i = i + 1) { //loop to print what's inside array at this point
//				System.out.printf("array["+i+"] is: %s\n", array.get(i));
//			}

			for (int h = 0; h < array.size(); h = h + 1) {
				ArrayList<String> currentPassport = new ArrayList<String>(10);
				String currentLine = "test";
				
				while (currentLine.isEmpty() == false && a < array.size()) {
					currentLine = array.get(a); // currentLine stores what's in index a of array
					a = a + 1;
					currentPassport.add(currentLine); // currentPassport will hold information for only 1 passport at a
														// time
				}
				// At this point, currentPassport will have all the info and an empty string in
				// it
				for (int i = 0; i < currentPassport.size(); i = i + 1) { // loop to print what's inside array at this
																			// point
					System.out.printf("currentPassport[" + i + "] is: %s\n", currentPassport.get(i));
				}
				byr = false;
				iyr = false;
				eyr = false;
				hgt = false;
				hcl = false;
				ecl = false;
				pid = false;

				for (int i = 0; i < currentPassport.size(); i = i + 1) {
					if (currentPassport.get(i).contains("byr:")) {
						byr = true;
					}
					if (currentPassport.get(i).contains("iyr:")) {
						iyr = true;
					}
					if (currentPassport.get(i).contains("eyr:")) {
						eyr = true;
					}
					if (currentPassport.get(i).contains("hgt:")) {
						hgt = true;
					}
					if (currentPassport.get(i).contains("hcl:")) {
						hcl = true;
					}
					if (currentPassport.get(i).contains("ecl:")) {
						ecl = true;
					}
					if (currentPassport.get(i).contains("pid:")) {
						pid = true;
					}
				}
				if (byr & iyr & eyr & hgt & hcl & ecl & pid) {
					validPassports = validPassports + 1;
				}
				System.out.printf("The number of valid passports so far is: %d\n", validPassports);
				if (a >= array.size()) {
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
