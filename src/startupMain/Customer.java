package startupMain;

import java.io.*;
import java.util.*;


public class Customer {

	MovieDetails movieDetails;

	public Customer(MovieDetails movieDetails){
		this.movieDetails = movieDetails;
	}

	public void showCustomerSystem() {

		while (true) {
			System.out.println("********** Customer Menu **********");
			System.out.println("0. Search movie");
			System.out.println("1. List movie");
			System.out.println("2. Check/Book seat availibility and selection of seat(s)");
			System.out.println("3. View booking history");
			System.out.println("4. List Top 5 ranking of movies by ratings");
			System.out.println("5. List Top 5 ranking of movies by tickets sold");
			System.out.println("6. Quit");
			System.out.print("Enter your choice: ");
			
			Scanner Choice = new Scanner(System.in);
			int userChoice = Choice.nextInt();
			while(userChoice != 6) {
				if (userChoice ==0) {
					
					ArrayList<Movie> movieList = new ArrayList<>(); //Create arraylist to store movie objects from txt
					movieList = ResourceManager.getmovieList(movieList);
					if (movieList.size() == 0) {
                        System.out.println("Sorry there are currently no movies!");
                        break;
                    }
					
                    // Getting the keyword from the user to be searched
                    System.out.printf("Please enter the keyword to be searched: ");
                    Choice.nextLine();        // To remove the carriage return character
                    String keyWord = Choice.nextLine();
                    
                    System.out.println("Displaying the list of movies with keyword \"" + keyWord + "\"...");
                    System.out.println("=====================================");
                    System.out.println("MOVIE ID\t\tMOVIE TITLE");
                    System.out.println("=====================================");

                    // Searching through the listOfMovies for titles have contain the keyword, then displaying it
                    boolean foundMovieID1 = false;
                    for (int i = 0; i < movieList.size(); i++) {
                        if (movieList.get(i).getTitle().toLowerCase().contains(keyWord.toLowerCase())) {
                            System.out.println(i + 1 + ".\t\t\t" + movieList.get(i).getTitle());
                            foundMovieID1 = true;
                            continue;
                            
                        }
                    
                    }
                    if (!foundMovieID1) {
                        System.out.println("Sorry there are currently no movies that match " + keyWord + "!");
                        break;
                    }
                    
                    break;
                    // If cannot find any movies that contain the keyword
                    
				}
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
				//movie.addTicketSales(); add this in user choice 2 at the end to +1 for movie ticket sales after booking
				if (userChoice == 2) {
					Movie movie = new Movie();
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
					ArrayList<Movie> movieList = new ArrayList<>();
					movieList = ResourceManager.getmovieList(movieList);
					System.out.println("Top 5 Movies based on Review Ratings(lowest to highest)");
                    HashMap<String, String> reviewRatingTable = new HashMap<String, String>();                    
                    for(Movie movieInList : movieList){
                        reviewRatingTable.put(movieInList.getTitle(), movieInList.getOverallReviewerRating());
                    }
                    List<Map.Entry<String, String> > list = new LinkedList<Map.Entry<String, String> >(reviewRatingTable.entrySet());
                    Collections.sort(list, new Comparator<Map.Entry<String, String> >() {
                        public int compare(Map.Entry<String, String> o1,
                                           Map.Entry<String, String> o2)
                        {
                            return (o1.getValue()).compareTo(o2.getValue());
                        }
                    });
                    HashMap<String, String> sortedMap = new LinkedHashMap<String, String>();
                    for (Map.Entry<String, String> aa : list) {
                        sortedMap.put(aa.getKey(), aa.getValue());
                    }
                    int count = 1;
                    Iterator<String> itr = sortedMap.keySet().iterator();
                    while (itr.hasNext() && count < 6) {
                        String key = itr.next();
                        System.out.println(count +". "+ key +": " + sortedMap.get(key));
                        count++;
                    }
                    break;
				}
				if (userChoice == 5) {
					ArrayList<Movie> movieList = new ArrayList<>();
					movieList = ResourceManager.getmovieList(movieList);
					System.out.println("Top 5 Movies based on Review Ratings(lowest to highest)");
                    HashMap<String, Integer> reviewRatingTable = new HashMap<String, Integer>();                    
                    for(Movie movieInList : movieList){
                        reviewRatingTable.put(movieInList.getTitle(), movieInList.getTicketSales());
                    }
                    List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(reviewRatingTable.entrySet());
                    Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
                        public int compare(Map.Entry<String, Integer> o1,
                                           Map.Entry<String, Integer> o2)
                        {
                            return (o1.getValue()).compareTo(o2.getValue());
                        }
                    });
                    HashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
                    for (Map.Entry<String, Integer> aa : list) {
                        sortedMap.put(aa.getKey(), aa.getValue());
                    }
                    int count = 1;
                    Iterator<String> itr = sortedMap.keySet().iterator();
                    while (itr.hasNext() && count < 6) {
                        String key = itr.next();
                        System.out.println(count +". "+ key +": " + sortedMap.get(key));
                        count++;
                    }
                    break;
				}
			}
		}
	}
}