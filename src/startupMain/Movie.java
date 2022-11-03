package startupMain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Movie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4611176189600089207L;

	private static Scanner sc = new Scanner(System.in);
	
	private String title;
	private int showingStatus;
	private String synopsis;
	private String director;
	private ArrayList<String> cast = new ArrayList<String>();
	private String overallReviewerRating; //1 to 5
	private ArrayList<String[]> reviewsAndRatings = new ArrayList<String[]>(); //stored as (String review, double rating) as one array element
	private int ticketSales;

//	public Movie() {
//		title = "";
//		showingStatus = 0; // 0 = Coming Soon
//		synopsis = "";
//		director = "";
//		cast = [];
//		overallReviewerRating = "0";
//		ticketSales = 0;
//	}
	
	//Collection of all getter methods to display movie attributes
	public void viewallMovieDetails() {
		System.out.println("\nMovie Title: " + this.getTitle());
		System.out.println("Showing Status: " + this.getShowingStatus());
		System.out.println("Movie Synopsis: " + this.getSynopsis());
		System.out.println("Movie Director: " + this.getDirector());
		System.out.println("Movie Casts: " + this.getCast());
		System.out.println("Movie Overall Rating: " + this.getOverallReviewerRating());
		getReviewsAndRatings();
		System.out.println("Ticket Sales: " + this.getTicketSales());
	}
	
	public void viewimportantMovieDetails()
	{
		System.out.print("Title: " + this.getTitle() + " | Showing Status: " + this.getShowingStatus() + 
				" | Movie Overall Rating: " + this.getOverallReviewerRating() + " | Ticket Sales: " + this.getTicketSales());
	}
	
	//Collection of all setter methods to create movie except overallReviewerRating and ticketSales
	public void createMovie() {
		setTitle();
		setShowingStatus();
		setSynopsis();
		setDirector();
		setCast();
		setOverallReviewerRating();
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle() {
		System.out.print("\nEnter Movie Title: ");
		title = sc.nextLine();
		System.out.println(title);
	}

	public String getShowingStatus() {
		switch(showingStatus) 
		{
			case 1: return "Coming Soon";
			case 2: return "Preview";
			case 3: return "Now Showing";
			case 4: return "End of Showing";
		}
		return "test";
	}

	//4 OPTIONS TO CHOOSE (0=Coming Soon, 1=Preview, 2=Now Showing, 3=End of Showing)
	public void setShowingStatus() {
		System.out.println("\nEnter Showing Status:\n"
						  + "1: Coming Soon\n"
						  + "2: Preview\n"
						  + "3: Now Showing\n"
						  + "4: End of Showing\n");
		showingStatus = sc.nextInt();
		sc.nextLine(); //to fix nextLine() issue
		System.out.println(showingStatus);
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis() {
		System.out.print("\nEnter Synopsis: ");
		synopsis = sc.nextLine();
		System.out.println(synopsis);
	}

	public String getDirector() {
		return director;
	}

	public void setDirector() {
		System.out.print("\nEnter Director: ");
		director = sc.nextLine();
		System.out.println(director);
	}

	public String getCast() {
		//System.out.print("Cast: ");
		String stringCast = "";
		for (int i=0; i<cast.size()-1; i++) {
			stringCast += cast.get(i) + ", ";
		}
		//Print last cast member without comma afterwards
		stringCast += cast.get(cast.size()-1);
		return stringCast;
	}

	public void setCast() {
		cast.clear(); //empty the entire cast arrayList
		System.out.print("\nEnter No. of Cast Members (at least 2): ");
		int numCast = sc.nextInt();
		sc.nextLine(); //to fix nextLine() issue
		for (int i=1; i<=numCast; i++) {
			System.out.print("Enter Cast Member " + i + ": ");
			cast.add(sc.nextLine());
		}
		System.out.println(cast);
	}

	public String getOverallReviewerRating() {
		return overallReviewerRating;
	}

	public void setOverallReviewerRating() {
		//"NA" if no existing ratings
		if (reviewsAndRatings.size() == 0) overallReviewerRating = "NA";

		else {
			//calculate average of all ratings stored in reviewsAndRatings arrayList
			double averageRating = 0;
			for (int i=0; i<reviewsAndRatings.size(); i++) {
				//convert rating from String to int and sum them
				averageRating += Integer.parseInt(reviewsAndRatings.get(i)[0]);
			}
			//divide the sum of all ratings by number of ratings to get average
			averageRating /= reviewsAndRatings.size();
			//round off to 1 d.p. then convert from double to string
			overallReviewerRating = Double.toString(Math.round(averageRating*100) / 100);
	
		}
	}
	
	public void getReviewsAndRatings() {
		System.out.print("Reviews and Ratings: ");
		if (reviewsAndRatings.size() == 0) {
			System.out.println("0");
		}
		else {
			for (int i=0; i<reviewsAndRatings.size(); i++) {
				System.out.println(reviewsAndRatings.get(i)[0]); //rating
				System.out.println(reviewsAndRatings.get(i)[1]); //review
			}
		}
	}

	//Store rating as string and convert to int later to calculate overallReviewerRating
	public void addReviewsAndRatings() {
		System.out.print("\nEnter Rating: ");
		String newRating = sc.nextLine();
		System.out.print("\nEnter Review: ");
		String newReview = sc.nextLine();
		String[] newReviewAndRating = new String[]{newRating, newReview};
		reviewsAndRatings.add(newReviewAndRating);
		System.out.println("\nRating and Review Added!\n");
	}

	public int getTicketSales() {
		return ticketSales;
	}

	public void addTicketSales() {
		ticketSales += 1;
	}

	@Override
	//Testing for Serialization
	public String toString() {
		return "Movie [title=" + title + ", showingStatus=" + showingStatus + ", synopsis=" + synopsis + ", director="
				+ director + ", cast=" + cast + ", overallReviewerRating=" + overallReviewerRating
				+ ", reviewsAndRatings=" + reviewsAndRatings + ", ticketSales=" + ticketSales + "]";
	}
	
	
}