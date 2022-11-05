package startupMain;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MovieDetails {

    HashMap<String, HashMap<String, ArrayList<String>>> MovieDetails = new HashMap<String, HashMap<String, ArrayList<String>>>();

    public MovieDetails(){
        this.GetMovieDetailsFromFile();
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
    }

    private void GetMovieDetailsFromFile(){
        try {
			Path fileName = Path.of(".\\src\\Movies.txt");
			ArrayList<String> movies = (ArrayList<String>) Files.readAllLines(fileName);
			for (String line : movies){
                String[] info = line.split("@");
                HashMap<String, ArrayList<String>> details = new HashMap<String, ArrayList<String>>();
                ArrayList<String> status = new ArrayList<String>();
                status.add(info[1]);
                details.put("Showing Status", status);
                ArrayList<String> synopsis = new ArrayList<String>();
                synopsis.add(info[2]);
                details.put("Synopsis", synopsis);
                ArrayList<String> director = new ArrayList<String>();
                director.add(info[3]);
                details.put("Director", director);
                ArrayList<String> cast = new ArrayList<String>();
                cast.add(info[4]);
                details.put("Cast", cast);
                ArrayList<String> overallReview = new ArrayList<String>();
                overallReview.add(info[5]);
                details.put("Overall Review", overallReview);
                ArrayList<String> reviewsAdnRatings = new ArrayList<String>();
                reviewsAdnRatings.add(info[6]);
                details.put("Reviews and Ratings", reviewsAdnRatings);
                ArrayList<String> sales = new ArrayList<String>();
                sales.add(info[7]);
                details.put("Ticket Sales", sales);
                this.MovieDetails.put(info[0], details);
            }
		}
		catch (Exception err){
			System.err.println(err);
		}
    }
}
