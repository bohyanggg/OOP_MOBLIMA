package startupMain;

import java.util.ArrayList;
import java.util.Scanner;

public class Movie {

	private Scanner sc = new Scanner(System.in);
	
	private String title;
	private int showingStatus;
	private String synopsis;
	private String director;
	private ArrayList<String> cast;
	private double overallReviewerRating; //1 to 5
	private String[] reviewsAndRatings = new String[10]; //stored as (String review, double rating) as one array element
	private int ticketSales;
	
//	public Movie() {
//		title = "";
//		showingStatus = 0; // 0 = Coming Soon
//		synopsis = "";
//		director = "";
//		cast = [];
//		overallReviewerRating = 0;
//		ticketSales = 0;
//	}

	//Collection of all setter methods to create movie except overallReviewerRating and ticketSales
	public void createMovie() {
		setTitle();
		setShowingStatus();
		setSynopsis();
		setDirector();
		setCast();
		addReviewsAndRatings(); //UNFINISHED
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle() {
		System.out.print("Enter Movie Title: ");
		String newTitle = sc.nextLine();
		title = newTitle;
	}

	public String getShowingStatus() {
		switch(showingStatus) {
			case 0: return "Coming Soon";
			case 1: return "Preview";
			case 2: return "Now Showing";
			case 3: return "End of Showing";
		}
		//Should not get error
		return "Error";
	}

	//ADD 4 OPTIONS TO CHOOSE (0=Coming Soon, 1=Preview, 2=Now Showing, 3=End of Showing)
	public void setShowingStatus() {
		System.out.println("Enter Showing Status:\n"
						  + "0: Coming Soon\n"
						  + "1: Preview\n"
						  + "2: Now Showing\n"
						  + "3: End of Showing\n");
		int newShowingStatus = sc.nextInt();
		showingStatus = newShowingStatus;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis() {
		System.out.print("Enter Synopsis: ");
		String newSynopsis = sc.nextLine();
		synopsis = newSynopsis;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector() {
		System.out.print("Enter Director: ");
		String newDirector = sc.nextLine();
		director = newDirector;
	}

	public ArrayList<String> getCast() {
		for (int i=0; i<cast.size(); i++) {
			System.out.println(cast.get(i));
		}
		return cast;
	}

	public void setCast() {
		System.out.print("Enter No. of Cast Members: "); //at least 2
		int numCast = sc.nextInt();
		for (int i=0; i<numCast; i++) {
			System.out.print("Enter Cast Member " + i + " : ");
			cast.add(sc.nextLine());
		}
//		cast = newCast; //??????????????????????????????????????????????
	}

	//DISPLAY "NA" IF NO RATINGS
	public double getOverallReviewerRating() {
		return overallReviewerRating;
	}

	//CALCULATE USING AVERAGE OF ALL PAST RATINGS
	public void setOverallReviewerRating(double overallReviewerRating) {
		this.overallReviewerRating = overallReviewerRating;
	}

	public String[] getReviewsAndRatings() {
		return reviewsAndRatings;
	}

	public void addReviewsAndRatings() {
		String newReview = sc.nextLine();
		int newRating = sc.nextInt();
		
		//reviewsAndRatings = reviewsAndRatings;
	}

	public int getTicketSales() {
		return ticketSales;
	}

	public void addTicketSales() {
		ticketSales += 1;
	}
}

//FOR GET METHODS, SHOULD RETURN? OR JUST PRINT AND DON'T RETURN?
