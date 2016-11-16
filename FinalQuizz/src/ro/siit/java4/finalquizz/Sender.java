package ro.siit.java4.finalquizz;

import java.util.LinkedList;

public class Sender extends Thread {

	private LinkedList<Packages> ll = new LinkedList<>();
	private LinkedList<Packages> container = new LinkedList<>();
	private int distance = 0;


	public Sender(LinkedList<Packages> ll, LinkedList<Packages> container) {
		this.container = container;
		this.ll = ll;
	}

	@Override
	public void run() {
		try {
			while (!container.isEmpty()) {
				synchronized (ll) {
					Packages p = container.removeFirst();
					distance = p.getDistance();
					ll.add(p);
					boolean checker = true;
					while (!container.isEmpty() && checker) {
						if ((p.getLocation() == container.getFirst().getLocation())	&& (p.getDate() == container.getFirst().getDate())) {
							ll.add(container.getFirst());
							container.removeFirst();
						}
						else{
							checker = false;
						}
					}
				}
				Thread.sleep(distance*1000); //  sleeps till the distance 
			}
		} catch (InterruptedException e) {
		}
	}
}