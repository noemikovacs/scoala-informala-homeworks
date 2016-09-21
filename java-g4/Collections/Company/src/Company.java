/*
 * In this class we have an ArrayList for the employees; to add the employees to this ArrayList
 * to check the List size , @see method sizeTest @at NoParkingTest
 * a method for printing the employees
 */
import java.util.ArrayList;

public abstract class Company {
	
	ArrayList<Empl> List = new ArrayList<>();
	
	public ArrayList<Empl> getEmpList() {
		return List;
	}
	
	public void setEmpList(ArrayList<Empl> emp) {
		for (Empl c : emp)
		if(c.position.equals("-")){
			this.List.add(c);
		}		
	}

	public int size(){
		return List.size();
	}
	
	public void printList() {
		for (Empl empl : List) {
			System.out.println(empl.name + " " + empl.yearAtCompany +  " " + empl.parkingSlot + " " + empl.position);
		}
		System.out.println();
	}
}
