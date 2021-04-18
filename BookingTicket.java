package com.ram;

import com.ramkumar.DateTimeValidation;

public class BookingTicket {
	
	/**
	 * Validates the given card expire date.
	 * @param cardExpiryDate
	 * @param journeyDate
	 * @param pickUpTime
	 * @return
	 */
	public static boolean bookTicket(String cardExpiryDate, String bookingDate, String bookingTime) {
		boolean isValidCard = DateTimeValidation.validateCardExpiryDate(cardExpiryDate);
		return isValidCard;
	}	

}
