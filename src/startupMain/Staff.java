package startupMain;

import java.util.Scanner;

public class Staff {

	public void showStaffSystem() {
		StaffLogin staffLogin = new StaffLogin();
		boolean isAuth = staffLogin.Login();
		if (isAuth == false) {
			return;
		}
		Scanner sc = new Scanner(System.in);
//		System.out.println("***** Staff Interface *****\n"
//						 + "1. Create/Update/Remove Movie Listing\n"
//						 + "2. Create/Update/Remove Cinema Showtimes\n"
//						 + "3. Configure System Settings");
		
		System.out.println("\n********** Staff Interface **********\n"
						 + "1. Create/Update/Remove Movie Listing\n"
						 + "2. Create/Update/Remove Cinema Showtimes\n"
						 + "3. Configure System Settings\n");
		
		switch(sc.nextInt()) {
			case 1: 
		}
	}
	
}
