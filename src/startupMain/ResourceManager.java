package startupMain;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class ResourceManager {
	public static ResourceManager instance;
	public static void save(Serializable data, String fileName) throws Exception
	{
		try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
			oos.writeObject(data);
			oos.close();
		}
	}
	
	public static Object load(String fileName) throws Exception{
		try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
			return ois.readObject();
		}
	}
	
	public static ArrayList<Movie> getmovieList(ArrayList<Movie> movieList) //to load movieList from array to txt file
	{
		 try {
			 ArrayList<Movie> txtmovieList = new ArrayList<>();
			 txtmovieList = (ArrayList<Movie>) ResourceManager.load("MoviesTest.txt");
			 return txtmovieList;
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		System.out.println("No Movies!");
		return movieList;
	}
	
	public static void addmovieList(ArrayList<Movie> movieList) //to add movieList array to txt file
	{
		try {
			ResourceManager.save(movieList, "MoviesTest.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static ResourceManager getInstance() {
        if (instance == null) {
            instance = new ResourceManager();
        }
        return instance;
    }
	
}
