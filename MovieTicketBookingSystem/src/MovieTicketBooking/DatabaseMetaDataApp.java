package MovieTicketBooking;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMetaDataApp {
    public static void main(String[] args) {
        
        try {
        	Connection conn = DatabaseConnection.getConnection();
        	
            DatabaseMetaData dbm = conn.getMetaData();

            System.out.println("Database Product Name: " + dbm.getDatabaseProductName());
            System.out.println("Database Product Version: " + dbm.getDatabaseProductVersion());
            System.out.println("Database Driver Name: " + dbm.getDriverName());
            System.out.println("Database Driver Version: " + dbm.getDriverVersion());
            System.out.println("Database URL: " + dbm.getURL());
			System.out.println("Database Username: " + dbm.getUserName());
            System.out.println("-----------------------------------------------------------------------------------------");
            
            ResultSet rs = dbm.getTables("movie_booking", null, "%", new String[] {"TABLE"});
            
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                String type = rs.getString("TABLE_TYPE");
                System.out.println("Table Name: " + tableName + ", Type: " + type);
            }
            
         // Retrieve columns of the "shows" table
            ResultSet rs2 = dbm.getColumns("movie_booking", null, "shows", "%");
            System.out.println("\nColumns in the 'shows' table:");
            while (rs2.next()) {
                System.out.println("Column Name: " + rs2.getString("COLUMN_NAME"));
                System.out.println("Column Type: " + rs2.getString("TYPE_NAME"));
                System.out.println("-----------------------------------------------------------------------------------------");
            }
            
         // Check support for transactions
            System.out.println("Supports Transactions: " + dbm.supportsTransactions());
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

