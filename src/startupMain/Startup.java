package startupMain;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Startup {
	
	private static Scanner sc = new Scanner(System.in);
	
	private static int userType;
	
	public static void main(String[] args) {
		// load movie details
		MovieDetails movieDetails = new MovieDetails();
		//Ask for user type
		while (true) {
			
			//Keep asking for input if invalid input is received
			while (true) {
				
				try {
					System.out.println("|===============Main Menu===============|\n" +
									   "    Hi, are you a staff or a customer?\n" +
								   	   "          Enter 0 for Staff\n" +
								   	   "         Enter 1 for Customer\n" +
								   	   "|=======================================|\n");
					userType = sc.nextInt();
					
					//If input is not 0 or 1, throw new exception
					if (userType!=0 && userType!=1) {
						throw new IOException();
					}
					//If input is 0 or 1, break from while loop
					break;
					
				} catch (IOException e) {
					//Catch exception if input not 0 or 1
					System.out.println("Invalid Option.\n");
				}
			}
			
			//If user is a staff
			if (userType==0) {
				//Create new staff object
				Staff staff = new Staff();
				staff.showStaffSystem();
			}
			
			//If user is a customer
			else {
				//Create new customer object
				Customer customer = new Customer(movieDetails);
				customer.showCustomerSystem();
			}
		}
	}
}
