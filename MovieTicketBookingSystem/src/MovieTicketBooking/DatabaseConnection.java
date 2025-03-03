package MovieTicketBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "";
	private static final String USER = "";
	private static final String PASSWORD = "";
	
	private static Connection connection; // returns connection object
	
	public static Connection getConnection() {
		if(connection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); //registering driver
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("Databse connected successfully!");
			} 
			catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	public static void main(String[] args) {
		getConnection();
	}
}
