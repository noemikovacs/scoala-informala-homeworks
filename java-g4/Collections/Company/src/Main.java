import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		
		ArrayList<Empl> empList = new ArrayList<>();
		empList.add(new Empl("Sam","Manager",5,true));
		empList.add(new Empl("Peter","Junior",3,false));
		empList.add(new Empl("Lukas","Junior",2,false));
		empList.add(new Empl("Ida","Senior",1,false));
		empList.add(new Empl("George","Hr",5,true));
		CompManSys noParkingList = new CompManSys();
		noParkingList.getNoParkingAcces(empList);
		noParkingList.getNoParkingList();
		
		Manager manager = new Manager();
		Junior juniorSwDev = new Junior();
		Senior seniorSwDev = new Senior();
		Hr hr = new Hr();
		
	
		manager.setEmpList(empList);
		juniorSwDev.setEmpList(empList);
		seniorSwDev.setEmpList(empList);
		hr.setEmpList(empList);

		manager.printList();
		juniorSwDev.printList();
		seniorSwDev.printList();
		hr.printList();	
		
		
	}

}
