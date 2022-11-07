package startupMain;

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
							 + "4. Logout\n");
			
			choice = sc.nextInt();
				
			switch(choice) {
			
				case 1: MovieListingConfig mlConfig = new MovieListingConfig();
						mlConfig.mlConfigOptions();
						break;

						// TODO UNFINISHED
				case 2: CinemaShowtimesConfig csConfig = new CinemaShowtimesConfig();
						csConfig.csConfigOptions();
						break;

//						// TODO UNFINISHED
//				case 3: SystemSettingsConfig ssConfig = new SystemSettingsConfig();
//						ssConfig.ssConfigOptions();
//						break;
						
						// TODO UNFINISHED
//				case 4: list top 5 ranking movies by ticket sales/overall reviewer rating(display title and overall rating)

				case 5: System.out.println("\nLogging Out...\n");
						return;
				
				default: System.out.println("\nInvalid Option.\n");
			}
		}
	}
}
