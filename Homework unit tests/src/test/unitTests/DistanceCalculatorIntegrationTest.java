package test.unitTests;

import org.junit.Assert;
import org.junit.Test;


import unitTests.Distance;
import unitTests.MetricDistanceCalculator;
import unitTests.UnknownDistanceFormatException;

public class DistanceCalculatorIntegrationTest {

	@Test
	public void distanceCalculatorWorksWithCorrectInput() throws UnknownDistanceFormatException {
		// given
		String s = "500m-1dm";
		MetricDistanceCalculator calc = new MetricDistanceCalculator();
		// when
		Distance result = calc.computeDistance(s, Distance.METERS);
		// then
		Distance expected = new Distance(Distance.METERS, 499.9);
		Assert.assertEquals(expected, result);		
	}

	}


