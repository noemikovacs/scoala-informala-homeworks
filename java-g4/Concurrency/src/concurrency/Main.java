package concurrency;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		FestivalGate gate = new FestivalGate();

		FestivalStatistics statsThread = new FestivalStatistics(gate);
		statsThread.start();
	
		for ( int index = 0; index < 250; index++) {

			TicketType ticketType = TicketType.getRandom();
			FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(ticketType, gate);
			festivalAttendee.start();
			festivalAttendee.join();

		}
	}
}
