/**
 * 
 */
package service;

/**
 * 
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.Attendance;
import util.DBUtil;

public class AttendanceService {
    
private Connection conn;
    
    public AttendanceService() throws SQLException {
        conn = DBUtil.getConnection();
    }
    
    // Mark Attendance
    public boolean markAttendance(Attendance attendance) {
        String sql = "INSERT INTO day_log (id, type, day, time, timestamp) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, attendance.getId());
            pstmt.setString(2, attendance.getType());
            pstmt.setDate(3, new Date(attendance.getDate().getTime()));
            pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
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

