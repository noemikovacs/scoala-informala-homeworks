/*
 * this class contains the Junior role in the company
 * It checks if the position is Junior then the employee is added to the list
 */
import java.util.ArrayList;

public class Junior extends Company {

	@Override
	public void setEmpList(ArrayList<Empl> emp) {
		for (Empl c : emp)
		if(c.position.equals("Junior")){
			this.List.add(c);
		}		
	}
	
}
