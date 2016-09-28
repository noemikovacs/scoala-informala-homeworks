package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.StudentList;

//test for getList
public class OrderListTest {

	//this method checks if the string is "last name" or "date of birth" 
	@Test
	public void testOrderNameException() {
		Throwable e = null;
		  try {
				StudentList stud = new StudentList();
				stud.add("Alin", "Pista", "m", 1901, 1901);
				stud.add("Mirela", "Adriana", "f", 1903, 1922);
				stud.add("Ana", "Irimie", "f", 1904, 1903);
				stud.getList("last name1");
		  } catch (Throwable ex) {
		    e = ex;
		  }
		  assertTrue(e instanceof Exception);
	}

}
