package startupMain;

import java.io.Serializable;
/**
 * Entity class representing the ticket pricing: base prices, additional charges and discounts as attributes
 * @author Low Zheng Han, Lou Sim Teng, MD Firdaus Bin Azizan, Hsieh Boh Yang, Martin Chin
 *
 */
public class TicketPricing implements Serializable {
	
	/**
	 * To implement Serializable
	 */
	private static final long serialVersionUID = 3927137758267882764L;
	
	private double blockbusterCharge;
	private double threeDCharge;
	private double platinumCinemaCharge;
	private double holidayDiscount;
	//senior citizen and child weekday, adult weekday, weekend for all ages
	private double[] baseMoviePricing;
	
	/**
	 * TicketPricing constructor with assigned values
	 */
	public TicketPricing() {
		this.blockbusterCharge = 1;
		this.threeDCharge = 2;
		this.platinumCinemaCharge = 3;
		this.holidayDiscount = 4;
		//senior citizen and child weekday, adult weekday, weekend for all ages
		this.baseMoviePricing = new double[] {6, 9, 12};
	}
	
	/**
	 * Method to calculate ticket price
	 * @param ticket
	 * @param booking
	 * @return
	 */
	public double calculateTicketPrice(Ticket ticket) {
		int totalPrice = 0;
		
		if (ticket.getType().contains("Blockbuster"))
			totalPrice += blockbusterCharge;
		else if (ticket.getType().contains("3D"))
			totalPrice += threeDCharge;
		if (ticket.getCinemaClass() == "Cinema 3") //Cinema 3 Platinum Movie Suite
			totalPrice += platinumCinemaCharge;
		if (Holidays.isHoliday(ticket.getChosenCinemaShowtime().substring(4, 8)) == 1)
			totalPrice -= holidayDiscount;
		if (ticket.getWeekDayOrEnd()==1)
			totalPrice += baseMoviePricing[2];
		else if (ticket.getWeekDayOrEnd()==0 && ticket.getAge()<13 || ticket.getWeekDayOrEnd()==0 && ticket.getAge()>54)
			totalPrice += baseMoviePricing[0];
		else
			totalPrice += baseMoviePricing[1];
		return totalPrice;
	}
	
	/**
	 * Prints all ticket pricing details
	 */
	public void printAllTicketPricingDetails() {
		System.out.println("\nCurrent Ticket Pricing Details:");
		System.out.println("Blockbuster Charge: " + blockbusterCharge);
		System.out.println("3D Charge: " + threeDCharge);
		System.out.println("Platinum Movie Suite Charge: " + platinumCinemaCharge);
		System.out.println("Holiday Discount: " + holidayDiscount);
		System.out.println("Base Movie Pricing [Senior Citizen and Child Weekday, Adult Weekday, Weekend (All)]: " + baseMoviePricing);
	}
	
	public double getBlockbusterCharge() {
		return blockbusterCharge;
	}
	public void setBlockbusterCharge(double blockbusterCharge) {
		this.blockbusterCharge = blockbusterCharge;
	}
	public double getThreeDCharge() {
		return threeDCharge;
	}
	public void setThreeDCharge(double threeDCharge) {
		this.threeDCharge = threeDCharge;
	}
	public double getPlatinumCinemaCharge() {
		return platinumCinemaCharge;
	}
	public void setPlatinumCinemaCharge(double platinumCinemaCharge) {
		this.platinumCinemaCharge = platinumCinemaCharge;
	}
	public double getHolidayDiscount() {
		return holidayDiscount;
	}
	public void setHolidayDiscount(double holidayDiscount) {
		this.holidayDiscount = holidayDiscount;
	}
	public double[] getBaseMoviePricing() {
		return baseMoviePricing;
	}
	public void setBaseMoviePricing(double[] baseMoviePricing) {
		this.baseMoviePricing = baseMoviePricing;
	}
}
