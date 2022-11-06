package startupMain;

import java.util.ArrayList;
import java.util.Scanner;

public class Booking {
	private String CineplexChoice;
	private Scanner cineplexChoice = new Scanner(System.in);

	private String CinemaChoice;
	private Scanner cinemaChoice = new Scanner(System.in);

	private String MovieChoice;
	private Scanner movieChoice = new Scanner(System.in);

	private String SeatChoice;
	private Scanner seatChoice = new Scanner(System.in);

	public Booking() {

	}

	public String getCineplexChoice() {
		return this.CineplexChoice;
	}

	public String getCinemaChoice() {
		return this.CinemaChoice;
	}

	public String getMovieChoice() {
		return this.MovieChoice;
	}

	public String getSeatChoice(){
		return this.SeatChoice;
	}

	public void CineplexChoiceDisplay(Cineplex cp) {
		cp.CineplexChoiceDisplay();
	}

	public void CinemaChoiceDisplay(Cineplex cp, ArrayList<String> cinemas) {
		cp.CinemaChoiceDisplay(cinemas);
	}

	public void MovieChoiceDisplay(Cinema c, ArrayList<String> movies) {
		c.MovieChoiceDisplay(movies);
	}

	public void SeatingPlanDisplay(MovieDetails details){

	}

	public void ChooseACineplex() {
		System.out.print("Enter your choice: ");
		int userChoice = cineplexChoice.nextInt();
		if (userChoice == 1) {
			CineplexChoice = "Orchard";
		}
		else if (userChoice == 2) {
			CineplexChoice = "Sentosa";
		}
		else if (userChoice == 3) {
			CineplexChoice = "Woodlands";
		}
		else if (userChoice == 4){
			CineplexChoice = "Quit";
		}
		else {
			ChooseACineplex();
		}
	}

	public void ChooseACinema() {
		System.out.print("Enter your choice: ");
		int userChoice = cinemaChoice.nextInt();
		if (userChoice == 1) {
			CinemaChoice = "Golden Village";
		}
		else if (userChoice == 2) {
			CinemaChoice = "Shaw Theatre";
		}
		else if (userChoice == 3) {
			CinemaChoice = "Cathay Cineplex";
		}
		else if (userChoice == 4){
			CinemaChoice = "Quit";
		}
		else {
			ChooseACineplex();
		}
	}

	public void ChooseAMovie(){
		System.out.println("Enter your choice: ");
		int userChoice = movieChoice.nextInt();
		if (userChoice == 1) {
			MovieChoice = "Minions: The Rise of Gru";
		}
		else if (userChoice == 2) {
			MovieChoice = "Black Adam";
		}
		else if (userChoice == 3) {
			MovieChoice = "Black Panther: Wakanda Forever";
		}
		else if (userChoice == 4){
			MovieChoice = "Quit";
		}
		else {
			ChooseACineplex();
		}
	}

	public void ChooseASeat(){
		System.out.println("Enter your choice: (comma',' separated for multiple seats)");
		SeatChoice = seatChoice.next();
		//TODO: please do some input validation here I shall assume that input validation is done
		if (SeatChoice.length() < 2){
			this.ChooseASeat();
		}
	}
}
