package test.unitTests;

import org.junit.Assert;
import org.junit.Test;

import unitTests.Distance;
import unitTests.MetricDistanceConverter;
import unitTests.UnknownDistanceFormatException;

public class DistanceConverterTest {

	@Test
	public void mmToFootConvertion() throws UnknownDistanceFormatException {
		
		Distance mm1000 = new Distance(Distance.MILLIMETERS, 1000);
		MetricDistanceConverter distanceConverter = new MetricDistanceConverter();
		
		Distance result = distanceConverter.convert(mm1000, Distance.FOOT);
		Distance expected = new Distance(Distance.FOOT, 3.2808);
		
		Assert.assertEquals("Convertion from mm to ft is incorrect.", expected,  result);
	}
	
	@Test
	public void cmToInchesConvertion() throws UnknownDistanceFormatException {
		
		Distance cm50 = new Distance(Distance.CENTIMETERS, 50);
		MetricDistanceConverter distanceConverter = new MetricDistanceConverter();
		
		Distance result = distanceConverter.convert(cm50, Distance.INCHES);
		Distance expected = new Distance(Distance. INCHES, 19.68505);
		
		Assert.assertEquals("Convertion from cm to in is incorrect.", expected,  result);
	}
	
	@Test
	public void dmToHectometerConvertion() throws UnknownDistanceFormatException {
		
		Distance dm1520 = new Distance(Distance.DECIMETERS, 1520);
		MetricDistanceConverter distanceConverter = new MetricDistanceConverter();
		
		Distance result = distanceConverter.convert(dm1520, Distance.HECTOMETERS);
		Distance expected = new Distance(Distance. HECTOMETERS, 1.52);
		
		Assert.assertEquals("Convertion from dm to hm is incorrect.", expected,  result);
	}
}
