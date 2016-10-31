/**
 * This class is responsible for the connection to the database server
 */
package siit.db.booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	String name, username, password;

	public DbConnection() {
		super();
		this.name = null;
		this.username = null;
		this.password = null;
	}
	
	public Connection connectToDb(){
		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = connect("postgresql", "localhost", 5432, "Booking", "postgres", "123456");
		if (conn != null)
		{
			//System.out.println("Connected!");
			return conn;
		}
		else
		{
			//System.out.println("Not connected!");
			return null;
		}
	}
	
	private Connection connect(String type, String host, int port, String dbName, String user, String pw) {

		Connection conn = null;
		DriverManager.setLoginTimeout(60);
		try {
			String url = new StringBuilder().append("jdbc:").append(type).append("://").append(host).append(":")
					.append(port).append("/").append(dbName).append("?user=").append(user).append("&password=")
					.append(pw).toString();

			//System.out.println("URL:" + url);
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.err.println("Cannot connect to the database: " + e.getMessage());
		}

		return conn;
	}

}
