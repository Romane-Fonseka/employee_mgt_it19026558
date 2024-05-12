/**
 * 
 */
package service;

/**
 * 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import model.TestEmployee;
import util.DBUtil;

public class UserService {
    
    // Database Connection
	private Connection conn;

    public UserService() throws SQLException {
        conn = DBUtil.getConnection();
    }
    
    //insert user
    public boolean registerUser(User user) {
        String sql = "INSERT INTO login (username, password, role) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setInt(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getRole());
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
      
    // Authenticate User
    public String authenticateUser(int employeeId, String password) {
    	String role = null;
    	String sql = "SELECT role FROM login WHERE username = ? AND password = ?";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, employeeId);
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
            	role = rs.getString("role"); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return role;
    }
  //AuthenticateRenter
    public String authenticateRenter(String password) throws SQLException {
        String sql = "SELECT role FROM renters WHERE username = ? AND password_hash = ?";
        String renterRole = null;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "renter"); // Assuming username for renters is always "renter"
            pstmt.setString(2, password); // Hash the input password before comparison

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                renterRole = rs.getString("role");
            }
        }

        return renterRole;
    }

    
    // Close Database Connection
    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

