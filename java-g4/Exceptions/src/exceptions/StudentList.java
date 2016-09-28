/*
 * In this class we made Student type ArrayList. We can add, delete students from this list. 
 * The following validations were handled in add method:
 *	- date of birth between 1900 and current year - 18 
 *	- first name and last name should not be empty
 *	- gender should be male or female (or M and F), upper/lower case should both be accepted
 * The following validations were handled in delete method:
 * 	- The ID is 0
 * 	- Student does not exist
 * The following validations were handled in studentSameAge method:
 * 	- Age is not an integer
 * 	- The age is a negative number
 * The following validation was handled in getList method:
 * 	- Invalid input
 */
package exceptions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

import javax.xml.bind.ValidationException;

public class StudentList {

	ArrayList<Student> List = new ArrayList<>(); // make a Student type ArraList
	
	public void add(String firstName, String lastName, String gender, int id, int dateOfBirth) throws Exception{
		Student student = new Student();
		testAge(dateOfBirth);
		if (!gender.equalsIgnoreCase("m") && (!gender.equalsIgnoreCase("f"))){
			throw new Exception ("Invalid gender.");
		}
		if (lastName.isEmpty() || firstName.isEmpty()) {
			  throw new Exception("The last name/ first name is not entered.");
		}
		student.setStudent(firstName, lastName, gender, id, dateOfBirth);
		List.add(student);
	}
	
	private void testAge(int dateOfBirth){
		int year = Calendar.getInstance().get(Calendar.YEAR);
		if(dateOfBirth < 1900 || dateOfBirth+18>year){
			throw new IllegalArgumentException("Birth date should be between 1900 and current year - 18.");
		}
	}
	
	public void delete(int id) throws Exception {
		if (id == 0) {
			throw new Exception("The ID is 0.");
		}
		boolean check = false;
		for (Student e : List){
			if (e.id  == id){
				check = true;
				List.remove(e);
			}
		}
		if (!check) {
			throw new Exception("Student does not exist.");
		}
	}
	
	public void studentSameAge(String age) throws Exception{
		
		int intAge;
		  try { 
			   intAge = Integer.parseInt(age); 
			
			  }catch (NumberFormatException e){ 
			    throw new ValidationException("Age should be an int"); 
			  } 
		 if(intAge < 0){
			throw new Exception("Negative age.");
	     }
		 int year = Calendar.getInstance().get(Calendar.YEAR);
		 for(Student e : List){
			 if(year - e.dateOfBirth == intAge){
				 e.getStudent();
			 }
		 }

	}
	
	public void getList(String type) throws Exception{
		if (!type.equalsIgnoreCase("last name") && !type.equalsIgnoreCase("date of birth"))
		{
			throw new Exception ("Invalid input.");
		}
		
		if (type.equalsIgnoreCase("last name")){
			Collections.sort(List, new Comparator<Student>() {
				@Override
		        public int compare(Student student1, Student student2)
		        {
		            return  student1.lastName.compareTo(student2.lastName);
		        }
			});
			System.out.println("Arranged by last name:");
			for(Student e : List){
				e.getStudent();
			}
		}
		
		if (type.equalsIgnoreCase("date of birth")){
			Collections.sort(List, new Comparator<Student>() {
				@Override
		        public int compare(Student student1, Student student2)
		        {
		            return  student1.dateOfBirth - student2.dateOfBirth;
		        }
		    });
			System.out.println("Arranged by date of birth:");
			for(Student e : List){
				e.getStudent();
			}
		}
	}
	
}
