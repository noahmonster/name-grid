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

/*
names.add("mason");
names.add("jacob");
names.add("ethan");
names.add("james");
names.add("aiden");
names.add("logan");
names.add("lucas");
names.add("david");
names.add("dylan");
names.add("henry");
names.add("isaac");
names.add("wyatt");
names.add("caleb");
names.add("jaxon");
names.add("aaron");
names.add("angel");
names.add("gavin");
names.add("nolan");
names.add("chase");
names.add("kevin");
names.add("asher");
names.add("tyler");
names.add("mateo");
names.add("jason");
names.add("ayden");
names.add("blake");
names.add("ryder");
names.add("elias");
names.add("roman");
names.add("brody");
names.add("miles");
names.add("micah");
names.add("diego");
names.add("jesus");
names.add("silas");
names.add("bryce");
names.add("jayce");
names.add("jonah");
names.add("ryker");
names.add("kaleb");
names.add("bryan");
names.add("colin");
names.add("grant");
names.add("jesse");
names.add("kaden");
names.add("oscar");
names.add("aidan");
names.add("avery");
names.add("brian");
names.add("caden");
names.add("riley");
names.add("brady");
names.add("jaden");
names.add("peter");
names.add("derek");
names.add("rowan");
names.add("myles");
names.add("jorge");
names.add("simon");
names.add("judah");
names.add("rylan");
names.add("river");
names.add("lukas");
names.add("devin");
names.add("felix");
names.add("amari");
names.add("erick");
names.add("josue");
names.add("rhett");
names.add("andre");
names.add("cesar");
names.add("titus");
names.add("mario");
names.add("kyler");
names.add("shane");
names.add("louis");
names.add("edwin");
names.add("tyson");
names.add("edgar");
names.add("marco");
names.add("dante");
names.add("kyrie");
names.add("ronan");
names.add("cohen");
names.add("jared");
names.add("allen");
names.add("shawn");
names.add("grady");
names.add("quinn");
names.add("frank");
names.add("major");
names.add("pedro");
names.add("orion");
names.add("ruben");
names.add("clark");
names.add("romeo");
names.add("malik");
names.add("abram");
names.add("kason");
names.add("pablo");
names.add("drake");
names.add("bruce");
names.add("corey");
names.add("ellis");
names.add("milan");
names.add("keith");
names.add("danny");
names.add("damon");
names.add("jonas");
names.add("brock");
names.add("colby");
names.add("julio");
names.add("scott");
names.add("cason");
names.add("rocco");
names.add("royal");
names.add("kasen");
names.add("moses");
names.add("cyrus");
names.add("davis");
names.add("conor");
names.add("jaime");
names.add("ronin");
names.add("atlas");
names.add("jerry");
names.add("ahmed");
names.add("zayne");
names.add("bodhi");
names.add("arjun");
names.add("chris");
names.add("nasir");
names.add("omari");
names.add("nixon");
names.add("bowen");
names.add("jakob");
names.add("aarav");
names.add("royce");
names.add("kyson");
names.add("hayes");
names.add("casey");
names.add("moshe");
names.add("johan");
names.add("larry");
names.add("devon");
names.add("trent");
names.add("issac");
names.add("ahmad");
names.add("uriel");
names.add("lewis");
names.add("randy");
names.add("reece");
names.add("jimmy");
names.add("soren");
names.add("uriah");
names.add("roger");
names.add("rayan");
names.add("ricky");
names.add("jalen");
names.add("tatum");
names.add("yusuf");
names.add("byron");
names.add("ariel");
names.add("alvin");
names.add("lance");
names.add("talon");
names.add("sylas");
names.add("hamza");
names.add("ramon");
names.add("mekhi");
names.add("ayaan");
names.add("titan");
names.add("rowen");
names.add("jaxen");
names.add("allan");
names.add("yahir");
names.add("terry");
names.add("kylan");
names.add("rohan");
names.add("eddie");
names.add("makai");
names.add("casen");
names.add("tripp");
names.add("elian");
names.add("flynn");
names.add("jamir");
names.add("kyree");
names.add("aryan");
names.add("axton");
names.add("reese");
names.add("tommy");
names.add("blaze");
names.add("arian");
names.add("bruno");
names.add("layne");
names.add("tomas");
names.add("alden");
names.add("chaim");
names.add("samir");
names.add("yosef");
names.add("jamal");
names.add("bobby");
names.add("brett");
names.add("wayne");
names.add("emery");
names.add("lucca");
names.add("vance");
names.add("shaun");
names.add("maxim");
names.add("harry");
names.add("aaden");
names.add("kohen");
names.add("enoch");
names.add("trace");
names.add("aydin");
names.add("anson");
names.add("clyde");
names.add("billy");
names.add("lamar");
names.add("jamie");
names.add("kolby");
names.add("sonny");
names.add("emory");
names.add("heath");
names.add("amare");
names.add("ameer");
names.add("emmet");
names.add("javon");
names.add("zaire");
names.add("jordy");
names.add("jairo");
names.add("brent");
names.add("gauge");
names.add("kenny");
names.add("brice");
names.add("lyric");
names.add("kalel");
names.add("dilan");
names.add("craig");
names.add("dario");
names.add("jadon");
names.add("riaan");
names.add("rocky");
names.add("ridge");
names.add("chace");
names.add("steve");
names.add("boone");
names.add("cairo");
names.add("davin");
names.add("anton");
names.add("aydan");
names.add("bodie");
names.add("louie");
names.add("robin");
names.add("yahya");
names.add("boden");
names.add("kylen");
names.add("chevy");
names.add("juelz");
names.add("leroy");
names.add("briar");

//possible names
names.add("leone");
names.add("anker");
names.add("enron");
*/