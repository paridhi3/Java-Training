package MovieTicketBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InsertData {
	
	public static void insertMovies() {
		
		Connection conn = DatabaseConnection.getConnection();
		if(conn == null) {
			System.out.println("Database connection failed.");
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter movie title: ");
        String title = sc.next();
		System.out.println("Enter movie genre:");
		String genre = sc.next();
		System.out.println("Enter movie duration: ");
		int duration = sc.nextInt();
		
		String insertMoviesSQL = "INSERT INTO movies (title, genre, duration) values (?,?,?)";
		
		try (PreparedStatement psmt = conn.prepareStatement(insertMoviesSQL)) {
			
			psmt.setString(1, title);
			psmt.setString(2, genre);
			psmt.setInt(3, duration);
			psmt.executeUpdate();
			
			System.out.println("Movies inserted successfully");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	
	public static void insertShows() {
		
		Connection conn = DatabaseConnection.getConnection();
		if(conn == null) {
			System.out.println("Database connection failed.");
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter movie ID: ");
        int movie_id = sc.nextInt();
        
        System.out.println("Enter Show Date and Time (YYYY-MM-DD HH:MM): ");
        String showDateTime = sc.nextLine();
        Timestamp showTimestamp = Timestamp.valueOf(LocalDateTime.parse(showDateTime.replace(" ", "T")));
        
		System.out.println("Enter number of available seats: ");
		int available_seats = sc.nextInt();
		
		String insertShowsSQL = "INSERT INTO shows (movie_id, show_time, available_seats) values (?,?,?)";
		
		try (PreparedStatement psmt = conn.prepareStatement(insertShowsSQL)) {
			psmt.setInt(1, movie_id);
			psmt.setTimestamp(2, showTimestamp);
			psmt.setInt(3, available_seats);
			psmt.executeUpdate();
			
			System.out.println("Show inserted successfully");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public static void main(String[] args) {
//		insertMovies();
		insertShows();
	}

}
