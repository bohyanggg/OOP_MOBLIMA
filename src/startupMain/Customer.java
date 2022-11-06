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

		while (true) {
			System.out.println("********** Customer Menu **********");
			System.out.println("1. Search/List movie");
			System.out.println("2. Check seat availibility and selection of seat(s)");
			System.out.println("3. View booking history");
			System.out.println("4. List Top 5 ranking of movies");
			System.out.println("5. Quit");
			System.out.print("Enter your choice: ");
			Scanner Choice = new Scanner(System.in);
			int userChoice = Choice.nextInt();
			while(userChoice != 5) {
				if (userChoice == 1) { //i copied over this whole part from MovieListingConfig 's viewmovielisting
					ArrayList<Movie> movieList = new ArrayList<>(); //Create arraylist to store movie objects from txt
					movieList = ResourceManager.getmovieList(movieList); //to take objects from txt and store into movieList array
					int i = 1; //To number the movies
					System.out.print("\n");
					for (Movie movie: movieList)
					{
						System.out.print("Movie " + i + ": ");
						i++;
						movie.viewimportantMovieDetails();
						System.out.print("\n");
					}
					int totalMovie = i -1;
					i = 1;
					System.out.println("\nView all details of a Movie? (Y/N)");
					Scanner sc = new Scanner(System.in);
					String choice = sc.next();
					if (choice.equalsIgnoreCase("Y"))
					{
						System.out.println("\nEnter Movie number: ");
						int movieNumber = sc.nextInt();
						if (movieNumber > totalMovie)
						{
							System.out.println("\nInvalid Input Number!");
							return;
						}
						for (Movie movie: movieList)
						{
							if (i == movieNumber)
							{
								movie.viewallMovieDetails();
								System.out.print("\n");
								break;
							}
							i++;
						}
						break;
					}
					else if (choice.equalsIgnoreCase("N"))
					{
						break;
					}
					else
					{
						System.out.println("\nInvalid Input!");
						break;
					}
					
				}
				
				if (userChoice == 2) {
					Booking booking = new Booking();
					Cineplex cineplex = new Cineplex();
					// movieDetails.GetMovieDetailsFromFile();
					booking.CineplexChoiceDisplay(cineplex);
					booking.ChooseACineplex();
					String cineplexChoice = booking.getCineplexChoice();
					if (cineplexChoice == "Cathay Cineplexes Lot One") {
						ArrayList<String> cinemas = cineplex.GetCinemasOfCineplex(cineplexChoice);
						booking.CinemaChoiceDisplay(cineplex, cinemas);
						booking.ChooseACinema();
						if (booking.getCinemaChoice() == "Quit"){
							continue;
						}
						Cinema lotOne = new Cinema(booking.getCinemaChoice());
						ArrayList<String> movies = lotOne.GetMoviesOfCinema();
						booking.MovieChoiceDisplay(lotOne, movies);
						booking.ChooseAMovie();
						if (booking.getMovieChoice() == "Quit"){
							continue;
						}
						String movieChoice = booking.getMovieChoice();
						movieDetails.DisplayMovieDetails(movieChoice);
						booking.ChooseASeat();
						movieDetails.UpdateBookedSeats(movieChoice, booking.getSeatChoice());
					}
					else if (cineplexChoice == "Cathay Cineplexes Clementi Mall") {
						Cinema clementiMall = new Cinema(cineplexChoice);
						clementiMall.Display();
					}
					else if (cineplexChoice == "Cathay Cineplexes Jewel") {
						Cinema jewel = new Cinema(cineplexChoice);
						jewel.Display();
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
				
				if (userChoice == 3) {
					//TODO view booking history not done yet
					System.out.println("view booking history not done yet");
				}
				
				if (userChoice == 4) {
					//TODO list top 5 ranking of movies not done yet
					System.out.println("list top 5 ranking of movies not done yet");
				}
			}
		}
	}
}
