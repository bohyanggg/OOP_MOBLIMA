package startupMain;

import java.util.Scanner;

public class SystemSettingsConfig {

	Scanner sc = new Scanner(System.in);
	
	/**
	 * Menu for configuring ticket prices and holidays
	 */
	public void ssConfigOptions() {
		while (true) {
			System.out.println("\nSelect an option:\n" +
							   "1. Configure Ticket Prices\n" +
							   "2. Configure Holidays\n" +
							   "3. Return to Staff Menu\n");
			switch (sc.nextInt()) {
//			TODO
//			case 1: //how to standardise ticket pricing? with/without making an object from TicketPricing class?
//			case 2: //store in .txt and be able to add/remove dates
			case 3: System.out.println("\nReturning to Staff Menu...\n"); return;
			default: System.out.println("\nInvalid Option.\n");
			}
		}
	}
}
