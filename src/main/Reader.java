package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;

public class Reader {
	
	private Collection<String> names;
	private int nameLength;

	public Reader(int nameLength) {
		this.nameLength = nameLength;
		this.names = new HashSet<String>();
	}
	
	public int readFile(String pathToFile) throws IOException {
		Path path = Paths.get(pathToFile);
		Files.lines(path).filter(name -> name.length() == this.nameLength).forEach(name -> names.add(name.toLowerCase()));
		return names.size();
	}
	
	public Collection<String> getNames() {
		return names;
	}
	
	
}
