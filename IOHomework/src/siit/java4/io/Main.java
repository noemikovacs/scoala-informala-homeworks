package siit.java4.io;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SalaryCalculator salary = new SalaryCalculator();
		salary.read("sales-team.txt");
		salary.calculate();
	}
}
