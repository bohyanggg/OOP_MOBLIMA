package idkpackage;

import java.io.IOException;
import java.util.Scanner;

public class StaffLogin {
	
	public StaffLogin() {
		
	}
	
	public boolean Login() {
		
		Scanner sc = new Scanner(System.in);
		
		int loginAttempts = 0;
		
		while (loginAttempts < 3) {
			
			try {
				System.out.print("Username: ");
				String username = sc.nextLine();
				
				System.out.print("Password: ");
				String password = sc.nextLine();
				
				StaffAuthenticator staffAuthenticator = new StaffAuthenticator(username, password);
				//if not authenticated, throw exception
				if (staffAuthenticator.verify() == false) {
					throw new IOException();
					//break out of while loop and return false
				}
				return true;
				
			} catch (IOException e) {
				System.out.println("Incorrect username or password.");
				
			} finally {
				loginAttempts += 1;
			}
		}
		
		return false;
	}
}
