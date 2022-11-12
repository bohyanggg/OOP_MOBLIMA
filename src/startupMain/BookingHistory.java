package startupMain;

import java.util.ArrayList;

public class BookingHistory {

	private ArrayList<String[]> bookingHistory = new ArrayList<String[]>();;
	
	public BookingHistory() {
		
	}
	
	public void addToBookingHistory(String customerName, String title, String date) {
		String[] singleBookingRecord = new String[3];
		singleBookingRecord[0] = customerName;
		singleBookingRecord[1] = title;
		singleBookingRecord[2] = date;
		bookingHistory = ResourceManager.loadBookingHistory();
		bookingHistory.add(singleBookingRecord);
		ResourceManager.saveBookingHistory(bookingHistory);
	}

	public void printCustomerSpecificBookingHistory(String customerName) {
		bookingHistory = ResourceManager.loadBookingHistory();
		System.out.println(customerName + "'s Booking History:");
		for (int i=0; i<bookingHistory.size(); i++) {
			if (bookingHistory.get(i)[0].equalsIgnoreCase(customerName)) {
				System.out.println((i+1) + ". " + bookingHistory.get(i)[1] + " - " + bookingHistory.get(i)[2]);
			}
		}
		System.out.println();
	}
	
}