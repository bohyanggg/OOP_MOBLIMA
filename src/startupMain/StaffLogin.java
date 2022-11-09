package startupMain;

import java.io.IOException;
import java.util.Scanner;

public class StaffLogin {
	
	public boolean login() {
		
		Scanner sc = new Scanner(System.in);
		int loginAttempts = 0;
		
		System.out.println();
		while (loginAttempts < 3) {
			
			try {
				System.out.print("Username: ");
				String username = sc.nextLine();
				System.out.print("Password: ");
				String password = sc.nextLine();
				
				//if not authenticated, throw exception
				if (verify(username, password) == false) {
					throw new IOException();
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
	
	public boolean verify(String username, String password) {
		
		//if username and password are correct
		if (username.equals("staff") && password.equals("admin")) return true;
		
		//if either username or password is wrong
		return false;
	}
}
