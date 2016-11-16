package ro.siit.java4.finalquizz;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {

		Packages a = new Packages("Cluj", 5, 10, "15.dec.2016");
		Packages b = new Packages("Cluj", 5, 15, "15.dec.2016");
		Packages c = new Packages("Cluj", 5, 10, "16.dec.2016");
		Packages d = new Packages("Aiud", 2, 20, "15.dec.2016");
		Packages e = new Packages("Aiud", 2, 25, "15.dec.2016");
		Packages f = new Packages("Aiud", 2, 25, "16.dec.2016");
		Packages g = new Packages("Brasov", 3, 13, "15.dec.2016");

		Sorting sorter = new Sorting();

		sorter.addElement(a);
		sorter.addElement(b);
		sorter.addElement(c);
		sorter.addElement(d);
		sorter.addElement(e);
		sorter.addElement(f);
		sorter.addElement(g);

		sorter.compare();

		//sorter.printList();
		
		LinkedList<Packages> comm = new LinkedList<>();
		
		Sender reader = new Sender(comm, sorter.getList());
		Reciever writer = new Reciever(comm);
		reader.start();
		writer.start();
	}

}
