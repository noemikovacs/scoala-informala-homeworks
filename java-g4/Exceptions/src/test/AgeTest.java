package test;

import static org.junit.Assert.*;

import javax.xml.bind.ValidationException;

import org.junit.Test;

import exceptions.StudentList;

//test for StudentSameAge
public class AgeTest {
	
	//this method checks if the age is not a number
	@Test
	public void testAgeNotNumber() {
		Throwable e = null;
		  try {
				StudentList stud = new StudentList();
				stud.add("Alin", "Pista", "m", 1901, 1901);
				stud.studentSameAge("f");
		  } catch (Throwable ex) {
		    e = ex;
		  }
		  assertTrue(e instanceof ValidationException);
	}
	
	//this method checks if the age is negative
	@Test
	public void testAgeNegative() {
		Throwable e = null;
		  try {
				StudentList stud = new StudentList();
				stud.add("Alin", "Pista", "m", 1901, 1901);
				stud.studentSameAge("-5");
		  } catch (Throwable ex) {
		    e = ex;
		  }
		  assertTrue(e instanceof Exception);
	}

}
