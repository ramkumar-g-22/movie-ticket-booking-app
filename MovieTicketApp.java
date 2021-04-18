package com.ram;

import java.time.LocalTime;

import com.ramkumar.DateTimeValidation;
import com.ramkumar.GSTCalculator;
import com.ramkumar.Login;
import com.ramkumar.PriceEstimator;

public class MovieTicketApp {

	public static void main(String[] args) {
		
		boolean isValidMobileNumber = Login.validateMobileNumber("");
		System.out.println("Is valid mobile number : " + isValidMobileNumber);
		boolean isValidPassword = Login.validatePassword("");
		System.out.println("Is Valid Password : " + isValidPassword);
		boolean isValidUser = Login.login("", "");
		System.out.println("Is Valid User : " + isValidUser);
		
		String ticketType = " diamond";
		boolean isValidTicketType = TicketTypeManager.validateTicketType(ticketType);
		System.out.println("Is Valid Ticket Type : " + isValidTicketType);
		int ticketTypeFarePrice = 0;
		if (isValidTicketType) {
			ticketTypeFarePrice = TicketTypeManager.ticketTypeFarePrice(ticketType);
			System.out.println("Fare Price for " + ticketType.trim() + " Ticket : " + ticketTypeFarePrice);			
		}
		
		int seats = 1;
		int totalFarePriceWithoutGST = PriceEstimator.calculateTotalFarePriceWithoutGST(ticketTypeFarePrice, seats);
		System.out.println("Total Fare Price Without GST : " + totalFarePriceWithoutGST);

		double GSTPercentage = 12;
		double totalFarePriceWithGST = GSTCalculator.calculateTotalFarePriceWithGST(totalFarePriceWithoutGST, GSTPercentage);
		System.out.println("Total Fare Price With GST : " + totalFarePriceWithGST);

		String bookingDateString = "2021-04-20";
		boolean isValidDate = DateTimeValidation.validateDate(bookingDateString);
		System.out.println("Is Valid Date : " + isValidDate);
		String bookingTimeString = "05:20";
		boolean isValidTime = DateTimeValidation.validateTime(bookingTimeString);
		System.out.println("Is Valid Time : " + isValidTime);

		String cardExpiryDate = "2021-06-20";
		if (isValidDate && isValidTime) {
			boolean isTicketBooked = BookingTicket.bookTicket(cardExpiryDate, bookingDateString, bookingTimeString);
			if (isTicketBooked) {
				System.out.println("🎟🎟🎟 Your ticket is booked ✔✔✔");
				System.out.println("Booking Date : " + bookingDateString);
				System.out.println("Booking Time : " + bookingTimeString);				
			}else {
				System.out.println("Not a valid card");
			}
		}
		
		if (isValidTime) {
			LocalTime bookingTime = LocalTime.parse(bookingTimeString);
			double totalFarePriceAtPeakTime = PriceEstimator.calculateTotalFareAtPeakTime(bookingTime, totalFarePriceWithGST, seats);
			System.out.println("Total Fare Price at peak time : " + totalFarePriceAtPeakTime);
		}

		String dateOfBirthString = "1950-04-17";
		boolean isValidDateOfBirth = DateTimeValidation.validateDateOfBirth(dateOfBirthString);
		System.out.println("Is Valid DoB : " + isValidDateOfBirth);
		if (isValidDateOfBirth) {
			byte age = DateTimeValidation.calculateAge(dateOfBirthString);
			System.out.println("Age : " + age);
			if (age > 60) {
				double totalFareForSeniorCitizen = PriceEstimator.calculateTotalFareForSeniorCitizen(totalFarePriceWithGST);
				System.out.println("Total Fare for Senior Citizen : " + totalFareForSeniorCitizen);
			}
		}
		
	}

}
