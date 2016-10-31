/**
 * In this class we insert into database:
 * @see insertAccomodation - insert elements to accomodation table
 * @see insertRoom - insert elements to room_fair table
 * @see insertCommon - insert elements into accomodation_fair_relation table
 */
package siit.db.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbInsert {
	int id_acc, id_value, id_common, maxguest, id_acc_com, id_value_com;
	double value;
	String type, bedtype, description, season;
	

	public DbInsert() {
		super();
		this.id_acc = 0;
		this.id_value = 0;
		this.id_common = 0;
		this.maxguest = 0;
		this.id_acc_com = 0;
		this.id_value_com = 0;
		this.value = 0;
		this.type = null;
		this.bedtype = null;
		this.description = null;
		this.season = null;
	}

	public void insertAccomodation(int id, String type, String bedtype, int maxguest, String description) throws SQLException {
		
		DbConnection dbConn = new DbConnection();
		Connection conn = dbConn.connectToDb();

		PreparedStatement preparedStatement = null;

		String querySQL = "INSERT INTO accomodation" + "(ID, TYPE, BED_TYPE, MAX_GUEST, DESCRIPTION) VALUES"
				+ "(?,?,?,?,?)";

		try {

			preparedStatement = conn.prepareStatement(querySQL);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, type);
			preparedStatement.setString(3, bedtype);
			preparedStatement.setInt(4, maxguest);
			preparedStatement.setString(5, description);

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			//System.out.println("Record is inserted into ACCOMODATION table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
		if (conn != null) {
			conn.close();
		}
	}

	public void insertRoom(int id, double value, String season) throws SQLException {
		
		DbConnection dbConn = new DbConnection();
		Connection conn = dbConn.connectToDb();

		PreparedStatement preparedStatement = null;

		String querySQL = "INSERT INTO room_fair" + "(ID, VALUE, SEASON) VALUES"
				+ "(?,?,?)";

		try {

			preparedStatement = conn.prepareStatement(querySQL);
			preparedStatement.setInt(1, id);
			preparedStatement.setDouble(2, value);
			preparedStatement.setString(3, season);

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			//System.out.println("Record is inserted into ROOM_FAIR table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
		if (conn != null) {
			conn.close();
		}
	}
	
	public void insertCommon(int id,int id_acc,int id_value) throws SQLException {
		
		DbConnection dbConn = new DbConnection();
		Connection conn = dbConn.connectToDb();

		PreparedStatement preparedStatement = null;

		String querySQL = "INSERT INTO accomodation_fair_relation" + "(ID, ID_ACCOMODATION, ID_ROOM_FAIR) VALUES"
				+ "(?,?,?)";

		try {

			preparedStatement = conn.prepareStatement(querySQL);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, id_acc);
			preparedStatement.setInt(3, id_value);

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			//System.out.println("Record is inserted into ACCOMODATION_FAIR _RELATION table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
		if (conn != null) {
			conn.close();
		}
	}
}