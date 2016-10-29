/**
 * This class is responsible for ticket types (full, full vip, free pass one day pass and one day vip pass)
 * This class also has a method for randomize the ticket types
 */
package concurrency;

import java.util.Random;

public enum TicketType {

	FULL, FULL_VIP, FREE_PASS, ONE_DAY, ONE_DAY_VIP;

	public static TicketType[] ticketData = TicketType.values();
	public static final Random random = new Random();

	public static TicketType getRandom() {
		return values()[(int) (Math.random() * values().length)];
	}
}
