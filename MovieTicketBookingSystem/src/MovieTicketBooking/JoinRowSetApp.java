package MovieTicketBooking;
 
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetProvider;
 
public class JoinRowSetApp {
 
	public static void main(String[] args) {
		try {
			Connection conn = DatabaseConnection.getConnection();
			
	        CachedRowSet movies = RowSetProvider.newFactory().createCachedRowSet();
            CachedRowSet shows = RowSetProvider.newFactory().createCachedRowSet();
            
            movies.setCommand("select * from movies");
            shows.setCommand("select * from shows");
            
            movies.execute(conn);
            shows.execute(conn);
            
            conn.close();
            
            JoinRowSet jrs = RowSetProvider.newFactory().createJoinRowSet();
            movies.setMatchColumn("movie_id");
            shows.setMatchColumn("movie_id");
            
            jrs.addRowSet(movies);
            jrs.addRowSet(shows);
            
            while(jrs.next())
            {
				System.out.println("Id: "+jrs.getInt("movie_id")+", Title: "
								  +jrs.getString("title")+", Genre: "+jrs.getString("genre")
								  +", Duration: "+jrs.getInt("duration")+", Show ID: "
								  +jrs.getInt("show_id")+", Show time: "+jrs.getString("show_time"));
 
            }
 
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 
}