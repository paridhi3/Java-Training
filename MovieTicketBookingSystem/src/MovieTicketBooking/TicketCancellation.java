package MovieTicketBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TicketCancellation {
	public static void cancelTicket() {
		
		Connection conn = DatabaseConnection.getConnection();
		if(conn == null) {
			System.out.println("Database connection failed.");
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your username: ");
        String username = sc.next();
		
		String query1 = "select seats_booked, show_id from bookings where username=?";
		
		try (PreparedStatement psmt = conn.prepareStatement(query1)) {
			psmt.setString(1, username);
			ResultSet rs = psmt.executeQuery();
			
			if (rs.next()) {
				int seatsBooked = rs.getInt("seats_booked");
                int showId = rs.getInt("show_id");

                String query2 = "SELECT available_seats FROM shows WHERE show_id=?";
                
                try (PreparedStatement psmt2 = conn.prepareStatement(query2)) {
                    psmt2.setInt(1, showId);
                    ResultSet rs2 = psmt2.executeQuery();
                    
                    if(rs2.next()){
                        int availableSeats = rs2.getInt("available_seats");
                        
                        String updateQuery="UPDATE shows SET available_seats=? WHERE show_id=?";
                        
                        try(PreparedStatement psmt3 = conn.prepareStatement(updateQuery)){
                            psmt3.setInt(1, availableSeats+seatsBooked);
                            psmt3.setInt(2, showId);
                            psmt3.executeUpdate();
                            
                            String deleteQuery = "Delete from bookings where username=?";
                            try(PreparedStatement psmt4 = conn.prepareStatement(deleteQuery)){
                                psmt4.setString(1, username);
                                psmt4.executeUpdate();
                                System.out.println("Booking canceled successfully!");
                                
                            }catch(SQLException e){
                                e.printStackTrace();
                            }
                            
                        }catch(SQLException e){
                            e.printStackTrace();
                        }
                        
                    }
                    
                } catch (SQLException e) {
                    e.printStackTrace();
                }
               }
			else {
				System.out.println("You have not booked any tickets");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
