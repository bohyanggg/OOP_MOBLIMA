package startupMain;

import java.util.Scanner;

public class MovieListingConfig {

	private Scanner sc = new Scanner(System.in);
	
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

		//add newMovie to movie list
	}
}
