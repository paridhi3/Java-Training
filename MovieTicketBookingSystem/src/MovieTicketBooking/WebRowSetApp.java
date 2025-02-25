package MovieTicketBooking;

import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;

import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowSetApp {

	public static void main(String[] args) {
		
		try {
			Connection conn = DatabaseConnection.getConnection();
			
			WebRowSet wrs = RowSetProvider.newFactory().createWebRowSet();
			wrs.setCommand("select * from movies");
			wrs.execute(conn);
			conn.close();
			System.out.println("Connection closed");
			
			FileWriter writer = new FileWriter("movies.xml");
			wrs.writeXml(writer);
			writer.close();
			
			WebRowSet wrs2 = RowSetProvider.newFactory().createWebRowSet();
			FileReader reader = new FileReader("movies.xml");
			wrs2.readXml(reader);
			reader.close();
			
			while(wrs2.next()) {
				System.out.println("ID: "+wrs2.getInt("movie_id")+", Title: "+wrs2.getString("title"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
