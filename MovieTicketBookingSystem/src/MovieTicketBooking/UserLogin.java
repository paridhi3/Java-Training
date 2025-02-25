package MovieTicketBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserLogin {
	
	public static void login() {
		
		Connection conn = DatabaseConnection.getConnection();
		if(conn == null) {
			System.out.println("Database connection failed.");
			return;
		}
		
	    Scanner sc = new Scanner(System.in);

	    System.out.print("Enter username: ");
	    String username = sc.next();
	    System.out.print("Enter password: ");
	    String password = sc.next();

	    String query = "SELECT * FROM users WHERE username = ? AND password = ?";
	    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	    	
	        pstmt.setString(1, username);
	        pstmt.setString(2, password);
	        ResultSet rs = pstmt.executeQuery();
	        
	        if (rs.next()) {
	        	
	        	boolean isAdmin = rs.getBoolean("isAdmin");
	        	System.out.println("--------------------------------------------------------------------");
	            System.out.println("Login successful. Welcome " + username + "!");
	            System.out.println("--------------------------------------------------------------------");
	            
	            if (isAdmin) {
	                Menu.adminMenu();
	            } else {
	                Menu.userMenu();
	            }
	            
	        } else {
	           System.out.println("Invalid username or password.");
	        }
	        return;
	    }
	    catch(SQLException e) {
	    	e.printStackTrace();
	    }
	} // end of fn
	
} // end of class

