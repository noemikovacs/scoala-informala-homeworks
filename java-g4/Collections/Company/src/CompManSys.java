/*
 * The Company Management System (this class) allow a way to obtain a list of employees 
 * who don't have any parking spaces. 
 * The list ordered based on the employee's seniority in the company.
 */
import java.util.ArrayList;
import java.util.TreeSet;

public class CompManSys {

	TreeSet <Empl> noParkingList = new TreeSet<Empl>(new YearAtComp());
	
	public CompManSys(TreeSet<Empl> noParkingList) {
		super();
		this.noParkingList = noParkingList;
	}
	
	public CompManSys() {
	}

	public TreeSet<Empl> getNoParkingAcces(ArrayList<Empl> empList){
		for (Empl empl : empList) {
			if (!empl.parkingSlot) {
				noParkingList.add(empl);
			}			
		}
		return noParkingList;
	}

	
	public void getNoParkingList() {
		for (Empl empl : noParkingList) {
			System.out.println(empl.name + " " + empl.position + " " + empl.yearAtCompany +  " " + empl.parkingSlot + " ");
		}
		System.out.println();
	}

	public void add(Empl empl) {
		noParkingList.add(empl);
	}
	
	public int size(){
		return noParkingList.size();
	}
	
	public String[] order(){
		String[] names = new String[noParkingList.size()];
		int i = 0;
		for(Empl empl : noParkingList){
			names[i] = empl.name;
			i++;
		}
		return names;
	}
}
