package test.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import unitTests.Distance;
import unitTests.MetricDistanceCalculator;
import unitTests.MetricDistanceConverter;
import unitTests.MetricDistanceExpressionParser;
import unitTests.UnknownDistanceFormatException;

public class DistanceCalculatorTest {
		
		@Test
		public void simpleExpressionIsCalculated() throws UnknownDistanceFormatException{
			// given
			MetricDistanceExpressionParser mockParser = new MetricDistanceExpressionParser(){
				@Override
				public Distance[] parse(String expression) throws UnknownDistanceFormatException {
					return new Distance[]{new Distance(Distance.DECIMETERS, 1520), new Distance(Distance.HECTOMETERS, 10)};
				}	
			};
			
			MetricDistanceConverter mockConverter = new MetricDistanceConverter(){
				@Override
				public Distance convert(Distance distance, String toFormat) throws UnknownDistanceFormatException {
					if(distance.getFormatName().equals(Distance.DECIMETERS)){
						return new Distance(Distance.HECTOMETERS, 1.52);
					} else {
						return distance;
					}
				}
			};
			MetricDistanceCalculator calc = new MetricDistanceCalculator(mockParser, mockConverter);
			
			// when
			Distance actual = calc.computeDistance("1000dm+10hm", Distance.HECTOMETERS);
			
			// then
			Distance expected = new Distance(Distance.HECTOMETERS, 11.52);
			assertEquals(expected, actual);
		}
	}


