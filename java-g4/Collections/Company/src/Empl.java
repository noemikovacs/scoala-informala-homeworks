/*
 * In this class we have an Employee object, with @param name, @param position, @ yearAtCompany, @parkingSlot
 */
public class Empl{

	String name, position;
	int yearAtCompany;
	boolean parkingSlot;

	public Empl(String name, String position, int yearAtCompany, boolean parkingSlot) {
		super();
		this.name = name;
		this.position = position;
		this.yearAtCompany = yearAtCompany;
		this.parkingSlot = parkingSlot;
	}

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public int getYearAtCompany() {
		return yearAtCompany;
	}

	public boolean isParkingSlot() {
		return parkingSlot;
	}
	
	
	
	
	
}
