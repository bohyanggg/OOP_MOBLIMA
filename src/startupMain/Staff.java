package startupMain;

import java.util.Scanner;

import idkpackage.StaffLogin;

public class Staff {
	
	public void authenticateStaff() {
		StaffLogin staffLogin = new StaffLogin();
		boolean isAuth = staffLogin.Login();
		if (isAuth == false) {
			return;
		}
	}
	
	public void showStaffSystem() {
		Scanner sc = new Scanner(System.in);
//		System.out.println("***** Staff Interface *****\n"
//						 + "1. Create/Update/Remove Movie Listing\n"
//						 + "2. Create/Update/Remove Cinema Showtimes\n"
//						 + "3. Configure System Settings");
		
		System.out.println("***** Staff Interface *****\n"
						 + "1. Create/Update/Remove Movie Listing\n"
						 + "2. Create/Update/Remove Cinema Showtimes\n"
						 + "3. Configure System Settings");
		
		switch(sc.nextInt()) {
			case 1: 
		}
	}
	
}
