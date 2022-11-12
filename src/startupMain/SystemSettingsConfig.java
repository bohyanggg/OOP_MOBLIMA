package startupMain;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Boundary class
 * @author Low Zheng Han, Lou Sim Teng, MD Firdaus Bin Azizan, Hsieh Boh Yang, Martin Chin
 *
 */
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
			case 1: configureTicketPrices(); break;
			case 2: configureHolidays(); break;
			case 3: System.out.println("\nReturning to Staff Menu...\n"); return;
			default: System.out.println("\nInvalid Option.\n");
			}
		}
	}
	
	/**
	 * Method for configuration of ticket prices
	 */
	public void configureTicketPrices() {
		TicketPricing ticketPricing = new TicketPricing();
		ticketPricing = ResourceManager.loadTicketPricing();
		ticketPricing.printAllTicketPricingDetails();
		System.out.println("\nSelect an option for modification:\n" +
						   "1. Blockbuster Charge\n" +
						   "2. 3D Charge\n" +
						   "3. Platinum Movie Suite Charge\n" +
						   "4. Holiday Discount\n" +
						   "5. Base Movie Pricing\n" +
						   "6. Return\n");
		
		switch (sc.nextInt()) {
		case 1: System.out.print("\nEnter new Blockbuster Charge:");
				ticketPricing.setBlockbusterCharge(sc.nextDouble());
				System.out.println("\nUpdated!");
				break;
				
		case 2: System.out.print("\nEnter new 3D Charge:");
				ticketPricing.setThreeDCharge(sc.nextDouble());
				System.out.println("\nUpdated!");
				break;
		
		case 3: System.out.print("\nEnter new Platinum Movie Suite Charge:");
				ticketPricing.setPlatinumCinemaCharge(sc.nextDouble());
				System.out.println("\nUpdated!");
				break;
		
		case 4: System.out.print("\nEnter new Holiday Discount:");
				ticketPricing.setHolidayDiscount(sc.nextDouble());
				System.out.println("\nUpdated!");
				break;
		
		case 5: double[] newBasePrices = new double[3];
				System.out.print("\nEnter new Senior Citizen and Child (Weekday) Pricing:");
				newBasePrices[0] = sc.nextDouble();
				System.out.print("\nEnter new Adult (Weekday) Pricing:");
				newBasePrices[1] = sc.nextDouble();
				System.out.print("\nEnter new Weekend Pricing:");
				newBasePrices[2] = sc.nextDouble();
				ticketPricing.setBaseMoviePricing(newBasePrices);
				System.out.println("\nUpdated!");
				break;
		
		case 6: return;
		
		default: System.out.println("\nInvalid Option.\n"); return;
		}
		
		ResourceManager.saveTicketPricing(ticketPricing);
	}
	
	/**
	 * Method for configuration of holidays (dates)
	 */
	public void configureHolidays() {
		ArrayList<String> holidays = new ArrayList<String>();
		holidays = ResourceManager.loadHolidays();
		System.out.println("\nSelect an Option:\n" +
						   "1. Add Holiday\n" +
						   "2. Remove Holiday\n" +
						   "3. Return\n");
		
		switch (sc.nextInt()) {
		case 1: System.out.print("\nEnter new holiday (e.g. DD/MM):");
				holidays.add(sc.nextLine());
				System.out.println("\nAdded!");
				break;
				
		case 2: System.out.println("\nSelect holiday to be removed:");
				for (int i=0; i<holidays.size(); i++) {
					System.out.println((i+1) + ". " + holidays.get(i));
				}
				holidays.remove(sc.nextInt());
				System.out.println("\nRemoved!");
				break;
		
		case 3: return;
		
		default: System.out.println("\nInvalid Option.\n"); return;
		}
		
		ResourceManager.saveHolidays(holidays);
	}
}
