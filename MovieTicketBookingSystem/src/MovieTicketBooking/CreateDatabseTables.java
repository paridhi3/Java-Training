package MovieTicketBooking;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateDatabseTables {
	
	public static void createTables() {
		Connection conn = DatabaseConnection.getConnection();
		if(conn == null) {
			System.out.println("Database connection failed.");
			return;
		}
		
		try {
			Statement smt = conn.createStatement();
			
			String createMoviesTable = "CREATE TABLE IF NOT EXISTS Movies ("
					                    + "movie_id INT AUTO_INCREMENT PRIMARY KEY, "
					                    + "title VARCHAR(60) NOT NULL, "
					                    + "genre VARCHAR(20), "
					                    + "duration INT NOT NULL)";

			smt.executeUpdate(createMoviesTable);
			System.out.println("Movies table created");
			
			
			String createShowsTable = "CREATE TABLE IF NOT EXISTS Shows ("
					                    + "show_id INT AUTO_INCREMENT PRIMARY KEY, "
					                    + "movie_id INT, "
					                    + "show_time DATETIME NOT NULL, "
					                    + "available_seats INT NOT NULL, "
					                    + "FOREIGN KEY (movie_id) REFERENCES Movies(movie_id))";
										
			smt.executeUpdate(createShowsTable);
			System.out.println("Shows table created");
			
			
			String createBookingsTable = "CREATE TABLE IF NOT EXISTS Bookings ("
					                    + "booking_id INT AUTO_INCREMENT PRIMARY KEY, "
					                    + "username VARCHAR(20) NOT NULL, "
					                    + "show_id INT NOT NULL, "
					                    + "seats_booked INT NOT NULL, "
					                    + "booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
					                    + "FOREIGN KEY (show_id) REFERENCES Shows(show_id))";

					
			smt.executeUpdate(createBookingsTable);
			System.out.println("Bookings table created");
			
			String createUsersTable = "CREATE TABLE IF NOT EXISTS Users ("
                    + "user_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "username VARCHAR(50) NOT NULL, "
                    + "password VARCHAR(50) NOT NULL, "
                    + "isAdmin BOOLEAN NOT NULL);";


			smt.executeUpdate(createUsersTable);
			System.out.println("Users table created");


			smt.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

//	public static void createTables() {
//        Connection conn = DatabaseConnection.getConnection();
//        if (conn == null) {
//            System.out.println("Database connection failed.");
//            return;
//        }
//        
//        try (Scanner sc = new Scanner(System.in);
//             Statement stmt = conn.createStatement()) {
//
//            System.out.print("Enter table name: ");
//            String tableName = sc.nextLine();
//
//            System.out.print("Enter number of columns: ");
//            int columnCount = sc.nextInt();
//            sc.nextLine(); 
//
//            StringBuilder createTableQuery = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
//                .append(tableName)
//                .append(" (");
//
//            for (int i = 0; i < columnCount; i++) {
//                System.out.print("Enter column name for column "+(i+1)+": ");
//                String columnName = sc.nextLine();
//                System.out.print("Enter data type (e.g., INT, VARCHAR(50)): ");
//                String dataType = sc.nextLine();
//                
//                createTableQuery.append(columnName)
//                    .append(" ")
//                    .append(dataType);
//                
//                if (i < columnCount - 1) {
//                    createTableQuery.append(", ");
//                }
//            }
//            
//            createTableQuery.append(");");
//            
//            System.out.println(createTableQuery);
//
//            stmt.executeUpdate(createTableQuery.toString());
//            System.out.println("Table " + tableName + " created successfully.");
//            
//        } catch(SQLException e) {
//        	e.printStackTrace();
//        	}
//    }
	
	
	public static void main(String[] args) {
//		createTables();
	}

}
