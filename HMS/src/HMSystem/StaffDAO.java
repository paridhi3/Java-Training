package HMSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffDAO {

    public static void addStaff(Staff staff) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed.");
            return;
        }
        String query = "INSERT INTO Staff (name, role, contact_number) VALUES (?,?,?)";
        try {
            PreparedStatement psmt = conn.prepareStatement(query);
            psmt.setString(1, staff.getName());
            psmt.setString(2, staff.getRole());
            psmt.setString(3, staff.getContactNumber());
            psmt.executeUpdate();
            System.out.println("Staff added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Staff> getAllStaff() {
        List<Staff> staffList = new ArrayList<>();
        String query = "SELECT * FROM Staff";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Staff staff = new Staff(rs.getInt("id"), rs.getString("name"), rs.getString("role"),
                        rs.getString("contact_number"));
                staffList.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffList;
    }

    public static void updateStaff(int id, Staff s) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed.");
            return;
        }
        String query = "UPDATE Staff SET name = ?, role = ?, contact_number = ? WHERE id = ?";
        
        try(PreparedStatement psmt = conn.prepareStatement(query)) {
            psmt.setString(1, s.getName());
            psmt.setString(2, s.getRole());
            psmt.setString(3, s.getContactNumber());
            psmt.executeUpdate();
            System.out.println("Staff updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStaff(int staffId) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed.");
            return;
        }
        String query = "DELETE FROM Staff WHERE id = ?";
        try (PreparedStatement psmt = conn.prepareStatement(query)) {
            psmt.setInt(1, staffId);
            psmt.executeUpdate();
            System.out.println("Staff deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
