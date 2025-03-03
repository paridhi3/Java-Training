package HMSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
	
	private static boolean isPatientRegistered(int patientId) {
        String query = "SELECT id FROM Patient WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {
            psmt.setInt(1, patientId);
            ResultSet rs = psmt.executeQuery();
            System.out.println(rs);
            if (rs.next() && rs.getInt(1)>0) {             
            	return true;  // Patient exists      
            }
//            } else {             
//            	return false; // Patient not found }
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
 
    private static boolean isDoctorRegistered(int doctorId) {
        String query = "SELECT id FROM Doctor WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {
            psmt.setInt(1, doctorId);
            ResultSet rs = psmt.executeQuery();
            System.out.println(rs);
            if (rs.next() && rs.getInt(1)>0) {             
            	return true;  // Patient exists  
            }
//            } else {             
//            	return false; // Patient not found }
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public static void addAppointment(Appointment app) throws SQLException {
	    Connection conn = DatabaseConnection.getConnection();
//	    if (conn == null) {
//	        System.out.println("Database Connection Failed");
//	        return;
//	    }
//	    
        if (!isPatientRegistered(app.getPatientId())) {
            System.out.println("Patient ID not registered.");
//            return;
        }
 
        if (!isDoctorRegistered(app.getDoctorId())) {
            System.out.println("Doctor ID not registered.");
//            return;
        }
	    
	    String query = "INSERT INTO appointment (patient_id, doctor_id, appointment_date, reason) VALUES (?, ?, ?, ?)";
	    try (PreparedStatement psmt = conn.prepareStatement(query)) {
	        psmt.setInt(1, app.getPatientId());
	        psmt.setInt(2, app.getDoctorId());
	        psmt.setDate(3, new java.sql.Date(app.getAppointmentDate().getTime()));
	        psmt.setString(4, app.getReason());

	        psmt.executeUpdate();
	        System.out.println("Appointment added successfully.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


 
	public static List<Appointment> getAllAppointments() throws SQLException {
	    Connection conn = DatabaseConnection.getConnection();
	    if (conn == null) {
	        System.out.println("Database Connection Failed");
	        return null;
	    }
	    
	    List<Appointment> appts = new ArrayList<>();
	    String query = "SELECT * FROM appointment";
	    
	    try (Statement smt = conn.createStatement();
	         ResultSet rs = smt.executeQuery(query)) {
	        while (rs.next()) {
	            Appointment app = new Appointment(
	                rs.getInt("patient_id"),
	                rs.getInt("doctor_id"),
	                rs.getDate("appointment_date"),
	                rs.getString("reason")
	            );
	            app.setId(rs.getInt("id"));
	            appts.add(app);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return appts;
	}


 
	public static void updateAppointment(int id, Appointment app) throws SQLException {
	    Connection conn = DatabaseConnection.getConnection();
	    if (conn == null) {
	        System.out.println("Database Connection Failed");
	        return;
	    }
	    String query = "UPDATE appointment SET patient_id = ?, doctor_id = ?, appointment_date = ?, reason = ? WHERE id = ?";
	    try (PreparedStatement psmt = conn.prepareStatement(query)) {

	        psmt.setInt(1, app.getPatientId());
	        psmt.setInt(2, app.getDoctorId());
	        psmt.setDate(3, new java.sql.Date(app.getAppointmentDate().getTime())); 
	        psmt.setString(4, app.getReason());
	        psmt.setInt(5, id);

	        int rowsAffected = psmt.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Appointment updated successfully!");
	        } else {
	            System.out.println("Failed to update Appointment.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

 
    public static void deleteAppointment(int id) throws SQLException {
    	Connection conn = DatabaseConnection.getConnection();
	    if (conn == null) {
	        System.out.println("Database Connection Failed");
	        return;
	    }
	    
        String query = "DELETE FROM appointment WHERE id = ?";
        try (PreparedStatement psmt = conn.prepareStatement(query)) {
 
            psmt.setInt(1, id);
            int rowsAffected = psmt.executeUpdate();
 
            if (rowsAffected > 0) {
                System.out.println("Appointment deleted successfully!");
            } else {
                System.out.println("Cannot delete appointment.");
            }
        }
        catch(SQLException e) {
        	e.printStackTrace();
        }
    }
	
}
