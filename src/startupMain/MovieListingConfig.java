package startupMain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintStream;

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
				//case 2: updateMovieListing();
						//break;
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
		//add newMovie to movie list
		ArrayList<Movie> movieList = new ArrayList<>();
		try {
			movieList = (ArrayList<Movie>) ResourceManager.load("MoviesTest.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		movieList.add(newMovie);
		try {
			ResourceManager.save(movieList, "MoviesTest.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newMovie.viewMovieDetails();
		for (Movie movie: movieList)
		{
			System.out.println(movie);
		}
	
		/*
		try {
			ResourceManager.save(newMovie, "MoviesTest.txt");
		}
		catch (Exception e)
		{
			System.out.println("Unable to save: " + e.getMessage());
		}
		try {
			newMovie = (Movie) ResourceManager.load("MoviesTest.txt");	
			newMovie.viewMovieDetails();
		}
		catch (Exception e)
		{
			System.out.println("Unable to load: " + e.getMessage());
		}
		/* Only works for printing the object into the txt
		try (PrintStream printStream = new PrintStream("MoviesTest.txt"))
		{
			printStream.print(newMovie);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}*/
		
		
		//COMMENT THIS OFF FIRST TO TRY TO DO SERIALIZATION INSTEAD
		/*String newMovieString = newMovie.getTitle() + "@" + newMovie.getShowingStatus() + "@" + newMovie.getSynopsis() + "@" + 
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
		}*/
	}
	//REQUIRE READING/MODIFICATION OF TEXT FILE (UNFINISHED)
	/*public void updateMovieListing() {
		//System.out.print("\nEnter title of movie to be updated: ");
		TestingTesting123.readTextFile();
	}*/
}