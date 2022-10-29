package startupMain;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Customer {

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
				
			}
			if (userChoice == 2) {
				Booking booking = new Booking();
				Cineplex cineplex = new Cineplex();
				booking.CineplexChoiceDisplay(cineplex);
				booking.ChooseACineplex();
				String cineplexChoice = booking.getCineplexChoice();
				if (cineplexChoice == "Orchard") {
					ArrayList<String> cinemas = cineplex.GetCinemasOfCineplex(cineplexChoice);
					booking.CinemaChoiceDisplay(cineplex, cinemas);
					booking.ChooseACinema();
					Cinema orchard = new Cinema(booking.getCinemaChoice());
					ArrayList<String> movies = orchard.GetMoviesOfCinema();
					booking.MovieChoiceDisplay(orchard, movies);
//					orchard.Display();
				}
				else if (cineplexChoice == "Sentosa") {
					Cinema sentosa = new Cinema(cineplexChoice);
					sentosa.Display();
				}
				else if (cineplexChoice == "Woodlands") {
					Cinema woodlands = new Cinema(cineplexChoice);
					woodlands.Display();
				}
				else {
					userChoice = 5;
					showCustomerSystem();
				}
			}
		}
	}

}
