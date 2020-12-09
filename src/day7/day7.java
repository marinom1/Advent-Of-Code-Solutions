package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class day7 {
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>(760); //holds data from input file, 1 line per element
		ArrayList<String> listOfBags = new ArrayList<String>(760);
		try {
			array = readFileAndStoreInArray(array);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < array.size(); i++) { //loop to print contents of array
//			System.out.printf("array["+i+"] is: %s\n", array.get(i));
		}
		for (int i = 0; i < array.size(); i++ ) { //loop to put each word into nameOfBagSplit, then extract first two words and put into listOfBags
			String[] nameOfBagSplit = array.get(i).toString().split("\\s+");
			String nameOfBag = nameOfBagSplit[0] + " " + nameOfBagSplit[1];
			listOfBags.add(nameOfBag);
		}
		for (int i = 0; i < listOfBags.size(); i++) { //loop to print contents of listOfBags
//			System.out.printf("listOfBags["+i+"] is: %s\n", listOfBags.get(i));
		}
		Map<String, Boolean> bagMap = new LinkedHashMap<String, Boolean>();
		for (int i = 0; i < listOfBags.size(); i++) { //loop to make a map of the bags and whether they contain shiny gold is true or not
			bagMap.put(listOfBags.get(i), false);
		}
		Set<Map.Entry<String, Boolean>> bagMapToPrint = bagMap.entrySet();
		for (Map.Entry<String, Boolean> m : bagMapToPrint) { //print bagMap to make sure the values and keys look ok
//			System.out.println(m.getKey() + " - " + m.getValue());		
		}
		int loops = 2;
		int loopCounter = 0;
		
		while (loopCounter < loops) {
			Iterator<Map.Entry<String, Boolean>> iterator = bagMap.entrySet().iterator();
			for (int i = 0; i < bagMap.size(); i++ ) { //loop through the bag names in bagMap and check if shiny gold can be kept inside it
				
				Map.Entry<String, Boolean> actualValue = iterator.next();
				String bagName = actualValue.getKey();
//				System.out.printf("bagName here is: %s\n",bagName);
				String currentLine = array.get(i);
				if (currentLine.contains("shiny gold")) { //if bag can hold shiny gold directly
					bagMap.replace(bagName, true);
				}
				System.out.printf("the boolean currentLine.contains(bagName) here is: %b\n" , currentLine.contains(bagName));
				System.out.printf("the boolean actualValue.getValue() here is: %b\n" , actualValue.getValue());
				if (currentLine.contains(bagName) && actualValue.getValue() == true) { //if a bag has bag that can hold shiny gold
					bagMap.replace(bagName, true);
				}
				
				if (actualValue.getValue()==true) { //print true keys
					System.out.printf("The %dth key-value in bagMap is: %s\n", i,actualValue.toString());
				}
//				System.out.printf("The %dth key-value in bagMap is: %s\n", i,actualValue.toString());
			}
			loopCounter = loopCounter + 1;
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	/**
	 * This method will read the string data in the input file, and store it into an
	 * ArrayList with each line in the file corresponding to one element in the array
	 * 
	 * @param a
	 * @return a
	 * @throws FileNotFoundException
	 */
	public static ArrayList<String> readFileAndStoreInArray(ArrayList<String> a) throws FileNotFoundException {
		File myObj = new File("src/day7/day7input.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			a.add(data);
		}
		myReader.close();
		return a;
	}
}
