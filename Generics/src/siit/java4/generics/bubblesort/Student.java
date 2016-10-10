/*
 * This class make an Object, named Student for test @see TestObject
 * @param name
 * @param adress
 * @param collegeNr
 * @param idNumber
 * 
 */
package siit.java4.generics.bubblesort;

public class Student implements Comparable<Student>{

	String name;
	String address;
	int collegeNr;
	String idNumber;
	

	public Student() {

	}

	public Student(String name, String address, int college, String idNumber) {
		this.name = name;
		this.address = address;
		this.collegeNr = college;
		this.idNumber = idNumber;
	}
	
	public int compareTo(Student s){
		return this.name.compareTo(s.name);		
	}
	
	public void print(){
		System.out.println(this.name + " " + this.address + " " + this.collegeNr + " " + this.idNumber);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + collegeNr;
		result = prime * result + ((idNumber == null) ? 0 : idNumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (collegeNr != other.collegeNr)
			return false;
		if (idNumber == null) {
			if (other.idNumber != null)
				return false;
		} else if (!idNumber.equals(other.idNumber))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
