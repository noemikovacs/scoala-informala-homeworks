package ro.siit.java4.finalquizz;

public class Packages {

	private String location;
	private int distance;
	private int value;
	private String deliveryDate;

	public Packages(String location, int distance, int value, String deliveryDate) {

		this.location = location;
		this.distance = distance;
		this.value = value;
		this.deliveryDate = deliveryDate;
	}

	public String getLocation() {
		return this.location;
	}

	public String getDate() {
		return this.deliveryDate;
	}

	public int getValue() {
		return this.value;
	}

	public int getDistance() {
		return this.distance;
	}
	
	public Packages() {
		
	}
}
