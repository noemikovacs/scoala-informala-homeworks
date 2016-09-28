/*
 * With this class we set the Student parameters (see below)
 * In this class we have the next parameters:
 * @param firstName;
 * @param lastName;
 * @param id;
 * @param dateOfBirth;
 * @param gender;
 */
package exceptions;


public class Student {
	
	String firstName;
	String lastName;
	int id;
	int dateOfBirth;
	String gender;
	

	public void setStudent(String firstName, String lastName, String gender, int id, int dateOfBirth) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		
	}
	
	public void getStudent(){
		System.out.println(firstName + " " + lastName + " " + gender + " " + id + " " + dateOfBirth);
	}
	
	public int getAge(){
		return dateOfBirth;
	}
}
