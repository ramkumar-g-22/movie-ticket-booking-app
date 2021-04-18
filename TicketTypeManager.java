package com.ram;

public class TicketTypeManager {
	
	/**
	 * Validates the given ticket types.
	 * Returns true if the specified ticket type is valid.
	 * Otherwise returns false. 
	 * @param ticketType
	 * @return
	 */
	public static boolean validateTicketType(String ticketType) {
		String ticketTypes[] = {"Diamond", "Pearl", "Gold"};
		boolean validTicketType = false;
		try {
			for (String ticket : ticketTypes) {
				validTicketType = ticket.equalsIgnoreCase(ticketType.trim());
				if (validTicketType) {
					break;
				}
			}
		} catch (Exception e) {
			validTicketType = false;
		}
		return validTicketType;
	}

	/**
	 * Returns the fare price for given ticket type.
	 * @param ticketType
	 * @return
	 */
	public static int ticketTypeFarePrice(String ticketType) {
		ticketType = convertToLowerCase(ticketType.trim());
		int farePriceForDiamond = 500;
		int farePriceForPearl = 480;
		int farePriceForGold = 450;
		int farePriceForTicketType = 0;
			switch (ticketType) {
				case "diamond":
					farePriceForTicketType = farePriceForDiamond;
					break;
				case "pearl":
					farePriceForTicketType = farePriceForPearl;
					break;
				case "gold":
					farePriceForTicketType = farePriceForGold;
					break;
				default:
					break;
				}
		return farePriceForTicketType;
	}

	/**
	 * Returns the given ticket type to lower case.
	 * @param ticketType
	 * @return
	 */
	private static String convertToLowerCase(String ticketType) {
		return ticketType.toLowerCase();
	}

}
