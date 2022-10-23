package startupMain;

import java.io.IOException;
import java.util.Scanner;

public class Startup {
	
	private static int userType;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//Ask for user type
		while (true) {
			
			//Keep asking for input if invalid input is received
			while (true) {
				
				try {
					System.out.print("Hi, are you a staff or a customer? Enter 0 for staff and 1 for customer: ");
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
				Customer customer = new Customer();
				customer.showCustomerSystem();
			}
		}
	}
}
