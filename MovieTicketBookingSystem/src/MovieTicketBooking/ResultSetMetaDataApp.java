package MovieTicketBooking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataApp {
	
    public static void main(String[] args) {

        try(Connection conn = DatabaseConnection.getConnection();
        	Statement stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery("SELECT * FROM shows")
        	) {

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            System.out.println("Number of columns: " + columnCount);

            for (int i = 1; i <= columnCount; i++) {
            	System.out.println("--------------------------------------------------------------");
                System.out.println("For Column " + i + ":");
                System.out.println("  Name: " + rsmd.getColumnName(i));
                System.out.println("  Type: " + rsmd.getColumnTypeName(i));
                System.out.println("  Display Size: " + rsmd.getColumnDisplaySize(i));
                System.out.println("  Column class: " + rsmd.getColumnClassName(i));
                System.out.println("  Is Nullable: " + rsmd.isNullable(i));
                System.out.println("  Is auto increment: " + rsmd.isAutoIncrement(i));
                System.out.println("  Get precision: " + rsmd.getPrecision(i));
                System.out.println("  Table name: " + rsmd.getTableName(i));
                System.out.println("  Schema name: " + rsmd.getSchemaName(i));
                System.out.println("--------------------------------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
}

