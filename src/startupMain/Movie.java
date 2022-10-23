package startupMain;

public class Movie {

	private String title;
	private String showingStatus;
	private String synopsis;
	private String director;
	private String[] cast;
	private double overallReviewerRating;
	//private smth collectionOfReviewsAndRatings
	//add collection of past reviews and ratings

	public Movie(String title, String synopsis, String director, String[] cast) {
		this.title = title;
		showingStatus = "Coming Soon";
		this.synopsis = synopsis;
		this.director = director;
		this.cast = cast;
		overallReviewerRating = 0;
		//add collection of past reviews and ratings
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShowingStatus() {
		return showingStatus;
	}

	public void setShowingStatus(String showingStatus) {
		this.showingStatus = showingStatus;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String[] getCast() {
		return cast;
	}

	public void setCast(String[] cast) {
		this.cast = cast;
	}

	public double getOverallReviewerRating() {
		return overallReviewerRating;
	}

	//CALCULATE USING AVERAGE OF ALL PAST RATINGS
//	public void setOverallReviewerRating(double overallReviewerRating) {
//		this.overallReviewerRating = overallReviewerRating;
//	}
}
