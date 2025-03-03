package MovieTicketBooking;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetApp {

	public static void main(String[] args) {
		try {
			Connection conn = DatabaseConnection.getConnection();
			
			CachedRowSet ct = RowSetProvider.newFactory().createCachedRowSet();
			ct.setCommand("select* from movies");
			ct.execute(conn);

			while(ct.next()) {
				if(ct.getInt("movie_id")==3) {
					ct.updateString("title", "Fighter3");
					ct.updateRow();
				}
			}
			conn=DatabaseConnection.getConnection();
			conn.setAutoCommit(false);
			ct.acceptChanges();
			while(ct.next()) {
				System.out.println("ID: "+ ct.getInt("movie_id")+", title: "+ ct.getString("title"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
