package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Solution by marinom1 on github
 * Uses similar data setup to part 1. The program will have a main if statement for each piece of passport info. to check
 * Biggest issue in implementation was catching every single edge case
 */
public class day4p2 {
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

				for (int i = 0; i < currentPassport.size(); i = i + 1) { //loop through the current passport's info
					if (currentPassport.get(i).contains("byr:")) { //check byr
						int indexOfByr = 0;
						indexOfByr = currentPassport.get(i).indexOf("byr:");
//						System.out.printf("The index of the b in byr is: %d\n", indexOfByr);
						String birthYearString = currentPassport.get(i).substring(indexOfByr+4, indexOfByr+8);
						try {
							if (!(currentPassport.get(i).charAt(indexOfByr+8) == ' ')) {
								System.out.printf("LOOK AT THIS\n");
								System.out.printf("The 21st index here is: %c\n", currentPassport.get(i).charAt(indexOfByr+8));
							}
						}
						catch(StringIndexOutOfBoundsException exception) {
							
						}
//						System.out.printf("The value of birthYearString is: %s\n", birthYearString);
						int year = Integer.parseInt(birthYearString);
						if (year >= 1920 && year <= 2002) {
							byr = true;
						}
					}
					if (currentPassport.get(i).contains("iyr:")) { //check iyr
						int indexOfIyr = 0;
						indexOfIyr = currentPassport.get(i).indexOf("iyr:");
//						System.out.printf("The index of the i in iyr is: %d\n", indexOfIyr);
						String issueYearString = currentPassport.get(i).substring(indexOfIyr+4, indexOfIyr+8);
						try {
							if (!(currentPassport.get(i).charAt(indexOfIyr+8) == ' ')) {
								System.out.printf("LOOK AT THIS\n");
							}
						}
						catch(StringIndexOutOfBoundsException exception) {
							
						}
//						System.out.printf("The value of issueYearString is: %s\n", issueYearString);
						int issueYear = Integer.parseInt(issueYearString);
						if (issueYear >= 2010 && issueYear <= 2020) {
							iyr = true;
						}
					}
					if (currentPassport.get(i).contains("eyr:")) { //check eyr
						int indexOfEyr = 0;
						indexOfEyr = currentPassport.get(i).indexOf("eyr:");
//						System.out.printf("The index of the e in eyr is: %d\n", indexOfEyr);
						String expirationYearString = currentPassport.get(i).substring(indexOfEyr+4, indexOfEyr+8);
						try {
							if (!(currentPassport.get(i).charAt(indexOfEyr+8) == ' ')) {
								System.out.printf("LOOK AT THIS\n");
							}
						}
						catch(StringIndexOutOfBoundsException exception) {
							
						}
//						System.out.printf("The value of expirationYearString is: %s\n", expirationYearString);
						int expirationYear = Integer.parseInt(expirationYearString);
						if (expirationYear >= 2020 && expirationYear <= 2030) {
							eyr = true;
						}
					}
					if (currentPassport.get(i).contains("hgt:")) { //check hgt
						if (currentPassport.get(i).contains("cm") || currentPassport.get(i).contains("in")) {
							int indexOfHgt = 0;
							indexOfHgt = currentPassport.get(i).indexOf("hgt:");
//							System.out.printf("The index of the h in hgt is: %d\n", indexOfHgt);
							if (currentPassport.get(i).contains("cm")) {
								String heightString = currentPassport.get(i).substring(indexOfHgt+4, indexOfHgt+7);
//								System.out.printf("heightString here in cm is: %s\n", heightString);
								if (heightString.matches("[0-9]+")) {
									int height = Integer.parseInt(heightString);
									if (height >= 150 && height <= 193) {
										hgt = true;
									}
								}
								
							}
							else if (currentPassport.get(i).contains("in")) {
								char thirdDigit = currentPassport.get(i).charAt(indexOfHgt+7);
								if (Character.isDigit(thirdDigit) == false) {
									String heightString = currentPassport.get(i).substring(indexOfHgt+4, indexOfHgt+6);
//									System.out.printf("heightString here in inches is: %s\n", heightString);
									int height = Integer.parseInt(heightString);
									if (height >= 59 && height <= 76) {
										hgt = true;
									}
								}
								
							}
						}										
					}
					if (currentPassport.get(i).contains("hcl:")) { //check hcl
						int indexOfHcl = 0;
						indexOfHcl = currentPassport.get(i).indexOf("hcl:");
//						System.out.printf("The index of the h in hcl is: %d\n", indexOfHcl);
						try {
							String hclString = currentPassport.get(i).substring(indexOfHcl+4, indexOfHcl+11);
							try {
								if (!(currentPassport.get(i).charAt(indexOfHcl+11) == ' ')) {
									System.out.printf("LOOK AT THIS HCL ERROR\n");
								}
							}
							catch(StringIndexOutOfBoundsException exception) {
								
							}
//							System.out.printf("hclString here is: %s\n", hclString);
							if (hclString.charAt(0) == '#' && hclString.length() == 7) {
								int f = 1;
								int charsCorrect = 0;
								while (f < hclString.length()) {
									if ((hclString.charAt(f) >= 'a') && (hclString.charAt(f)<= 'f') || (hclString.charAt(f)>='0' && hclString.charAt(f)<= '9')) {
										charsCorrect = charsCorrect + 1;
									}
									f = f + 1;
								}
								if (charsCorrect == 6) {
									hcl = true;
								}
							}
						}
						catch(StringIndexOutOfBoundsException exception) {
							hcl = false;
						}
										
					}
					if (currentPassport.get(i).contains("ecl:")) { //check ecl
						int indexOfEcl = 0;
						indexOfEcl = currentPassport.get(i).indexOf("ecl:");
//						System.out.printf("The index of the e in ecl is: %d\n", indexOfEcl);
						String eclString = currentPassport.get(i).substring(indexOfEcl+4, indexOfEcl+7);
						try {
							if (!(currentPassport.get(i).charAt(indexOfEcl+7) == ' ')) {
								System.out.printf("LOOK AT THIS ECL ERROR\n");
							}
						}
						catch(StringIndexOutOfBoundsException exception) {
							
						}
//						System.out.printf("eclString here is: %s\n", eclString);
						if (eclString.equals("amb") || eclString.equals("blu") ||eclString.equals("brn") ||eclString.equals("gry") || eclString.equals("grn") || eclString.equals("hzl") || eclString.equals("oth")) {
							ecl = true;
						}
					}
					if (currentPassport.get(i).contains("pid:")) { //check pid
						boolean localPid = true;
						int indexOfPid = 0;
						indexOfPid = currentPassport.get(i).indexOf("pid:");
						
//						System.out.printf("The index of the p in pid is: %d\n", indexOfPid);
						try {
							String pidString = currentPassport.get(i).substring(indexOfPid+4, indexOfPid+13);
							try {
								char pidExtraChar = currentPassport.get(i).charAt(indexOfPid+13);
								if (Character.isDigit(pidExtraChar)) {
									System.out.printf("LOOK AT THIS PID ERROR\n");
									localPid = false;
								}
							}
							catch(StringIndexOutOfBoundsException exception) {
								
							}
//							System.out.printf("pidString here is: %s\n", pidString);
							if (pidString.length() == 9) {
								//int pidInt = Integer.parseInt(pidString);
								if (pidString.matches("[0-9]+") && localPid) {
									pid = true;
								}
							}
						}
						catch(StringIndexOutOfBoundsException exception) {
							pid = false;
						}
						
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
