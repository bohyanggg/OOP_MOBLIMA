package startupMain;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Entity class representing the holidays
 * @author Low Zheng Han, Lou Sim Teng, MD Firdaus Bin Azizan, Hsieh Boh Yang, Martin Chin
 *
 */
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
	public static int isHoliday(String inputDate) {
		ArrayList<String> checkHolidays = ResourceManager.loadHolidays();
		if (checkHolidays.contains(inputDate))
			return 1;
		else
			return 0;
	}
}
