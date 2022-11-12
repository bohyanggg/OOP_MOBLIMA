package startupMain;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Boundary class that 
 * @author Low Zheng Han, Lou Sim Teng, MD Firdaus Bin Azizan, Hsieh Boh Yang, Martin Chin
 *
 */
public class CinemaShowtimesConfig {

	private static Scanner sc = new Scanner(System.in);
	
	private int choice;
	
	/**
	 * Cinema Showtimes Configuration Menu
	 */
	public void csConfigOptions() {
		
		while (true) {
			System.out.println("\nSelect an option:\n"
					 + "1. Create/Update/Remove a Cinema Showing\n"
					 + "2. View all Cinema Showings\n"
					 + "3. Return to Staff Menu\n");
			
			choice = sc.nextInt();
			
			switch (choice) {
				case 1: createUpdateRemoveCinemaShowing();
						break;
				case 2: viewCinemaShowing();
						break;
				case 3: System.out.println("\nReturning to Staff Menu...\n");
						return;
				default: System.out.println("\nInvalid Option.\n");
			}
		}
	}

	/**
	 * Change cinema showtimes for selected movie
	 */
	private void createUpdateRemoveCinemaShowing() {

		ArrayList<Movie> movieList = new ArrayList<>(); //Create arraylist to store movie objects from txt
		movieList = ResourceManager.getmovieList(movieList); //to take objects from txt and store into movieList array
		System.out.println("\nSelect movie to be showed: ");
		for (int i=0; i<movieList.size(); i++) //To iterate through the movieListArray from the txt file
		{
			System.out.print("Movie " + (i+1) + ": ");
			movieList.get(i).viewimportantMovieDetails(); //To show only the important details of the file 
			System.out.print("\n");
		}
		int choice = sc.nextInt()-1;
		movieList.get(choice).printCinemaShowtime();
		movieList.get(choice).setCinemaShowtime();
		ResourceManager.addmovieList(movieList); //add the movie arraylist back into txt file
	}
	
	/**
	 * Displays movies to be showed in each cinema
	 */
	private void viewCinemaShowing() {

		ArrayList<Movie> movieList = new ArrayList<>(); //Create arraylist to store movie objects from txt
		movieList = ResourceManager.getmovieList(movieList); //to take objects from txt and store into movieList array
		//for Cinema 1, 2, 3
		for (int i=0; i<3; i++) {
			System.out.println("\nMovie Showings in Cinema " + (i+1) + ": ");
			for (int j=0; j<movieList.size(); j++) {
				Movie currentMovie = movieList.get(j);
				//if currently accessed movie's showing status!=End of Showing and has valid Cinema 1 showtime
				if (!currentMovie.getShowingStatus().equals("End of Showing") && !currentMovie.getCinemaShowtime()[i].isEmpty()) {
					System.out.println(currentMovie.getTitle() + " " + currentMovie.getCinemaShowtime()[i]);
				}
			}
		}
	}
}
