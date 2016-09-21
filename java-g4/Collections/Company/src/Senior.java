/*
 * this class contains the Senior role in the company
 * It checks if the position is Senior then the employee is added to the list
 */
import java.util.ArrayList;

public class Senior extends Company {

	@Override
	public void setEmpList(ArrayList<Empl> emp) {
		for (Empl c : emp)
		if(c.position.equals("Senior")){
			this.List.add(c);
		}		
	}
}
