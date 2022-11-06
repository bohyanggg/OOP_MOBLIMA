package startupMain;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class Cinema extends SeatingPlan{
	private String Name;
	private String[][] plan;
	private HashMap<String, ArrayList<String>> cinema;
	private ArrayList<String> movies = new ArrayList<String>();
	
	public Cinema() {
		
	}
	
	public Cinema(String Name) {
		this.Name = Name;
		this.getMovies();
	}
	
	public String GetName() {
		return this.Name;
	}
	
	private void getMovies() {
		try {
			Path fileName = Path.of("Cinemas.txt");
			ArrayList<String> strList = (ArrayList<String>) Files.readAllLines(fileName);
			for (String line : strList) {
				String[] info = line.split("@");
				if (info[0].equals(this.Name)) {
					
					for (int i = 1; i < info.length ; i++) {
						System.out.println(info[i]);
						movies.add(info[i]);
					}
				}
			}
		}
		catch (Exception err){
			System.err.println(err);
		}
	}
	
	public ArrayList<String> GetMoviesOfCinema() {
		return this.movies;
	}
	
	public void PlanDisplay() {
		System.out.println(this.Name + "Seats: (0) is available, (x) is occupied.");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j ++) {
				System.out.print(plan[i][j]);
			}
			System.out.println();
		}
	}
	
	public void MovieChoiceDisplay(ArrayList<String> movies) {
		System.out.println("Available movies: ");
		int counter = 1;
		for (String movie : movies) {
			System.out.println(counter + ". " + movie);
			counter += 1;
		}
		System.out.println(counter + ". Exit");
	}

	public void DisplaySeats(String title){

	}
}
