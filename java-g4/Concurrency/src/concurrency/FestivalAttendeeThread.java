/**
 * In this class every person is represented by a special Thread that is instantiated with random ticket data. 
 */
package concurrency;

import java.util.Random;

public class FestivalAttendeeThread extends Thread {

	private TicketType ticketType;
	private FestivalGate gate;
	Random random = new Random();

	public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
		super();
		this.ticketType = ticketType;
		this.gate = gate;
	}

	@Override

	public void run() {
		try {
			
			synchronized (gate.ticketQueue) {
				gate.validate(ticketType);
				gate.ticketQueue.notify();
			}
			
			FestivalAttendeeThread.sleep(95 + random.nextInt(10)) ;
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void generateAtendee(int Max){
		for ( int index = 0; index < Max; index++) {

			TicketType ticketType = TicketType.getRandom();
			FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(ticketType, gate);
			festivalAttendee.start();
			
		}
	}

}
