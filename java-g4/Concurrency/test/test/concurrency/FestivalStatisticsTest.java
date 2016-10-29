package test.concurrency;

import org.junit.Assert;
import org.junit.Test;

import concurrency.TicketType;

public class FestivalStatisticsTest {

	@Test
	public void testRandom() {
		int expected = 1, actual = 0;
		TicketType ticket = TicketType.getRandom();
		if (ticket.ordinal() != 0) {
			actual = 1;
		}
		Assert.assertEquals(expected, actual);
	}
}
