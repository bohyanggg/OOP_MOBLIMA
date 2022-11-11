package startupMain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Staff {

	private static Scanner sc = new Scanner(System.in);
	
	private int choice;
	
	public void showStaffSystem() {
		StaffLogin staffLogin = new StaffLogin();
		boolean isAuth = staffLogin.login();
		if (isAuth == false) return;
		
		while (true) {
			System.out.println("\n********** Staff Menu **********\n"
							 + "1. Create/Update/Remove Movie Listing\n"
							 + "2. Create/Update/Remove Cinema Showtimes\n"
							 + "3. Configure System Settings\n"
							 + "4. List Top 5 ranking of movies by ratings\n"
							 + "5. List Top 5 ranking of movies by tickets sold\n"
							 + "6. Logout\n");
			
			choice = sc.nextInt();
				
			switch(choice) {
			
				case 1: MovieListingConfig mlConfig = new MovieListingConfig();
						mlConfig.mlConfigOptions();
						break;

				case 2: CinemaShowtimesConfig csConfig = new CinemaShowtimesConfig();
						csConfig.csConfigOptions();
						break;

				case 3: SystemSettingsConfig ssConfig = new SystemSettingsConfig();
						ssConfig.ssConfigOptions();
						break;

				case 4: ArrayList<Movie> movieList = new ArrayList<>();
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

				case 5: ArrayList<Movie> movieList2 = new ArrayList<>();
						movieList2 = ResourceManager.getmovieList(movieList2);
						System.out.println("Top 5 Movies based on Ticket Sales (lowest to highest)");
	                    HashMap<String, Integer> reviewRatingTable2 = new HashMap<String, Integer>();                    
	                    for(Movie movieInList2 : movieList2){
	                        reviewRatingTable2.put(movieInList2.getTitle(), Integer.parseInt(movieInList2.getTicketSales()));
	                    }
	                    List<Map.Entry<String, Integer> > list2 = new LinkedList<Map.Entry<String, Integer> >(reviewRatingTable2.entrySet());
	                    Collections.sort(list2, new Comparator<Map.Entry<String, Integer> >() {
	                        public int compare(Map.Entry<String, Integer> o1,
	                                           Map.Entry<String, Integer> o2)
	                        {
	                            return (o1.getValue()).compareTo(o2.getValue());
	                        }
	                    });
	                    HashMap<String, Integer> sortedMap2 = new LinkedHashMap<String, Integer>();
	                    for (Map.Entry<String, Integer> aa2 : list2) {
	                        sortedMap2.put(aa2.getKey(), aa2.getValue());
	                    }
	                    int count2 = 1;
	                    Iterator<String> itr2 = sortedMap2.keySet().iterator();
	                    while (itr2.hasNext() && count2 < 6) {
	                        String key2 = itr2.next();
	                        System.out.println(count2 +". "+ key2 +": " + sortedMap2.get(key2));
	                        count2++;
	                    }
	                    break;

				case 6: System.out.println("\nLogging Out...\n");
						return;
				
				default: System.out.println("\nInvalid Option.\n");
			}
		}
	}
}
