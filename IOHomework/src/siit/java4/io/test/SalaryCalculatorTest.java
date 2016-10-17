/*
 * to check if the salary calculator is working well
 */
package siit.java4.io.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import siit.java4.io.SalaryCalculator;
import siit.java4.io.SalesTeam;

public class SalaryCalculatorTest {

	@Test
	public void testSalaryCalculator() throws Exception {
		SalaryCalculator calculator = new SalaryCalculator();
		calculator.read("sales-team.txt");
		ArrayList<SalesTeam> team = calculator.calculate();
		ArrayList<Integer> actual = new ArrayList<Integer>();
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(3825);
		expected.add(1740);
		expected.add(1935);
		expected.add(3950);
		for (SalesTeam temp : team) {
			actual.add(temp.getSalary());
		}
		assertTrue(actual.equals(expected));
	}

}
