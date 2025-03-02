package MovieTicketBooking;
 
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
 
public class TestStoredProcedure {
    public static void main(String[] args) {
//        Connection conn = null;
//        CallableStatement cstmt = null;
//        try {
//            conn = DatabaseConnection.getConnection();
//            if (conn == null) {
//                System.out.println("Database Connection Failed");
//                return;
//            }
// 
//            cstmt = conn.prepareCall("{CALL GetMovieTitle(?, ?, ?)}");
// 
//            System.out.print("Enter your movie Id: ");
//            Scanner sc = new Scanner(System.in);
//            int movieId = sc.nextInt();
//            cstmt.setInt(1, movieId);
// 
//            cstmt.registerOutParameter(2, Types.VARCHAR);
//            cstmt.registerOutParameter(3, Types.VARCHAR);
//
//            cstmt.execute();
// 
//            String title = cstmt.getString(2);
//            String genre = cstmt.getString(3);
//            System.out.println("Movie Title: " + title);
//            System.out.println("Movie Genre: " + genre);
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    	
//    	Connection conn = null;
//        CallableStatement cstmt = null;
//        try {
//            conn = DatabaseConnection.getConnection();
//            if (conn == null) {
//                System.out.println("Database Connection Failed");
//                return;
//            }
// 
//            cstmt = conn.prepareCall("{CALL GetBookings(?)}");
// 
//            System.out.print("Enter your username: ");
//            Scanner sc = new Scanner(System.in);
//            String username = sc.next();
//            cstmt.setString(1, username);
//
//            ResultSet rs = cstmt.executeQuery();
// 
//            while(rs.next()) {
//            	int bookingID = rs.getInt("booking_id");
//				String username1 = rs.getString("username");
//				int showID = rs.getInt("show_id");
//				int seats_booked = rs.getInt("seats_booked");
//				LocalDateTime booking_date = rs.getTimestamp("booking_date").toLocalDateTime(); 
//				
//				System.out.printf(
//	                    "Booking ID: %d | Username: %s | Show ID: %s | Seats booked: %d mins | Booking date: %s%n",
//	                    bookingID,
//	                    username1,
//	                    showID,
//	                    seats_booked,
//	                    booking_date.toString()
//	                );
//            }
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    	
    	Connection conn = null;
    	Scanner sc = new Scanner(System.in);
        CallableStatement cstmt = null;
        conn = DatabaseConnection.getConnection();
		if (conn == null) {
		    System.out.println("Database Connection Failed");
		    return;
		}
		
		System.out.print("Enter your username: ");
		String username = sc.next();
		
		String query = "SELECT booking_id FROM bookings WHERE username=?";
		try (PreparedStatement psmt = conn.prepareStatement(query)) {
			psmt.setString(1, username);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				int bookingID = rs.getInt("booking_id");
				System.out.println("Booking ID=" +bookingID);
			}
			System.out.println("Which booking id do you want to cancel? Choose from above: ");
			int booking_id = sc.nextInt();
			
			cstmt = conn.prepareCall("{CALL CancelBooking9(?, ?)}");
			cstmt.setString(1, username);
			cstmt.setInt(2, booking_id);
			
		    cstmt.executeQuery();
    
		    System.out.println("Booking cancelled for "+username);
			
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    	
    }
}