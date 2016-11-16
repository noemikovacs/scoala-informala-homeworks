package ro.siit.java4.finalquizz;

import java.util.LinkedList;

public class Reciever extends Thread {

	LinkedList<Packages> ll = new LinkedList<>();
	LinkedList<Integer> tester = new LinkedList<>();
	int profit = 3;
	private int nr = 0;

	public Reciever(LinkedList<Packages> ll) {
		this.ll = ll;
	}

	@Override
	public void run() {
		while (true) {
			try {
				synchronized (ll) {
					if (ll.isEmpty()) {
						//System.out.println("Nothing has arrived.");
					} else {
						nr = 1;
						Packages p = new Packages();
						p = ll.removeFirst();
						int sum = p.getValue();
						int km = p.getDistance();
						boolean checker = true;
						while (!ll.isEmpty() && checker) {
							if((ll.getFirst().getDate() == p.getDate()) && (ll.getFirst().getLocation() == p.getLocation())){
								sum += ll.getFirst().getValue();
								ll.removeFirst();
								nr++;
							}
							else{
								checker = false;
							}
						}
						System.out.println("On the date " + p.getDate() + " the delivered to " + p.getLocation() + " package value is: " + sum + ". The profit is: " + km * nr * profit);
						tester.add(km * nr * profit);
					}
				}
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		}
	}

	public LinkedList<Integer> getProfitList(){
		return tester;
	}
}
