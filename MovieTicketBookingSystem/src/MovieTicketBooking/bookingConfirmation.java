package MovieTicketBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class bookingConfirmation {
	public static void confirmBooking() {
		
		Connection conn = DatabaseConnection.getConnection();
		if(conn == null) {
			System.out.println("Database connection failed.");
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your username: ");
        String username = sc.next();
		
		String query1 = "SELECT"
				+ " b.username,"
				+ " b.booking_id,"
				+ " m.title,"
				+ " s.show_time,"
				+ " b.seats_booked"
				+ " FROM"
				+ " bookings AS b"
				+ " JOIN"
				+ " shows AS s ON b.show_id = s.show_id"
				+ " JOIN"
				+ " movies AS m ON s.movie_id = m.movie_id WHERE b.username = ?";
		
		try (PreparedStatement psmt = conn.prepareStatement(query1)) {
			psmt.setString(1, username);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				String username1 = rs.getString("username");
				int bookingID = rs.getInt("booking_id");
				String title = rs.getString("title");
				LocalDateTime showTime = rs.getTimestamp("show_time").toLocalDateTime();
				int seats_booked = rs.getInt("seats_booked");
				
				System.out.printf(
	                    "Username: %s | Booking ID: %d | Title: %s | Show Time: %s | Seats Booked: %d%n",
	                    username1,
	                    bookingID,
	                    title,
	                    showTime.toString(),
	                    seats_booked
	                );
			}
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}


