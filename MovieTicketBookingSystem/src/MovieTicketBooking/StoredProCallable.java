package MovieTicketBooking;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StoredProCallable {
	
	
	public static void proCall() {
		Connection conn = DatabaseConnection.getConnection();
		if(conn==null) {
			System.out.println("Database Connection Failed.");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your movie Id: ");
        int movieId = sc.nextInt();
		try {
			String procedure = "CREATE PROCEDURE GetMovieTitle(IN movieId INT, OUT movietitle VARCHAR(255), OUT movieGenre VARCHAR(255)) "
                    + "BEGIN "
                    + "SELECT title, genre INTO movietitle, movieGenre FROM movies "
                    + "WHERE movie_id = movieId; "
                    + "END;";
		   Statement stmt = conn.createStatement();
		   stmt.execute(procedure);
		   System.out.println("Stored procedure created successfully.");
		}
		catch(SQLException e) {
		       e.printStackTrace();
		       }
	}
 
	
	
	public static void fetchBookings() {
			Connection conn = DatabaseConnection.getConnection();
			if(conn==null) {
				System.out.println("Database Connection Failed.");
				return;
			}
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter your username: ");
	        String username = sc.next();
			try {
				String procedure = "CREATE PROCEDURE GetBookings(IN username VARCHAR(20)) "
	                    + "BEGIN "
	                    + "SELECT * FROM bookings WHERE bookings.user_name=username; "
	                    + "END;";
			   Statement stmt = conn.createStatement();
			   stmt.execute(procedure);
			   System.out.println("Stored procedure GetBookings created successfully.");
			}
			catch(SQLException e) {
			       e.printStackTrace();
			}
		}
	
	
	
	
	   public static void cancelTicket() {
	        Connection conn = DatabaseConnection.getConnection();
	        if (conn == null) {
	            System.out.println("Database Connection Failed.");
	            return;
	        }
	        Scanner sc = new Scanner(System.in);
	        try {
	        	
	            String procedure = "CREATE PROCEDURE CancelBooking9(IN username VARCHAR(20), IN bookingID INT) "
	            		+ "BEGIN "
	                    + " DECLARE booked_seats INT; "
	                    + " DECLARE show_id INT; "
	                    + " SELECT seats_booked, show_id INTO booked_seats, show_id FROM bookings "
	                    + " WHERE booking_id = booking_id; "
	                    + " UPDATE shows SET available_seats = available_seats + booked_seats WHERE show_id = show_id; "
	                    + " DELETE FROM bookings WHERE booking_id = booking_id; "
	                    + "END;";
	            
	            Statement stmt = conn.createStatement();
	            stmt.execute(procedure);
	            System.out.println("Stored procedure CancelBooking9 created successfully.");
	        }
	        catch(SQLException e) {
	            e.printStackTrace();
	        }
	   }

 
	public static void main(String[] args) throws SQLException {
//        proCall();
//        fetchBookings();
		cancelTicket();
    }
}