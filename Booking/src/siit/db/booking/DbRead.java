/**
 * In this class we read all the elements from the database
 * We used the following methods:
 * @see getRoomType - gets the type of the room and @return all the rooms with that type
 * @see getJoin - prints to the console all rooms with their prices according to the accomodation_fair_relation
 * The functions with 'Test endings are for testing purposes and returns values for the actual JUnit test
 */
package siit.db.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DbRead {
	String type;

	public DbRead() {
		super();
		this.type = null;
	}

	public void getRoomType(String type) throws SQLException {
		this.type = type;
		DbConnection dbConn = new DbConnection();
		Connection conn = dbConn.connectToDb();
		if (conn == null)
			return;
		// final String format = "%10s%20s%30s\n";
		String sqlQuery = "SELECT * FROM public.accomodation WHERE type = ?";
		try (PreparedStatement ps = conn.prepareStatement(sqlQuery);) {
			ps.setString(1, this.type);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs == null) {
					System.out.println("No result");

				} else {
					System.out.println("View type:");
					while (rs.next()) {
						System.out.format("id: ");
						System.out.format(rs.getString("id") + " ");
						System.out.format("type: ");
						System.out.format(rs.getString("type"));
						System.out.println();
					}
				}
			}
		} catch (SQLException e) {
			System.err.println("Cannot view type: " + e.getMessage());
		}
	}

	public void getJoin() throws SQLException {

		DbConnection dbConn = new DbConnection();
		Connection conn = dbConn.connectToDb();
		if (conn == null)
			return;
		// final String format = "%10s%20s%30s\n";
		String sqlQuery = "SELECT * FROM accomodation " + "JOIN accomodation_fair_relation "
				+ "ON accomodation_fair_relation.id_accomodation = accomodation.id " + "JOIN room_fair "
				+ "ON room_fair.id = accomodation_fair_relation.id_room_fair";

		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sqlQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet rs = ps.executeQuery();
		if (rs == null) {
			System.out.println("No result");

		} else {
			System.out.println("View type:");
			while (rs.next()) {
				System.out.println("Room:" + rs.getString("type") + " Price: " + rs.getString("value") + " Season:"
						+ rs.getString("season"));
			}
		}
	}

	public String getRoomTest(int id) throws SQLException {
		String actual_type = null;
		DbConnection dbConn = new DbConnection();
		Connection conn = dbConn.connectToDb();
		if (conn == null)
			return null;
		// final String format = "%10s%20s%30s\n";
		String sqlQuery = "SELECT * FROM public.accomodation WHERE id = ?";
		try (PreparedStatement ps = conn.prepareStatement(sqlQuery);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					actual_type = rs.getString("type");
				}
			}
		} catch (SQLException e) {
			System.err.println("Cannot view type: " + e.getMessage());
		}
		return actual_type;
	}

	public LinkedList<Double> getJoinTest() throws SQLException {

		LinkedList<Double> l = new LinkedList<>();
		DbConnection dbConn = new DbConnection();
		Connection conn = dbConn.connectToDb();
		if (conn == null)
			return null;
		// final String format = "%10s%20s%30s\n";
		String sqlQuery = "SELECT * FROM accomodation " + "JOIN accomodation_fair_relation "
				+ "ON accomodation_fair_relation.id_accomodation = accomodation.id " + "JOIN room_fair "
				+ "ON room_fair.id = accomodation_fair_relation.id_room_fair";

		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sqlQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			l.add(rs.getDouble("value"));
			System.out.println("Room:" + rs.getString("type") + " Price: " + rs.getString("value") + " Season:"
					+ rs.getString("season"));

		}
		return l;
	}
}
