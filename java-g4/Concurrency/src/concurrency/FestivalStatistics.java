/**
 * This class is responsible the make the statistics is every 5 sec and print the total, and the number of each ticket type
 */
package concurrency;

public class FestivalStatistics extends Thread {

	private FestivalGate gate;

	public FestivalStatistics(FestivalGate gate) {
		this.gate = gate;

	}

	@Override
	public void run() {
		try {
			
			while(true){
				Thread.sleep(5000);
				synchronized (gate.ticketQueue) {
					if (gate.ticketQueue.isEmpty()) {
						gate.ticketQueue.wait();
					}
					int total = 0, fullCount = 0, fullVIPCount = 0, freeCount = 0, oneDayCount = 0, oneDayVIPCount = 0;
					for (TicketType tt : gate.ticketQueue) {
						if (tt == TicketType.FULL) {
							fullCount++;
						}
						if (tt == TicketType.FULL_VIP) {
							fullVIPCount++;
						}
						if (tt == TicketType.FREE_PASS) {
							freeCount++;
						}
						if (tt == TicketType.ONE_DAY) {
							oneDayCount++;
						}
						if (tt == TicketType.ONE_DAY_VIP) {
							oneDayVIPCount++;
						}
						
					}
					total = fullCount + fullVIPCount + freeCount + oneDayCount + oneDayVIPCount;
					System.out.println(total + " people entered");
					System.out.println(fullCount + " people have full tickets");
					System.out.println(fullVIPCount + " have full VIP passes");
					System.out.println(freeCount + " have free passes");
					System.out.println(oneDayCount + " have one-day passes");
					System.out.println(oneDayVIPCount + " have one-day VIP passes");
					System.out.println();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}