/*
 * this class contains the Manager role in the company
 * It checks if the position is Manager then the employee is added to the list
 */
import java.util.ArrayList;

public class Manager extends Company {

	@Override
	public void setEmpList(ArrayList<Empl> emp) {
		for (Empl c : emp)
		if(c.position.equals("Manager")){
			this.List.add(c);
		}		
	}

}
