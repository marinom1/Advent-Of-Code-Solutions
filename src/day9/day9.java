package day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * made by marinom1 on github
 * Working solution for day9 part 1 Advent of Code 2020
 */
public class day9 {
	public static void main (String[] args) {
		ArrayList<String> array = new ArrayList<String>(700); // holds data from input file, 1 line per element
		try {
			array = readFileAndStoreInArray(array);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < array.size(); i++) { // loop to print contents of array
			System.out.printf("array[" + i + "] is: %s\n", array.get(i));
		}
		
		int currentLowestIndex = 0;
		
		while (true) {
			
		
		Queue<Integer> q = new LinkedList<>(); 
		for (int i = currentLowestIndex; i < 25+currentLowestIndex; i = i + 1) {
			q.add(Integer.parseInt(array.get(i)));
		}
//		System.out.printf("The q is: %s\n", q);
		int sum = Integer.parseInt(array.get(25+currentLowestIndex));
		System.out.printf("sum is: %d\n", sum);
		int num1 = 0;
		int num2 = 0;
		Iterator iterator = q.iterator(); 
		int[] current25 = new int[25];
        for (int i = 0; i < 25; i = i + 1) {
            current25[i] = (int) iterator.next();
            System.out.printf("current25["+i+"] is: %d\n", current25[i]);
        }
        
        boolean valid = false;
        for (int i = 0; i < 25; i = i + 1) {
        	num1 = current25[i];
        	for (int j = 0; j < 25; j = j + 1) {
        		num2= current25[j];
        		if (num1+num2==sum & i!=j) {
        			System.out.printf("Sum: %d - num1: %d - num2: %d\n", sum,num1,num2);
        			valid = true;
        		}
        	}
        }
        if (valid == false) {
        	System.out.printf("Found number that doesnt have 2 pairs add to it: %d\n", sum);
        	System.exit(0);
        }
        currentLowestIndex = currentLowestIndex + 1;
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
		File myObj = new File("src/day9/day9input.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			a.add(data);
		}
		myReader.close();
		return a;
	}
}
