/**
 * This class validates the tickets and their data is kept in a queue
 */
package concurrency;

import java.util.LinkedList;

public class FestivalGate {

	FestivalGate gate;

	public FestivalGate(FestivalGate gate) {
		this.gate = gate;
	}
	
	LinkedList<TicketType> ticketQueue = new LinkedList<>();
	

	public FestivalGate() {

	}

	
	public void validate(TicketType ticket) throws InterruptedException {
	
		ticketQueue.add(ticket);
	}
	
}
