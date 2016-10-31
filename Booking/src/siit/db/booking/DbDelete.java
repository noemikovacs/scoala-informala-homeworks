/**
 * In this class we deletes inserted elements
 * @see deleteAcc deletes element with specified id from accomodation table
 * @see deleteRoomFair deletes element with specified id from room_fair table
 * @see deleteCommon deletes element with specified id from accomodation_fair_relation table
 */
package siit.db.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbDelete {
	int id;

	public DbDelete() {
		super();
		this.id = 0;
	}

	public void deleteAcc(int id) throws SQLException {
		this.id = id;
		DbConnection dbConn = new DbConnection();
		Connection conn = dbConn.connectToDb();
		if (conn == null)
			return;
		// final String format = "%10s%20s%30s\n";
		String sqlDelete = "DELETE FROM public.accomodation WHERE id = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sqlDelete);
			ps.setInt(1, this.id);
			//System.out.println("The element is deleted.");

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteRoomFair(int id) throws SQLException {
		this.id = id;
		DbConnection dbConn = new DbConnection();
		Connection conn = dbConn.connectToDb();
		if (conn == null)
			return;
		// final String format = "%10s%20s%30s\n";
		String sqlDelete = "DELETE FROM public.room_fair WHERE id = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sqlDelete);
			ps.setInt(1, this.id);
			//System.out.println("The element is deleted.");

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCommon(int id) throws SQLException {
		this.id = id;
		DbConnection dbConn = new DbConnection();
		Connection conn = dbConn.connectToDb();
		if (conn == null)
			return;
		// final String format = "%10s%20s%30s\n";
		String sqlDelete = "DELETE FROM public.accomodation_fair_relation WHERE id = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sqlDelete);
			ps.setInt(1, this.id);
			//System.out.println("The element is deleted.");

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
