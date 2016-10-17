/*
 * In this class we read the txt file with help of path (read line by line)
 * with the help of the for loop we used "|" to divide the parameters of the object
 * @param isManager (There is always only one sales manager per/team. If the number of sales managers in a file is 0 or more than 1, an error has to be shown.)
 * @param paidChecker (to check if the manager doesn't have sales items)
 * @param negativeDay (to check if there is negative day off)
 * @param negativeWorkHour (to check if there is negative worked hour)
 * @param negativePre (to check if there is negative pre paid sales)
 * @param negativePost (to check if there is negative post paid sales)
 * In this class we calculated all employees salary and bonuses
 * For the manager the salary and bonus scheme is the following:
 * Salary: 40 Euro / hour
 * Monthly Bonus: 30Euro * total number of postapaid sales achieved by the team AND 15Euro * total number of prepaid sales achieved by the team
 * For a Senior Sales Officer
 * Salary: 20 Euro / hour
 * Monthly Bonus: 50Euro* postpaid sales AND 25Euro* prepaid sales25Euro prepaid sales  
 * For a Sales Officer
 * Salary: 10 Euro / hour
 * Monthly Bonus: 25Euro* postpaid sales AND 10Euro* prepaid sales
 */
package siit.java4.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class SalaryCalculator {


	JobPosition jobPosition;
	ArrayList<SalesTeam> team = new ArrayList<SalesTeam>();

	public void read(String file) throws IOException {
		File txt = new File(file);
		List<String> lines = Files.readAllLines(txt.toPath());
		for (String s : lines) {
			int index1 = s.indexOf("|");
			int index2 = s.indexOf('|', index1 + 1);
			int index3 = s.indexOf("|", index2 + 1);
			int index4 = s.indexOf("|", index3 + 1);
			int index5 = s.indexOf('|', index4 + 1);
			String s1 = s.substring(0, index1);
			String s2 = s.substring(index1 + 1, index2);
			int s3 = 0, s4 = 0, s5 = 0, s6 = 0;
			if (!s.substring(index2 + 1, index3).equals(""))
				s3 = Integer.parseInt(s.substring(index2 + 1, index3));
			if (!s.substring(index3 + 1, index4).equals(""))
				s4 = Integer.parseInt(s.substring(index3 + 1, index4));
			if (!s.substring(index4 + 1, index5).equals("")) {
				s5 = Integer.parseInt(s.substring(index4 + 1, index5));
			}
			if (!s.substring(index5 + 1).equals("")) {
				s6 = Integer.parseInt(s.substring(index5 + 1));
			}
			SalesTeam temp = new SalesTeam(s1, s2, s3, s4, s5, s6);
			team.add(temp);
		}

		int isManager = 0;
		boolean paidChecker = false;
		boolean negativeDay = false;
		boolean negativeWorkHour = false;
		boolean negativePre = false;
		boolean negativePost = false;
		for (SalesTeam temp : team) {
			if (temp.jobPosition == JobPosition.SALES_MANAGER) {
				isManager++;
			}
			if (temp.jobPosition == JobPosition.SALES_MANAGER && (temp.nrOfPostpaidS != 0 || temp.nrOfPrepaidS != 0)) {
				paidChecker = true;
			}
			if (temp.workedHours < 0) {
				negativeWorkHour = true;
			}
			if (temp.dayOffs < 0) {
				negativeDay = true;
			}
			if (temp.nrOfPrepaidS < 0) {
				negativePre = true;
			}
			if (temp.nrOfPostpaidS < 0) {
				negativePost = true;
			}
		}
		if (team.isEmpty()) {
			throw new IllegalArgumentException("The file is empty.");
		}
		if (isManager != 1) {
			throw new IllegalArgumentException("The number of managers must be 1! ");
		}

		if (paidChecker) {
			throw new IllegalArgumentException("The manager doesn't has sales items! ");
		}

		if (negativeWorkHour) {
			throw new IllegalArgumentException("Negative workhour! ");
		}

		if (negativeDay) {
			throw new IllegalArgumentException("Negative dayoffs! ");
		}

		if (negativePre) {
			throw new IllegalArgumentException("Negative presales! ");
		}

		if (negativePost) {
			throw new IllegalArgumentException("Negative postsales! ");
		}
	}

	public ArrayList<SalesTeam> calculate() {
		for (SalesTeam c : team) {
			this.calculator(c,team);
		}
		return team;
	}

	public void calculator(SalesTeam c, ArrayList<SalesTeam> salesTeam) {

		int salary = 0, bonus = 0, total = 0;
		

		switch (c.jobPosition) {
		case SALES_MANAGER:
			salary = (c.workedHours + c.dayOffs * 8) * 40;

			for (SalesTeam d : salesTeam) {
				bonus += d.nrOfPostpaidS * 30 + d.nrOfPrepaidS * 15;
			}
			total = salary + bonus;
			c.salary = total;
			System.out.println(c.name + "-" + total);
			
			break;
		case SALES_OFFICER:
			salary = (c.workedHours + c.dayOffs * 8) * 10;
			bonus = c.nrOfPostpaidS * 25 + c.nrOfPrepaidS * 10;
			total = salary + bonus;
			c.salary = total;
			System.out.println(c.name + "-" + total);
			break;
		case SENIOR_SALES_OFFICER:
			salary = (c.workedHours + c.dayOffs * 8) * 20;
			bonus = c.nrOfPostpaidS * 50 + c.nrOfPrepaidS * 25;
			total = salary + bonus;
			c.salary = total;
			System.out.println(c.name + "-" + total);
			break;
		default:
			break;

		}
	}
}
