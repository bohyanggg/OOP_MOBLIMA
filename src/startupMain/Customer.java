package startupMain;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalDateTime;

/**
 * Boundary class which calls on control classes and uses entity classes.
 * @author Low Zheng Han, Lou Sim Teng, MD Firdaus Bin Azizan, Hsieh Boh Yang, Martin Chin
 *
 */
public class Customer {
	//Movie details
	MovieDetails movieDetails;
	Scanner sc = new Scanner(System.in);

	public Customer(MovieDetails movieDetails){
		this.movieDetails = movieDetails;
	}
	//UI for the Customer menu
	public void showCustomerSystem() {

		while (true) {
			System.out.println("********** Customer Menu **********");
			System.out.println("0. Search movie");
			System.out.println("1. List movie");
			System.out.println("2. Check/Book seat availibility and selection of seat(s)");
			System.out.println("3. View booking history");
			System.out.println("4. List Top 5 ranking of movies by ratings");
			System.out.println("5. List Top 5 ranking of movies by tickets sold");
			System.out.println("6. Add review");
			System.out.println("7. Quit");
			System.out.print("Enter your choice: ");
			
			Scanner Choice = new Scanner(System.in);
			int userChoice = Choice.nextInt();
			if(userChoice == 7) {
				System.out.println("Logging Out...\n");
				break;
			}
			while(userChoice != 7) {
				
				//Choice 0	Search for Movies		
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
				
				//Choice 1	List movies			
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
					
					booking.CineplexChoiceDisplay(cineplex);
					booking.ChooseACineplex();
					String cineplexChoice = booking.getCineplexChoice();
					
					if (cineplexChoice == "Cathay Cineplexes Lot One") {
						ArrayList<String> cinemas = cineplex.GetCinemasOfCineplex(cineplexChoice);
						booking.CinemaChoiceDisplay(cineplex, cinemas);
						int chosenCinemaIndex = booking.ChooseACinema();
						if (booking.getCinemaChoice() == "Quit"){
							continue;
						}
						Cinema lotOne = new Cinema(booking.getCinemaChoice());
						ArrayList<Movie> movieList = new ArrayList<>();
						movieList = ResourceManager.getmovieList(movieList);
						booking.MovieChoiceDisplay(lotOne, movieList);
						int chosenMovieIndex = booking.ChooseAMovie();
						
						if (booking.getMovieChoice() == "Quit"){
							continue;
						}
						
						//IF NO CINEMA SHOWTIMES FOR CHOSEN CINEMA
						if (movieList.get(chosenMovieIndex).getCinemaShowtime()[chosenCinemaIndex].size() == 0) {
							System.out.println("No available cinema showtimes.");
							continue;
						}
						System.out.print("Available Cinema Showtimes: \n");
						for (int i=0; i<movieList.get(chosenMovieIndex).getCinemaShowtime()[chosenCinemaIndex].size(); i++) {
							System.out.println((i+1) + ". " + movieList.get(chosenMovieIndex).getCinemaShowtime()[chosenCinemaIndex].get(i));
						}
						System.out.print("Enter your choice: ");
						//FOR TICKET DATE TIME
						int chosenCinemaShowtimeIndex = sc.nextInt()-1;
						String chosenCinemaShowtime = movieList.get(chosenMovieIndex).getCinemaShowtime()[chosenCinemaIndex].get(chosenCinemaShowtimeIndex);
						
						String movieChoice = booking.getMovieChoice();
						System.out.println();
						movieDetails.DisplayMovieDetails(movieChoice);
						System.out.println();
						booking.ChooseASeat();
						movieDetails.UpdateBookedSeats(movieChoice, booking.getSeatChoice());
						
						//CREATE TICKET HERE, PASS IN THE DATE AND TIME
						Ticket ticket = new Ticket();
						ticket.createTicket(movieList.get(chosenMovieIndex), booking, chosenCinemaShowtime);
						
						//CONFIRM PURCHASE OF TICKET
						TicketPricing ticketPricing = new TicketPricing();
						System.out.println("Price of Ticket is: $" + String.format("%.2f", ticketPricing.calculateTicketPrice(ticket)));
						System.out.print("Proceed to payment? (Y/N)");
						sc.nextLine();
						String payOrNo = sc.nextLine();
						if (payOrNo.equalsIgnoreCase("Y")) {
							System.out.println("Payment Complete!");
						}
						else break;
						
						//ADD 1 TO MOVIE'S TOTAL TICKET SALES AND SAVE TO MOVIES.TXT
						movieList.get(chosenMovieIndex).addTicketSales();
						ResourceManager.addmovieList(movieList);
						
						//PRINT TIME OF PURCHASE
						//Calendar calendarInstance = Calendar.getInstance();
        				//System.out.println("Time of purchase:" + calendarInstance.getTime());
						
						//ADD TO BOOKING HISTORY (customerName, title, time of purchase)
						//Date date = Calendar.getInstance().getTime();
				        //DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						SimpleDateFormat transactionIDformat = new SimpleDateFormat("yyyyMMddHHmm");
						Date date = new Date();
						
						String transactionIDdate = transactionIDformat.format(date);
						String frmtdDate = dateFormat.format(date);
						
						String cinemaCode = "";
						if (chosenCinemaIndex == 0) cinemaCode = "CM1";
						else if (chosenCinemaIndex == 1) cinemaCode = "CM2";
						else if (chosenCinemaIndex == 2) cinemaCode = "CM3";
						
						System.out.println("Transaction ID: " + cinemaCode + transactionIDdate);
						System.out.println("Time of purchase: " + frmtdDate);
						System.out.println();
						
						BookingHistory bookingHistory = new BookingHistory();
						bookingHistory.addToBookingHistory(ticket.getCustomerName(), movieList.get(chosenMovieIndex).getTitle(), frmtdDate);
						break;
					}
					
					else if (cineplexChoice == "Cathay Cineplexes Clementi Mall") {
//						Cinema clementiMall = new Cinema(cineplexChoice);
//						clementiMall.Display();
						ArrayList<String> cinemas = cineplex.GetCinemasOfCineplex(cineplexChoice);
						booking.CinemaChoiceDisplay(cineplex, cinemas);
						int chosenCinemaIndex = booking.ChooseACinema();
						if (booking.getCinemaChoice() == "Quit"){
							continue;
						}
						Cinema clementiMall = new Cinema(booking.getCinemaChoice());
						ArrayList<Movie> movieList = new ArrayList<>();
						movieList = ResourceManager.getmovieList(movieList);
						booking.MovieChoiceDisplay(clementiMall, movieList);
						int chosenMovieIndex = booking.ChooseAMovie();
						
						if (booking.getMovieChoice() == "Quit"){
							continue;
						}
						
						//IF NO CINEMA SHOWTIMES FOR CHOSEN CINEMA
						if (movieList.get(chosenMovieIndex).getCinemaShowtime()[chosenCinemaIndex].size() == 0) {
							System.out.println("No available cinema showtimes.");
							continue;
						}
						System.out.print("Available Cinema Showtimes: ");
						for (int i=0; i<movieList.get(chosenMovieIndex).getCinemaShowtime()[chosenCinemaIndex].size(); i++) {
							System.out.println((i+1) + ". " + movieList.get(chosenMovieIndex).getCinemaShowtime()[chosenCinemaIndex].get(i));
						}
						System.out.print("Enter your choice: ");
						//FOR TICKET DATE TIME
						int chosenCinemaShowtimeIndex = sc.nextInt()-1;
						String chosenCinemaShowtime = movieList.get(chosenMovieIndex).getCinemaShowtime()[chosenCinemaIndex].get(chosenCinemaShowtimeIndex);
						
						String movieChoice = booking.getMovieChoice();
						System.out.println();
						movieDetails.DisplayMovieDetails(movieChoice);
						System.out.println();
						booking.ChooseASeat();
						movieDetails.UpdateBookedSeats(movieChoice, booking.getSeatChoice());
						
						//CREATE TICKET HERE, PASS IN THE DATE AND TIME
						Ticket ticket = new Ticket();
						ticket.createTicket(movieList.get(chosenMovieIndex), booking, chosenCinemaShowtime);
						
						//CONFIRM PURCHASE OF TICKET
						TicketPricing ticketPricing = new TicketPricing();
						System.out.println("Price of Ticket is: $" + String.format("%.2f", ticketPricing.calculateTicketPrice(ticket)));
						System.out.print("Proceed to payment? (Y/N)");
						sc.nextLine();
						String payOrNo = sc.nextLine();
						if (payOrNo.equalsIgnoreCase("Y")) {
							System.out.println("Payment Complete!");
						}
						else break;
						
						//ADD 1 TO MOVIE'S TOTAL TICKET SALES AND SAVE TO MOVIES.TXT
						movieList.get(chosenMovieIndex).addTicketSales();
						ResourceManager.addmovieList(movieList);
						
						//PRINT TIME OF PURCHASE
						//Calendar calendarInstance = Calendar.getInstance();
        				//System.out.println("Time of purchase:" + calendarInstance.getTime());
						
						//ADD TO BOOKING HISTORY (customerName, title, time of purchase)
						//Date date = Calendar.getInstance().getTime();
				        //DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						SimpleDateFormat transactionIDformat = new SimpleDateFormat("yyyyMMddHHmm");
						Date date = new Date();
						
						String transactionIDdate = transactionIDformat.format(date);
						String frmtdDate = dateFormat.format(date);
						
						String cinemaCode = "";
						if (chosenCinemaIndex == 0) cinemaCode = "CM1";
						else if (chosenCinemaIndex == 1) cinemaCode = "CM2";
						else if (chosenCinemaIndex == 2) cinemaCode = "CM3";
						
						System.out.println("Transaction ID: " + cinemaCode + transactionIDdate);
						System.out.println("Time of purchase: " + frmtdDate);
						System.out.println();
						
						BookingHistory bookingHistory = new BookingHistory();
						bookingHistory.addToBookingHistory(ticket.getCustomerName(), movieList.get(chosenMovieIndex).getTitle(), frmtdDate);
						break;
					}
					
					else if (cineplexChoice == "Cathay Cineplexes Jewel") {
//						Cinema jewel = new Cinema(cineplexChoice);
//						jewel.Display();
						ArrayList<String> cinemas = cineplex.GetCinemasOfCineplex(cineplexChoice);
						booking.CinemaChoiceDisplay(cineplex, cinemas);
						int chosenCinemaIndex = booking.ChooseACinema();
						if (booking.getCinemaChoice() == "Quit"){
							continue;
						}
						Cinema jewel = new Cinema(booking.getCinemaChoice());
						ArrayList<Movie> movieList = new ArrayList<>();
						movieList = ResourceManager.getmovieList(movieList);
						booking.MovieChoiceDisplay(jewel, movieList);
						int chosenMovieIndex = booking.ChooseAMovie();
						
						if (booking.getMovieChoice() == "Quit"){
							continue;
						}
						
						//IF NO CINEMA SHOWTIMES FOR CHOSEN CINEMA
						if (movieList.get(chosenMovieIndex).getCinemaShowtime()[chosenCinemaIndex].size() == 0) {
							System.out.println("No available cinema showtimes.");
							continue;
						}
						System.out.print("Available Cinema Showtimes: ");
						for (int i=0; i<movieList.get(chosenMovieIndex).getCinemaShowtime()[chosenCinemaIndex].size(); i++) {
							System.out.println((i+1) + ". " + movieList.get(chosenMovieIndex).getCinemaShowtime()[chosenCinemaIndex].get(i));
						}
						System.out.print("Enter your choice: ");
						//FOR TICKET DATE TIME
						int chosenCinemaShowtimeIndex = sc.nextInt()-1;
						String chosenCinemaShowtime = movieList.get(chosenMovieIndex).getCinemaShowtime()[chosenCinemaIndex].get(chosenCinemaShowtimeIndex);
						
						String movieChoice = booking.getMovieChoice();
						System.out.println();
						movieDetails.DisplayMovieDetails(movieChoice);
						System.out.println();
						booking.ChooseASeat();
						movieDetails.UpdateBookedSeats(movieChoice, booking.getSeatChoice());
						
						//CREATE TICKET HERE, PASS IN THE DATE AND TIME
						Ticket ticket = new Ticket();
						ticket.createTicket(movieList.get(chosenMovieIndex), booking, chosenCinemaShowtime);
						
						//CONFIRM PURCHASE OF TICKET
						TicketPricing ticketPricing = new TicketPricing();
						System.out.println("Price of Ticket is: $" + String.format("%.2f", ticketPricing.calculateTicketPrice(ticket)));
						System.out.print("Proceed to payment? (Y/N)");
						sc.nextLine();
						String payOrNo = sc.nextLine();
						if (payOrNo.equalsIgnoreCase("Y")) {
							System.out.println("Payment Complete!");
						}
						else break;
						
						//ADD 1 TO MOVIE'S TOTAL TICKET SALES AND SAVE TO MOVIES.TXT
						movieList.get(chosenMovieIndex).addTicketSales();
						ResourceManager.addmovieList(movieList);
						
						//PRINT TIME OF PURCHASE
						//Calendar calendarInstance = Calendar.getInstance();
        				//System.out.println("Time of purchase:" + calendarInstance.getTime());
						
						//ADD TO BOOKING HISTORY (customerName, title, time of purchase)
						//Date date = Calendar.getInstance().getTime();
				        //DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
						
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						SimpleDateFormat transactionIDformat = new SimpleDateFormat("yyyyMMddHHmm");
						Date date = new Date();
						
						String transactionIDdate = transactionIDformat.format(date);
						String frmtdDate = dateFormat.format(date);
						
						String cinemaCode = "";
						if (chosenCinemaIndex == 0) cinemaCode = "CM1";
						else if (chosenCinemaIndex == 1) cinemaCode = "CM2";
						else if (chosenCinemaIndex == 2) cinemaCode = "CM3";
						
						System.out.println("Transaction ID: " + cinemaCode + transactionIDdate);
						System.out.println("Time of purchase: " + frmtdDate);
						System.out.println();
						
						BookingHistory bookingHistory = new BookingHistory();
						bookingHistory.addToBookingHistory(ticket.getCustomerName(), movieList.get(chosenMovieIndex).getTitle(), frmtdDate);
						break;
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
				
				//Choice 3	Booking History		
				if (userChoice == 3) {
					BookingHistory bookingHistory = new BookingHistory();
					System.out.print("\nEnter your name: ");
					bookingHistory.printCustomerSpecificBookingHistory(sc.nextLine());
					break;
				}
				
				//Choice 4	Top 5 by Ratings			
				if (userChoice == 4) {
					ArrayList<Movie> movieList = new ArrayList<>();
					movieList = ResourceManager.getmovieList(movieList);
					System.out.println("Top 5 Movies based on Review Ratings (lowest to highest)");
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
				
				//Choice 5 Top 5 by Ticket Sales			
				if (userChoice == 5) {
					ArrayList<Movie> movieList = new ArrayList<>();
					movieList = ResourceManager.getmovieList(movieList);
					System.out.println("Top 5 Movies based on Ticket Sales (lowest to highest)");
                    HashMap<String, Integer> reviewRatingTable = new HashMap<String, Integer>();                    
                    for(Movie movieInList : movieList){
                        reviewRatingTable.put(movieInList.getTitle(), Integer.parseInt(movieInList.getTicketSales()));
                    }
                    List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(reviewRatingTable.entrySet());
                    Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
                        public int compare(Map.Entry<String, Integer> o1,
                                           Map.Entry<String, Integer> o2)
                        {
                            return (o2.getValue()).compareTo(o1.getValue());
                        }
                    });
                    HashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
                    for (Map.Entry<String, Integer> aa : list) {
                        sortedMap.put(aa.getKey(), aa.getValue());
                    }
                    int count = 0;
                    Iterator<String> itr = sortedMap.keySet().iterator();
                    while (itr.hasNext() && count < 6) {
                        String key = itr.next();
                        System.out.println((count+1) +". "+ key +": " + sortedMap.get(key));
                        count++;
                    }
                    break;
				}
				if (userChoice ==6)
				{
					System.out.println("List of Movies");
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
					System.out.println("\nChoose a movie to review ");
					Scanner sc = new Scanner(System.in);
					int choice = sc.nextInt();
					Movie chosenMovie = movieList.get(choice - 1);
					chosenMovie.addReviewsAndRatings();
					ResourceManager.addmovieList(movieList);
					break;
				}
			}
		}
	}
}