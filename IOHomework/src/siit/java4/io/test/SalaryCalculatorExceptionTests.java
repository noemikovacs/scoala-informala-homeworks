/*
 * some test to check if the exceptions are working well
 */
package siit.java4.io.test;

import java.io.IOException;

import org.junit.Test;

import siit.java4.io.SalaryCalculator;

public class SalaryCalculatorExceptionTests {

	//checks if there is no manager in the team
	@Test(expected = IllegalArgumentException.class)
	public void testNoManager() throws IOException {
		SalaryCalculator calculator = new SalaryCalculator();
		calculator.read("sales-team_0_manager.txt");
	}
	
	//checks if there is more then 1 manager in the team
	@Test(expected = IllegalArgumentException.class)
	public void testTwoManager() throws IOException {
		SalaryCalculator calculator = new SalaryCalculator();
		calculator.read("sales-team_2_manager.txt");
	}

	//checks if the file is empty
	@Test(expected = IllegalArgumentException.class)
	public void testFileEmpty() throws Exception {
		SalaryCalculator calculator = new SalaryCalculator();
		calculator.read("sales-team_empty.txt");
	}

	//checks if the number format is not correct
	@Test(expected = NumberFormatException.class)
	public void testString() throws Exception {
		SalaryCalculator calculator = new SalaryCalculator();
		calculator.read("sales-team_string.txt");
	}

	//checks if the manager has any sales item
	@Test(expected = IllegalArgumentException.class)
	public void testManaerHasSalesItem() throws Exception {
		SalaryCalculator calculator = new SalaryCalculator();
		calculator.read("sales-team_manager_salesitem.txt");
	}

	//checks if the worked hours is negative
	@Test(expected = IllegalArgumentException.class)
	public void testNegativWorkHour() throws Exception {
		SalaryCalculator calculator = new SalaryCalculator();
		calculator.read("sales-team_negative_work_hour.txt");
	}

	//checks if the number of day offs is negative
	@Test(expected = IllegalArgumentException.class)
	public void testNegativDayOff() throws Exception {
		SalaryCalculator calculator = new SalaryCalculator();
		calculator.read("sales-team_negative_dayoff.txt");
	}
	
	//checks if the number of prepaid sales is negative
	@Test(expected = IllegalArgumentException.class)
	public void testNegativPre() throws Exception {
		SalaryCalculator calculator = new SalaryCalculator();
		calculator.read("sales-team_negative_pre.txt");
	}
	
	//checks if the number of postpaid sales is negative
	@Test(expected = IllegalArgumentException.class)
	public void testNegatiPost() throws Exception {
		SalaryCalculator calculator = new SalaryCalculator();
		calculator.read("sales-team_negative_post.txt");
	}

}
