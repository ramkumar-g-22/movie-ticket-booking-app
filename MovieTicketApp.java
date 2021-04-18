package com.ram;

import com.ramkumar.Login;

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
		
		

	}

}
