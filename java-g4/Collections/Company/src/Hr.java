/*
 * this class contains the HR role in the company
 * It checks if the position is HR then the employee is added to the list
 */
import java.util.ArrayList;

public class Hr extends Company {

	@Override
	public void setEmpList(ArrayList<Empl> emp) {
		for (Empl c : emp)
		if(c.position.equals("Hr")){
			this.List.add(c);
		}		
	}

}
