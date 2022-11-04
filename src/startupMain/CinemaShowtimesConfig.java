package startupMain;

import java.util.Scanner;

public class CinemaShowtimesConfig {

//		Create/Update/Remove cinema showtimes and the movies to be shown
//		Configuring “End of Showing” date and the movie should not be listed for 
//		booking

	private static Scanner sc = new Scanner(System.in);
	
	private int choice;
	
	public void csConfigOptions() {
		
		while (true) {
			System.out.println("\nSelect an option:\n"
					 + "1. Create a Cinema Showing\n"
					 + "2. Update Cinema Showtimes\n"
					 + "3. View all Cinema Showings\n"
					 + "4. Return to Staff Menu\n");
			
			choice = sc.nextInt();
			
			switch (choice) {
				case 1: createCinemaShowing();
						break;
				case 2: updateCinemaShowtime();
						break;
				case 3: viewCinemaShowing();
						break;
				case 4: System.out.println("\nReturning to Staff Menu...\n");
						return;
				default: System.out.println("\nInvalid Option.\n");
			}
		}
	}

	private void createCinemaShowing() {
		// TODO Append to corresponding cinema
		
	}

	private void updateCinemaShowtime() {
		// TODO Read from Cinemas.txt and update
		
	}

	private void viewCinemaShowing() {
		// TODO Read from Cinemas.txt
		
	}

}
