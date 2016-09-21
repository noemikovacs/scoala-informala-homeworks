import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class NoParkingTest {

	@Test
	
	public void sizeTest() {
		ArrayList<Empl> empList = new ArrayList<>();
		empList.add(new Empl("Steve","Junior",3,true));
		empList.add(new Empl("Alex","Junior",3,false));
		empList.add(new Empl("Tiby","Junior",3,false));
	
		CompManSys noParkingList = new CompManSys();
		noParkingList.getNoParkingAcces(empList);
		int actual = noParkingList.size();

		int expected = 2;	

		assertEquals(expected, actual);
		
	}
	
	@Test
	
	public void orderTest() {
		ArrayList<Empl> empList = new ArrayList<>();
		empList.add(new Empl("Steve","Junior",3,true));
		empList.add(new Empl("Alex","Junior",3,false));
		empList.add(new Empl("Tiby","Junior",3,false));
		
		CompManSys noParkingList = new CompManSys();
		noParkingList.getNoParkingAcces(empList);
		String[] actual;
		actual = noParkingList.order();
		
		String[] expected = {"Tiby", "Alex"};
		
		assertArrayEquals(expected, actual);
		
	}
}
