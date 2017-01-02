package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
	
	private static int GRID_SIZE = 5;
	private static String FILE_PATH = "names.txt";
	private static Collection<String> names;
	private static int solutions = 0;
	
	public static void main(String[] args) {
		Reader r = new Reader(GRID_SIZE);
		
		try {
			int numNames = r.readFile(FILE_PATH);
			if (numNames > 0) {
				System.out.println(numNames + " unique names.");
				names = r.getNames();
				List<String> grid = new ArrayList<String>();
				
				for (String name : names) {
					grid.add(name);
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
	
	public static void recurse(List<String> list) {
		int currentSize = list.size();
		if(currentSize < GRID_SIZE) {
			//keep going
			
			String sw = getRequirement(list, currentSize);
			//find a name that matches the pattern so far.
			if(list.size() > 3) {
				//System.out.println("Possible name: " + sw);
			}
			
			for (String name : names) {
				if(name.startsWith(sw)) {
					//add it and recourse
					list.add(name);
					recurse(list);
					
					//remove it after the recurse to find more
					list.remove(list.size() - 1);
				}
			}
		}
		else {
			printList(list);
		}
	}
	
	public static String getRequirement(List<String> list, int currentSize) {
		String req = "";
		for(int i = 0; i < list.size(); i++) {
			String name = list.get(i);
			req += name.substring(currentSize, currentSize+1);
		}
		return req;
	}
	
	public static void printList(List<String> list) {
		System.out.println("Solution " + ++solutions + ": ");
		for (String str : list) {
			System.out.println(str);
		}
		System.out.println("------");
	}

}
