package startupMain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MovieListingConfig {

	private static Scanner sc = new Scanner(System.in);
	
	private int choice;
	
	public void mlConfigOptions() {
		
		while (true) {
			System.out.println("\nSelect an option:\n"
					 + "1. Create Movie Listing\n"
					 + "2. Update Movie Listing\n"
					 + "3. Remove Movie Listing\n"
					 + "4. Return to Staff Menu\n");
			
			choice = sc.nextInt();
			
			switch (choice) {
				case 1: createMovieListing();
						break;
//				case 2: updateMovieListing();
//						break;
//				case 3: removeMovieListing();
//						break;
				case 4: System.out.println("\nReturning to Staff Menu...\n");
						return;
				default: System.out.println("\nInvalid Option.\n");
			}
		}
	}
	
	public void createMovieListing() {
		Movie newMovie = new Movie();
		newMovie.createMovie(); //To ask input for the movie details
		//newMovie.viewMovieDetails();
		//add newMovie to movie list
		String newMovieString = newMovie.getTitle() + "@" + newMovie.getShowingStatus() + "@" + newMovie.getSynopsis() + "@" + 
		newMovie.getDirector() + "@" + newMovie.getCast() + "@NA@0@0";
		//"@NA@0@0" referring to overallrating, reviewsandratings, ticketsales
		
		//maybe can make a method for this whole file writing thing
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("MoviesTest.txt", true));
			writer.write(newMovieString + "\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
