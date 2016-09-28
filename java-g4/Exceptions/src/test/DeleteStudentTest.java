package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.StudentList;

//test for delete method
public class DeleteStudentTest {

	//this method checks if the id is empty
	@Test
	public void testIdIsempty() {
		Throwable e = null;
		  try {
				StudentList stud = new StudentList();
				stud.add("Alin", "Pista", "a", 1901, 1901);
				stud.delete(0);
		  } catch (Throwable ex) {
		    e = ex;
		  }
		  assertTrue(e instanceof Exception);
	}
	
	//this method checks if the student with the id does not exist
	@Test
	public void testStudentNotExists() {
		Throwable e = null;
		  try {
				StudentList stud = new StudentList();
				stud.add("Alin", "Pista", "a", 1901, 1901);
				stud.delete(1902);
		  } catch (Throwable ex) {
		    e = ex;
		  }
		  assertTrue(e instanceof Exception);
	}

}
