/**
 * 
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Leave;
import model.TestEmployee;
import util.DBUtil;

/**
 * @author USER
 *
 */
public class LeaveService {
	// Method to retrieve leave details from the database
    public List<Leave> getLeaveDetails() {
        List<Leave> leaveDetails = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM leaveapp");
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Leave leave = new Leave();
                leave.setId(rs.getInt("id"));
                leave.setLeaveType(rs.getString("leave_type"));
                leave.setStartDate(rs.getDate("start_date"));
                leave.setEndDate(rs.getDate("end_date"));
                leave.setStatus(rs.getString("status"));
                leaveDetails.add(leave);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return leaveDetails;
    }

    // Method to apply for leave
    public boolean applyLeave(Leave leave) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO leaveapp (id, leave_type, start_date, end_date, status) VALUES (?, ?, ?, ?, ?)")) {
            pstmt.setInt(1, leave.getId());
            pstmt.setString(2, leave.getLeaveType());
            pstmt.setDate(3, new java.sql.Date(leave.getStartDate().getTime())); // Convert to java.sql.Date
            pstmt.setDate(4, new java.sql.Date(leave.getEndDate().getTime()));
            pstmt.setString(5, "Pending");
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Method to update leave application
    public boolean updateLeave(Leave leave) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "UPDATE leaveapp SET id = ?, leave_type = ?, start_date = ?, end_date = ?, status = ? WHERE id = ?")) {
            pstmt.setInt(1, leave.getId());
            pstmt.setString(2, leave.getLeaveType());
            pstmt.setDate(3, new java.sql.Date(leave.getStartDate().getTime())); // Convert to java.sql.Date
            pstmt.setDate(4, new java.sql.Date(leave.getEndDate().getTime()));
            pstmt.setString(5, leave.getStatus());
            pstmt.setInt(6, leave.getId());
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}