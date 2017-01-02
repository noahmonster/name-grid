package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A solution to the NPR Sunday Puzzle for Jan 01, 2017.  This class finds a number of names that, when stacked upon each other, form a 
 * "word square" such that the names are spelled vertically and horizontally in the same order.
 * 
 * Example:
 * 
 * TODD
 * OMAR
 * DAVE
 * DREW
 * 
 * This class can solve for a given GRID_SIZE.  The current was set to 5 since that was the puzzle.
 * 
 * @author Noah Solomon
 *
 */
public class Main {
	
	//the size to make the puzzle
	private static int GRID_SIZE = 5;
	//location of the file from which to read names
	private static String FILE_PATH = "names.txt";
	//the names from the file
	private static Collection<String> names;
	//the current number of solutions, used for output
	private static int solutions = 0;
	
	public static void main(String[] args) {
		//instantiate the reader class
		Reader r = new Reader(GRID_SIZE);
		
		try {
			//read the names from the file
			int numNames = r.readFile(FILE_PATH);
			if (numNames > 0) {
				System.out.println(numNames + " unique names.");
				names = r.getNames();
				List<String> grid = new ArrayList<String>();
				
				//Iterate through the list of names.  We have to start somewhere, so add a name to the list and try to solve.
				for (String name : names) {
					grid.add(name);
					
					//try to create a word square with this name
					recurse(grid);
					
					grid.clear();
				}
			}
			else {
				System.out.println("No names found.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		 
	}
	
	/**
	 * A recursive function to find a solution to the problem.  
	 * @param list The current incomplete word square
	 */
	public static void recurse(List<String> list) {
		int currentSize = list.size();
		if(currentSize < GRID_SIZE) {
			//keep trying to solve, not yet complete
			
			//find a name that matches the pattern so far.
			String sw = getRequirement(list, currentSize);
						
			//iterate through the list of names to find one that matches the requirement  
			for (String name : names) {
				if(name.startsWith(sw)) {
					//found a name that matches the requirement so far.  Add it and recurse.
					list.add(name);
					
					recurse(list);
					
					//remove it after the recurse to find more possible solutions
					list.remove(list.size() - 1);
				}
			}
		}
		else {
			//solution found!
			printList(list);
		}
	}
	
	/**
	 * Get an incomplete name from the next unsolved line of the puzzle.  The next name that we pick must start with this string.
	 * @param list
	 * @param currentSize
	 * @return
	 */
	public static String getRequirement(List<String> list, int currentSize) {
		String req = "";
		for(int i = 0; i < list.size(); i++) {
			String name = list.get(i);
			req += name.substring(currentSize, currentSize+1);
		}
		return req;
	}
	
	/**
	 * Print the solution
	 * @param list
	 */
	public static void printList(List<String> list) {
		System.out.println("Solution " + ++solutions + ": ");
		for (String str : list) {
			System.out.println(str);
		}
		System.out.println("------");
	}

}
