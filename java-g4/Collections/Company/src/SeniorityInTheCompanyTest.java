import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SeniorityInTheCompanyTest {

	@Test
	public void test() {
		//given
		ArrayList<Empl> empList = new ArrayList<>();
		empList.add(new Empl("Sam","Manager",5,false));
		empList.add(new Empl("John","Junior",0,true));
		empList.add(new Empl("Kennedy","Senior",10,true));
		empList.add(new Empl("Daniel","Manager",2,true));
		Manager manager = new Manager();
		
		manager.setEmpList(empList);
		
		int actual = manager.size();

		int expected = 2;	

		assertEquals(expected, actual);

	}

}
