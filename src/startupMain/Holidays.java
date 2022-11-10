package startupMain;

import java.io.Serializable;
import java.util.ArrayList;

public class Holidays implements Serializable {
	
	/**
	 * To implement Serializable
	 */
	private static final long serialVersionUID = -1200651890143885091L;
	private ArrayList<String> holidays;
	
	/**
	 * Constructor for Holidays
	 */
	public Holidays() {
		this.holidays = new ArrayList<String>();
	}
	
	/**
	 * Returns true if inputDate is in list of holidays, false otherwise
	 * @return
	 */
	public static boolean isHoliday(String inputDate) {
		ArrayList<String> checkHolidays = ResourceManager.loadHolidays();
		if (checkHolidays.contains(inputDate))
			return true;
		else
			return false;
	}
}
