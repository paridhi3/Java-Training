package MovieTicketBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TicketBooking {
	
	public static void bookTicket() {
		
		Connection conn = DatabaseConnection.getConnection();
		if(conn == null) {
			System.out.println("Database connection failed.");
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your username: ");
        String username = sc.next();
		System.out.println("Select the movie and show from below:");
		ShowAvailableMovies.displayAll();
		System.out.println("Enter show id: ");
		int showID = sc.nextInt();
		
		String query1 = "select available_seats from shows where show_id=?";
		String query2 = "insert into bookings (username, show_id, seats_booked) values (?,?,?)";
		
		try (PreparedStatement psmt = conn.prepareStatement(query1)) {
			psmt.setInt(1, showID);
			
			ResultSet rs = psmt.executeQuery();
			
			int availableSeats = 0;
			if (rs.next()) {
                availableSeats = rs.getInt("available_seats");
                System.out.println("Number of available seats: " + availableSeats);
            } else {
                System.out.println("Show ID not found.");
            }
			
			System.out.println("Enter number of seats to book:");
			int noOfSeats = sc.nextInt();
			if(noOfSeats <= availableSeats) {
				try (PreparedStatement psmt2 = conn.prepareStatement(query2)) {
                    psmt2.setString(1, username);
                    psmt2.setInt(2, showID);
                    psmt2.setInt(3, noOfSeats);
                    
                    psmt2.executeUpdate();

                    String updateQuery = "UPDATE shows SET available_seats=? WHERE show_id=?";
                    try (PreparedStatement updatePsmt = conn.prepareStatement(updateQuery)) {
                         updatePsmt.setInt(1, availableSeats - noOfSeats);
                         updatePsmt.setInt(2, showID);
                         updatePsmt.executeUpdate();
                         System.out.println("Booking successful!");
                    }
                    catch(SQLException e) {
      					e.printStackTrace();
       				}

				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
	
	

