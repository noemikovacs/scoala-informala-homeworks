package test;

import static org.junit.Assert.*;
import org.junit.Test;
import exceptions.StudentList;

//test cases for add method
public class StudentTest {

	//checks if age is below 1900
	@Test
	public void testDateOfirthSmaller1900() {
		Throwable e = null;
		  try {
				StudentList stud = new StudentList();
				stud.add("Alin", "Pista", "f", 1901, 1899);
		  } catch (Throwable ex) {
		    e = ex;
		  }
		  assertTrue(e instanceof IllegalArgumentException);
	}
	
	//checks if the age is lower than currentYear - 18
	@Test
	public void testDateOfirthSmallerCurrentMinus18() {
		Throwable e = null;
		  try {
				StudentList stud = new StudentList();
				stud.add("Alin", "Pista", "f", 1901, 2009);
		  } catch (Throwable ex) {
		    e = ex;
		  }
		  assertTrue(e instanceof IllegalArgumentException);
	}
	
	//checks if the first or last name is empty
	@Test
	public void testNameNotEmpty() {
		Throwable e = null;
		  try {
				StudentList stud = new StudentList();
				stud.add("Alin", "", "f", 1901, 1950);
		  } catch (Throwable ex) {
		    e = ex;
		  }
		  assertTrue(e instanceof Exception);
	}
	
	//checks if the gender is set correctly
	@Test
	public void testGender() {
		Throwable e = null;
		  try {
				StudentList stud = new StudentList();
				stud.add("Alin", "Pista", "a", 1901, 1901);
		  } catch (Throwable ex) {
		    e = ex;
		  }
		  assertTrue(e instanceof Exception);
	}

}
