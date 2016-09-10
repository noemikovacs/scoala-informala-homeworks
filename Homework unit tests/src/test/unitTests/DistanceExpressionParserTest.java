package test.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import unitTests.Distance;
import unitTests.MetricDistanceExpressionParser;
import unitTests.UnknownDistanceFormatException;

public class DistanceExpressionParserTest {

		@Test
		public void nextOperatorTest1() {
			// given
			MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
			String s = "123-";
			
			// when
			int opPos = parser.nextOperatorPos(s);
			
			//then
			assertEquals(3, opPos);
		}

		@Test
		public void nextOpPosNotFound() {
			MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
			String s = "123";
			assertEquals(-1, parser.nextOperatorPos(s));
		}

		@Test
		public void nextOperatorTestCorrectWithMultipleOps() {
			MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
			String s = "123-+-";
			assertEquals(3, parser.nextOperatorPos(s));
		}

		@Test
		public void nextOperatorTestWithJustOp() {
			MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
			String s = "+";
			assertEquals(0, parser.nextOperatorPos(s));
		}

		@Test
		public void correctFormatIsParsed() throws UnknownDistanceFormatException {
			MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
			String s = "1m+5m";
			Distance[] expected = new Distance[] { new Distance(Distance.METERS, 1), new Distance(Distance.METERS, 5) };
			Distance[] actual = parser.parse(s);
			assertArrayEquals(expected, actual);
		}

		@Test
		public void correctFormatWithMinusIsParsed() throws UnknownDistanceFormatException {
			MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
			String s = "6m-5m";
			Distance[] expected = new Distance[] { new Distance(Distance.METERS, 6), new Distance(Distance.METERS, -5) };
			Distance[] actual = parser.parse(s);
			assertArrayEquals(expected, actual);
		}

		@Test
		public void correctFormatIsParsed2() throws UnknownDistanceFormatException {
			MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
			String s = "5m-7m";
			Distance[] expected = new Distance[] { new Distance(Distance.METERS, 5), new Distance(Distance.METERS, -7) };
			Distance[] actual = parser.parse(s);
			assertArrayEquals(expected, actual);
		}

		@Test
		public void correctFormatWithMultipleOpsAndNegativeSignAtStartIsParsed() throws UnknownDistanceFormatException {
			MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
			String s = "5m-7m +12m";
			Distance[] expected = new Distance[] { new Distance(Distance.METERS, 5), new Distance(Distance.METERS, -7), new Distance(Distance.METERS, 12) };
			Distance[] actual = parser.parse(s);
			assertArrayEquals(expected, actual);
		}

		
		@Test(expected=UnknownDistanceFormatException.class)
		public void parsingFailsWithInvalidWeightFormat() throws UnknownDistanceFormatException {
			MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
			String s = "-1m+5ft-3a";
			parser.parse(s);
		}	
	
	
}
