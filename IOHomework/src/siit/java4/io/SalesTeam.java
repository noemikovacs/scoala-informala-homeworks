/*
 * In this class we defined the sales team members 
 * @param name- name of the employee
 * @param workedHours- the worked hours
 * @param dayOffs- the number of day offs
 * @param nrOfPrePaidS- the number of pre paid salary
 * @param nrOfPostPaidS- the number of post paid salary
 * @param salary
 */
package siit.java4.io;

public class SalesTeam {

	String name;
	JobPosition jobPosition;
	int workedHours;
	int dayOffs;
	int nrOfPrepaidS;
	int nrOfPostpaidS;
	public int salary = 0;

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getSalary() {
		return this.salary;
	}

	public SalesTeam (String name, String jobPosition, int workedHours, int dayOffs, int nrOfPrepaidS,
			int nrOfPostpaidS) {
		super();
		this.name = name;

		if (jobPosition.equalsIgnoreCase("Sales Manager")) {
			this.jobPosition = JobPosition.SALES_MANAGER;
		}
		if (jobPosition.equalsIgnoreCase("Senior Sales Officer")) {
			this.jobPosition = JobPosition.SENIOR_SALES_OFFICER;
		}
		if (jobPosition.equalsIgnoreCase("Sales Officer")) {
			this.jobPosition = JobPosition.SALES_OFFICER;
		}

		this.workedHours = workedHours;
		this.dayOffs = dayOffs;
		this.nrOfPrepaidS = nrOfPrepaidS;
		this.nrOfPostpaidS = nrOfPostpaidS;
	}


	
	}


