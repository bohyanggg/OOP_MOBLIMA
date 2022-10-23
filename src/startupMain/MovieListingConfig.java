package startupMain;

import java.util.Scanner;

public class MovieListingConfig extends MovieListingDisplay {

	private int choice;
	
	public void mlConfigOptions() {
		
		while (true) {
			System.out.println("\nSelect an option:\n"
					 + "1. Create Movie Listing\n"
					 + "2. Update Movie Listing\n"
					 + "3. Remove Movie Listing\n"
					 + "4. Return to Staff Menu\n");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			
			switch (choice) {
//				case 1: createMovieListing();
//						break;
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
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Movie Title: ");
		String title = sc.nextLine();
		System.out.print("Enter Synopsis: ");
		String synopsis = sc.nextLine();
		System.out.print("Enter Director: ");
		String director = sc.nextLine();
		System.out.print("Enter No. of Cast Members: "); //at least 2
		int numCast = sc.nextInt();
		String[] cast = new String[numCast];
		for (int i=0; i<numCast; i++) {
			System.out.print("Enter Cast Member " + i + " : ");
			cast[i] = sc.nextLine();
		}
		Movie newMovie = new Movie(title, synopsis, director, cast);
		//add newMovie to movie list
	}
}
