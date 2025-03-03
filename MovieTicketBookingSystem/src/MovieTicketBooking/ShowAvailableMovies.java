package MovieTicketBooking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class ShowAvailableMovies {
	
	public static void displayAll() {
		
		Connection conn = DatabaseConnection.getConnection();
		if(conn == null) {
			System.out.println("Database connection failed.");
			return;
		}
		
		String query = "SELECT"
						+" movies.movie_id,"
						+" movies.title,"
						+" movies.genre,"
						+" movies.duration,"
						+" shows.show_id,"
						+" shows.show_time,"
						+" shows.available_seats"
						+" FROM"
						+" movies"
						+" INNER JOIN"
						+" shows ON movies.movie_id = shows.movie_id;";
		
		try(Statement smt = conn.createStatement()) {
			ResultSet rs = smt.executeQuery(query);
			while(rs.next()) {
				int movieID = rs.getInt("movie_id");
				String title = rs.getString("title");
				String genre = rs.getString("genre");
				int duration = rs.getInt("duration");
				int showID = rs.getInt("show_id");
				LocalDateTime showTime = rs.getTimestamp("show_time").toLocalDateTime(); 
				int availableSeats = rs.getInt("available_seats");
				
				System.out.printf(
	                    "Movie ID: %d | Title: %s | Genre: %s | Duration: %d mins | Show ID: %d | Show Time: %s | Available Seats: %d%n",
	                    movieID,
	                    title,
	                    genre,
	                    duration,
	                    showID,
	                    showTime.toString(),
	                    availableSeats
	                );
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
