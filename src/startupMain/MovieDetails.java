package startupMain;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Control class 
 * @author Low Zheng Han, Lou Sim Teng, MD Firdaus Bin Azizan, Hsieh Boh Yang, Martin Chin
 *
 */
public class MovieDetails extends SeatingPlan {

    HashMap<String, HashMap<String, ArrayList<String>>> MovieDetails = new HashMap<String, HashMap<String, ArrayList<String>>>();
    HashMap<String, String[][]> MovieSeats = new HashMap<String, String[][]>();

   public MovieDetails(){
       this.PutDataIntoMap();
   }

    private void SetSeatingPlan(String title){
        String[][] seats = super.plan;
        this.MovieSeats.put(title, seats);
    }

    private void DisplaySeatingPlan(String title){
        System.out.println("Choose a seat that's available (x means occupied): ");
        String[][] seats = this.MovieSeats.get(title);
        char c = 'A';
        System.out.println("  12 3456 78");
        for (int i = 0; i <10 ; i++) {
            System.out.print(Character.toString(c + i) + " ");
			for (int j = 0; j < 10; j ++) {
				System.out.print(seats[i][j]);
			}
            System.out.println();
		}
    }

    public void UpdateBookedSeats(String title, String SeatChoice){
        String[][] seats = this.MovieSeats.get(title);
        System.out.println("Booked seats: " + SeatChoice);
        if (SeatChoice.length() > 2){
			String[] chosenSeats = SeatChoice.split(",");
			for (String seat : chosenSeats){
				char strRow = seat.charAt(0);
				int row = strRow - 65;
				char seatNumStr = seat.charAt(1);
                int seatNum = Character.getNumericValue(seatNumStr);
				// cover the offset on display
                if (seatNum >= 7){
                    seatNum += 2;
                }
                else if (seatNum >= 3){
                    seatNum += 1;
                }
                seatNum -= 1;
                seats[row][seatNum] = "x";
                // replace old map
                this.MovieSeats.put(title, seats);
			}
		}
		else if (SeatChoice.length() == 2){
			char strRow = SeatChoice.charAt(0);
            int row = strRow - 65;
            char seatNumStr = SeatChoice.charAt(1);
            int seatNum = Character.getNumericValue(seatNumStr);
            // cover the offset on display
            if (seatNum >= 7){
                seatNum += 2;
            }
            else if (seatNum >= 3){
                seatNum += 1;
            }
            seatNum -= 1;
            seats[row][seatNum] = "x";
            // replace old map
            this.MovieSeats.put(title, seats);
		}
    }

    private HashMap<String, ArrayList<String>> getMovieDetails(String title){
        return this.MovieDetails.get(title);
    }

    public void DisplayMovieDetails(String title){
        for (Map.Entry<String, ArrayList<String>> entry : this.MovieDetails.get(title).entrySet()){
            String key = entry.getKey();
            String value = entry.getValue().get(0);
            System.out.println(key + ": " + value);
        }
        System.out.println();
        this.SetSeatingPlan(title);
        this.DisplaySeatingPlan(title);
    }

    // TODO read from saved movies and put into a HashMap like below function
    private void PutDataIntoMap(){
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList = ResourceManager.getmovieList(movieList);
        for (Movie m : movieList){
            //System.out.println(m.getTitle());
            try {
                    HashMap<String, ArrayList<String>> details = new HashMap<String, ArrayList<String>>();
                    ArrayList<String> status = new ArrayList<String>();
                    status.add(m.getShowingStatus());
                    details.put("Showing Status", status);
                    ArrayList<String> synopsis = new ArrayList<String>();
                    synopsis.add(m.getSynopsis());
                    details.put("Synopsis", synopsis);
                    ArrayList<String> director = new ArrayList<String>();
                    director.add(m.getDirector());
                    details.put("Director", director);
                    ArrayList<String> cast = new ArrayList<String>();
                    cast.add(m.getCast());
                    details.put("Cast", cast);
                    ArrayList<String> overallReview = new ArrayList<String>();
                    overallReview.add(m.getOverallReviewerRating());
                    details.put("Overall Review", overallReview);
                    // ArrayList<String> reviewsAndRatings = new ArrayList<String>();
                    // reviewsAndRatings.add(m.getReviewsAndRatings());
                    // details.put("Reviews and Ratings", reviewsAndRatings);
                    ArrayList<String> sales = new ArrayList<String>();
                    sales.add(m.getTicketSales());
                    details.put("Ticket Sales", sales);
                    this.MovieDetails.put(m.getTitle(), details);
                }
                catch (Exception err){
                    System.err.println(err);
                }
        }
    }

//    private void GetMovieDetailsFromFile(){
//        try {
//        	Path fileName = Path.of(".\\src\\Movies.txt");
//			ArrayList<String> movies = (ArrayList<String>) Files.readAllLines(fileName);
//			for (String line : movies){
//                String[] info = line.split("@");
//                HashMap<String, ArrayList<String>> details = new HashMap<String, ArrayList<String>>();
//                ArrayList<String> status = new ArrayList<String>();
//                status.add(info[1]);
//                details.put("Showing Status", status);
//                ArrayList<String> synopsis = new ArrayList<String>();
//                synopsis.add(info[2]);
//                details.put("Synopsis", synopsis);
//                ArrayList<String> director = new ArrayList<String>();
//                director.add(info[3]);
//                details.put("Director", director);
//                ArrayList<String> cast = new ArrayList<String>();
//                cast.add(info[4]);
//                details.put("Cast", cast);
//                ArrayList<String> overallReview = new ArrayList<String>();
//                overallReview.add(info[5]);
//                details.put("Overall Review", overallReview);
//                ArrayList<String> reviewsAdnRatings = new ArrayList<String>();
//                reviewsAdnRatings.add(info[6]);
//                details.put("Reviews and Ratings", reviewsAdnRatings);
//                ArrayList<String> sales = new ArrayList<String>();
//                sales.add(info[7]);
//                details.put("Ticket Sales", sales);
//                this.MovieDetails.put(info[0], details);
//            }
//		}
//		catch (Exception err){
//			System.err.println(err);
//		}
//    }
}
