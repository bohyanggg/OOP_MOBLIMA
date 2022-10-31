package startupMain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestingTesting123 {
	public static void readTextFile() {
	    //pass the path to the file as a parameter
	    File file = new File("MoviesTest.txt");
	    Scanner sc;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
	 
	    while (sc.hasNextLine()) {
	    	sc.useDelimiter("@");
	    	System.out.println(sc.next());
	    }
	}
}
