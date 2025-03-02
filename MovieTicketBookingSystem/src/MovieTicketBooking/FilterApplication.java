package MovieTicketBooking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetProvider;

public class FilterApplication {

	public static void main(String[] args) {
		
		try (Connection conn = DatabaseConnection.getConnection();
			 Statement smt = conn.createStatement();
			 ResultSet rs = smt.executeQuery("Select * from shows");
			) {
			
			FilteredRowSet frs = RowSetProvider.newFactory().createFilteredRowSet();
			frs.populate(rs);
			
			frs.setFilter(new AvailableShowsSeatsFilter(50));
			
			while(frs.next()) {
				System.out.println("Show ID: "+frs.getInt("show_id")+", Available seats: "+frs.getInt("available_seats"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
