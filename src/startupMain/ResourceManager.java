package startupMain;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

/**
 * Contains methods for loading and saving objects through text files
 */
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
	
	public static ResourceManager getInstance() {
        if (instance == null) {
            instance = new ResourceManager();
        }
        return instance;
    }
	
	/**
	 * Loads list of all movies from text file to ArrayList format
	 * @param movieList
	 * @return
	 */
	public static ArrayList<Movie> getmovieList(ArrayList<Movie> movieList)
	{
		 try {
			 ArrayList<Movie> txtmovieList = new ArrayList<>();
			 txtmovieList = (ArrayList<Movie>) ResourceManager.load("Movies.txt");
			 return txtmovieList;
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		System.out.println("No Movies!");
		return movieList;
	}
	
	/**
	 * Saves list of all movies to text file
	 * @param movieList
	 */
	public static void addmovieList(ArrayList<Movie> movieList)
	{
		try {
			ResourceManager.save(movieList, "Movies.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * To load current ticket pricing from TicketPricing.txt
	 * @return
	 */
	public static TicketPricing loadTicketPricing()
	{
		TicketPricing currentTicketPricing = new TicketPricing();
		try {
			currentTicketPricing = (TicketPricing) ResourceManager.load("TicketPricing.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentTicketPricing;
	}
	
	/**
	 * To save updated ticket pricing to TicketPricing.txt
	 * @param updatedTicketPricing
	 */
	public static void saveTicketPricing(TicketPricing updatedTicketPricing)
	{
		try {
			ResourceManager.save(updatedTicketPricing, "TicketPricing.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * To load list of holidays from Holidays.txt
	 * @return
	 */
	public static ArrayList<String> loadHolidays()
	{
		ArrayList<String> holidays = new ArrayList<String>();
		try {
			holidays = (ArrayList<String>) ResourceManager.load("Holidays.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return holidays;
	}
	
	/**
	 * To save updated list of holidays to Holidays.txt
	 * @param updatedHolidays
	 */
	public static void saveHolidays(ArrayList<String> updatedHolidays)
	{
		try {
			ResourceManager.save(updatedHolidays, "Holidays.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
