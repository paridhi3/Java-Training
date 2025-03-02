package MovieTicketBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserRegistration {

    public static void register() {
    	
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
        System.out.print("Are you admin? (true/false): ");
        boolean isAdmin = sc.nextBoolean();

        try {
            String query = "INSERT INTO users (username, password, isAdmin) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.setBoolean(3, isAdmin);
                pstmt.executeUpdate();
                System.out.println("--------------------------------------------------------------------");
                System.out.println("User registered successfully.");
                System.out.println("--------------------------------------------------------------------");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
