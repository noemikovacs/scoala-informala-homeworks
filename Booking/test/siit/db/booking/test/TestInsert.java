package siit.db.booking.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.LinkedList;

import org.junit.Test;

import siit.db.booking.DbDelete;
import siit.db.booking.DbInsert;
import siit.db.booking.DbRead;

public class TestInsert {

	@Test
	public void testInsert() throws SQLException{
		String expected = "double";
		
		DbInsert insert = new DbInsert();
		insert.insertAccomodation(1, expected, "double", 2, "sea view");
		
		DbRead read = new DbRead();
		String actual = read.getRoomTest(1);
		
		DbDelete delete = new DbDelete();
		delete.deleteAcc(1);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testJoin() throws SQLException{
		LinkedList<Double> expected = new LinkedList<>();
		LinkedList<Double> actual = new LinkedList<>();
		expected.add((double) 50);
		expected.add(20.5);
		DbInsert insert = new DbInsert();
		insert.insertAccomodation(1, "double", "double", 2, "sea view");
		insert.insertAccomodation(2, "double", "2x single", 2, "mountain view");
		insert.insertAccomodation(3, "single", "single", 1, "front view");
		insert.insertAccomodation(4, "triple", "double + single", 3, "garden view");
		insert.insertAccomodation(5, "double", "double", 2, "sea view");
		insert.insertRoom(1, 50, "summer");
		insert.insertRoom(2, 20.5, "winter");
		insert.insertRoom(3, 20.7, "autumn");	
		insert.insertCommon(1, 5, 1);
		insert.insertCommon(2, 4, 2);
			
		DbRead read = new DbRead();
		actual = read.getJoinTest();
		
		DbDelete delete = new DbDelete();
		delete.deleteAcc(1);
		delete.deleteAcc(2);
		delete.deleteAcc(3);
		delete.deleteAcc(4);
		delete.deleteAcc(5);
		
		delete.deleteCommon(1);
		delete.deleteCommon(2);
		
		delete.deleteRoomFair(1);
		delete.deleteRoomFair(2);
		delete.deleteRoomFair(3);
		assertTrue(expected.equals(actual));
	}

}
