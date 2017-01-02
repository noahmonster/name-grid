package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;

/**
 * Reads a file line by line and pulls out names of a certain size.
 * @author Noah Solomon
 */
public class Reader {
	
	private Collection<String> names;
	private int nameLength;

	/**
	 * Instantiate the reader.
	 * @param nameLength The length requirement of the names.
	 */
	public Reader(int nameLength) {
		this.nameLength = nameLength;
		this.names = new HashSet<String>();
	}
	
	/**
	 * Read the file and store the names
	 * @param pathToFile path to the file
	 * @return number of unique names of the specified size found
	 * @throws IOException
	 */
	public int readFile(String pathToFile) throws IOException {
		Path path = Paths.get(pathToFile);
		Files.lines(path).filter(name -> name.length() == this.nameLength).forEach(name -> names.add(name.toLowerCase()));
		return names.size();
	}
	
	/**
	 * Get the names
	 * @return
	 */
	public Collection<String> getNames() {
		return names;
	}
	
	
}
