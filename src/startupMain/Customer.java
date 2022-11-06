package startupMain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Customer {

	MovieDetails movieDetails;

	public Customer(MovieDetails movieDetails){
		this.movieDetails = movieDetails;
	}

	public void showCustomerSystem() {
		// TODO Auto-generated method stub
		//xdd
		System.out.println("1. Search/List movie");
		System.out.println("2. Check seat availibility and selection of seat(s)");
		System.out.println("3. View booking history");
		System.out.println("4. List Top 5 ranking of movies");
		System.out.println("5. Quit");
		System.out.print("Enter your choice: ");
		Scanner Choice = new Scanner(System.in);
		int userChoice = Choice.nextInt();
		while(userChoice != 5) {
			if (userChoice == 1) {
				File file = new File("MoviesTest.txt");
				try {
					Scanner scan = new Scanner(file);
					while(scan.hasNextLine())
					{
						String nextLine = scan.nextLine();
						System.out.println(nextLine);
					}
					showCustomerSystem();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (userChoice == 2) {
				Booking booking = new Booking();
				Cineplex cineplex = new Cineplex();
				// movieDetails.GetMovieDetailsFromFile();
				booking.CineplexChoiceDisplay(cineplex);
				booking.ChooseACineplex();
				String cineplexChoice = booking.getCineplexChoice();
				if (cineplexChoice == "Orchard") {
					ArrayList<String> cinemas = cineplex.GetCinemasOfCineplex(cineplexChoice);
					booking.CinemaChoiceDisplay(cineplex, cinemas);
					booking.ChooseACinema();
					if (booking.getCinemaChoice() == "Quit"){
						continue;
					}
					Cinema orchard = new Cinema(booking.getCinemaChoice());
					ArrayList<String> movies = orchard.GetMoviesOfCinema();
					booking.MovieChoiceDisplay(orchard, movies);
					booking.ChooseAMovie();
					if (booking.getMovieChoice() == "Quit"){
						continue;
					}
					String movieChoice = booking.getMovieChoice();
					movieDetails.DisplayMovieDetails(movieChoice);
					booking.ChooseASeat();
					movieDetails.UpdateBookedSeats(movieChoice, booking.getSeatChoice());
				}
				else if (cineplexChoice == "Sentosa") {
					Cinema sentosa = new Cinema(cineplexChoice);
					sentosa.Display();
				}
				else if (cineplexChoice == "Woodlands") {
					Cinema woodlands = new Cinema(cineplexChoice);
					woodlands.Display();
				}
				else if (cineplexChoice == "Quit"){
					userChoice = 5;
					showCustomerSystem();
				}
				else {
					userChoice = 5;
					showCustomerSystem();
				}
			}
		}
	}

}
