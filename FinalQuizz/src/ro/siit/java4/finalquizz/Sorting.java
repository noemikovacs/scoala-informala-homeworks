package ro.siit.java4.finalquizz;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Sorting extends Thread {

	private LinkedList<Packages> carrier = new LinkedList<>();

	void Sorter() {

	}

	public void addElement(Packages packages) {

		carrier.add(packages);

	}

	Comparator<Packages> comparator = new Comparator<Packages>() {

		public int compare(Packages o1, Packages o2) {

			String x1 = ((Packages) o1).getDate();
			String x2 = ((Packages) o2).getDate();
			int sComp = x1.compareTo(x2);

			if (sComp != 0) {
				return sComp;
			} else {
				String y1 = ((Packages) o1).getLocation();
				String y2 = ((Packages) o2).getLocation();
				return y1.compareTo(y2);
			}
		}
	};

	public void compare() {
		Collections.sort(carrier, comparator);
	}

	public LinkedList<Packages> getList() {
		return carrier;
	}

	public void printList() {
		for (Packages p : carrier) {
			System.out.println(p.getLocation() + " " + p.getDate() + " " + p.getValue() + " " + p.getDistance());
		}
	}

}
