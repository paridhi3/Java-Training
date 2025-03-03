package MovieTicketBooking;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetApp {
	
	public static void main(String[] args) {
		try {
			Connection conn = DatabaseConnection.getConnection();
			
			JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
			rowSet.setUrl("jdbc:mysql://localhost:3306/movie_booking");
			rowSet.setUsername("root");
			rowSet.setPassword("Genpact@123456789");
 
			rowSet.setCommand("Select * from movies");
			rowSet.execute();
			
//			System.out.println("------------");
//			System.out.println(rowSet);
//			System.out.println(rowSet.next());
//			System.out.println(rowSet.previous());
//			System.out.println("------------");
			
			while(rowSet.next()) {
				System.out.println("ID: "+rowSet.getInt("movie_id"));
			}
			while(rowSet.previous()) {
				System.out.println("ID: "+rowSet.getInt("movie_id"));
			}
 
			rowSet.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}