package startupMain;

public class TicketPricing {
	
	private double blockbusterCharge;
	private double threeDCharge;
	private double platinumCinemaCharge;
	private double holidayDiscount;
	//senior citizen and child weekday, adult weekday, weekend for all ages
	private double[] baseMoviePricing;
	
	/**
	 * TicketPricing constructor with default values
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
	public double calculateTicketPrice(Ticket ticket, Booking booking) {
		int totalPrice = 0;
		if (ticket.getType().contains("Blockbuster"))
			totalPrice += blockbusterCharge;
		else if (ticket.getType().contains("3D"))
			totalPrice += threeDCharge;
		if (ticket.getCinemaClass() == "Cinema 3") //Cinema 3 Platinum Movie Suite
			totalPrice += platinumCinemaCharge;
//		TODO CHECK IF DATE OF MOVIE CHOSEN IS A HOLIDAY
//		if (booking.get???().isHoliday())
//			totalPrice -= holidayDiscount;
		if (ticket.getWeekDayOrEnd()==1)
			totalPrice += baseMoviePricing[2];
		else if (ticket.getWeekDayOrEnd()==0 && ticket.getAge()<13 || ticket.getAge()>54)
			totalPrice += baseMoviePricing[0];
		else
			totalPrice += baseMoviePricing[1];
		return totalPrice;
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
	public double[] getBaseMoviePricing() {
		return baseMoviePricing;
	}
	public void setBaseMoviePricing(double[] baseMoviePricing) {
		this.baseMoviePricing = baseMoviePricing;
	}
	public double getHolidayDiscount() {
		return holidayDiscount;
	}
	public void setHolidayDiscount(double holidayDiscount) {
		this.holidayDiscount = holidayDiscount;
	}
}
