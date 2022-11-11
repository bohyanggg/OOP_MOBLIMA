package startupMain;

import java.util.ArrayList;
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
					 + "4. View Movie Listing\n"
					 + "5. Return to Staff Menu\n");
			
			choice = sc.nextInt();
			
			switch (choice) {
				case 1: createMovieListing();
						break;
				case 2: updateMovieListing();
						break;
				case 3: removeMovieListing();
						break;
				case 4: viewMovieListing();
						break;
				case 5: System.out.println("\nReturning to Staff Menu...\n");
						return;
				default: System.out.println("\nInvalid Option.\n");
			}
		}
	}
	
	
	public void createMovieListing() {
		Movie newMovie = new Movie();
		newMovie.createMovie(); //To ask input for the movie details
		ArrayList<Movie> movieList = new ArrayList<>(); //Create arraylist to store movie objects from txt
		movieList = ResourceManager.getmovieList(movieList); //to take objects from txt and store into movieList array
		movieList.add(newMovie); //add the new movie object into the arraylist from txt file
		ResourceManager.addmovieList(movieList); //add the movie arraylist back into txt file
		newMovie.viewallMovieDetails(); //to show the newly added movie details
	}
	
	
	public void updateMovieListing() {
		ArrayList<Movie> movieList = new ArrayList<>(); //Create arraylist to store movie objects from txt
		movieList = ResourceManager.getmovieList(movieList); //to take objects from txt and store into movieList array
		int i = 1; //To number the movies
		System.out.print("\n");
		for (Movie movie: movieList) //To iterate through the movieListArray from the txt file
		{
			System.out.print("Movie " + i + ": ");
			i++;
			movie.viewimportantMovieDetails(); //To show only the important details of the file 
			System.out.print("\n");
		}
		int totalMovie = i -1; //To count the total number of movie objects in the txt file
		i = 1;
		System.out.println("\nView all details of a Movie that you wish to update? (Y/N)");
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
					System.out.println("\nDo you wish to update the Movie details?(Y/N)");
					choice = sc.next();
					if (choice.equalsIgnoreCase("Y"))
					{
						System.out.println("\nSelect an option:\n"
								 + "1. Update Movie Title\n"
								 + "2. Update Movie Type\n"
								 + "3. Update Cinema Showtime\n"
								 + "4. Update Showing Status\n"
								 + "5. Update Sypnosis\n"
								 + "6. Update Director\n"
								 + "7. Update Cast\n"
								 + "8. Return\n");
						int selection = sc.nextInt();
						
						switch (selection) {
						case 1: movie.setTitle();
								ResourceManager.addmovieList(movieList); //add the movie arraylist back into txt file
								break;
						case 2: movie.setType();
								ResourceManager.addmovieList(movieList); //add the movie arraylist back into txt file
								break;
						case 3: movie.setCinemaShowtime();
								ResourceManager.addmovieList(movieList); //add the movie arraylist back into txt file
								break;
						case 4: movie.setShowingStatus();
								ResourceManager.addmovieList(movieList); //add the movie arraylist back into txt file
								break;
						case 5: movie.setSynopsis();
								ResourceManager.addmovieList(movieList); //add the movie arraylist back into txt file
								break;
						case 6: movie.setDirector();
								ResourceManager.addmovieList(movieList); //add the movie arraylist back into txt file
								break;
						case 7: movie.setCast();
								ResourceManager.addmovieList(movieList); //add the movie arraylist back into txt file
								break; 
						case 8: System.out.println("\nReturning to Create/Update/Remove Movie Listing...\n");
								return;
						default: System.out.println("\nInvalid Option.\n");
					}
						
					}
					else if (choice.equalsIgnoreCase("N"))
					{
						return;
					}
					else
					{
						System.out.println("\nInvalid Input!");
						return;
					}
					break;
				}
				i++;
			}
		}
		else if (choice.equalsIgnoreCase("N"))
		{
			return;
		}
		else
		{
			System.out.println("\nInvalid Input!");
			return;
		}
	}
	
	public void removeMovieListing()
	{
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
		int totalMovie = i-1;
		i = 1;
		System.out.println("\nRemove a Movie? (Y/N)");
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
			movieList.remove(movieNumber-1); //To remove the desired movie object;
			ResourceManager.addmovieList(movieList); //add the movie arraylist back into txt file
			System.out.println("Updated Movie List: ");
			for (Movie movie: movieList)
			{
				System.out.print("Movie " + i + ": ");
				i++;
				movie.viewimportantMovieDetails();
				System.out.print("\n");
			}
		}
	}
	
	public void viewMovieListing()
	{
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
					break;
				}
				i++;
			}
		}
		else if (choice.equalsIgnoreCase("N"))
		{
			return;
		}
		else
		{
			System.out.println("\nInvalid Input!");
			return;
		}
	}
}