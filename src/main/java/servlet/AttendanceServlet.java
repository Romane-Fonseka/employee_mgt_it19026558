package servlet;

import java.io.IOException;
//import java.sql.Date;
import java.util.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Attendance;
import service.AttendanceService;
/**
 * Servlet implementation class AttendanceServlet
 */




@WebServlet("/AttendanceServlet")
public class AttendanceServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AttendanceService attendanceService;

    @Override
    public void init() throws ServletException {
        try {
            attendanceService = new AttendanceService();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("markAttendance".equals(action)) {
            int id = Integer.parseInt(request.getParameter("employeeNo"));
            String status = request.getParameter("attendanceType");

            Attendance attendance = new Attendance();
            attendance.setId(id);
            attendance.setType(status);
            attendance.setDate(new Date());
            attendance.setTime(new Date());
            attendance.setTimestamp(new Date());

            if (attendanceService.markAttendance(attendance)) {
                response.sendRedirect("attendance.jsp?message=Attendance marked successfully");
            } else {
                response.sendRedirect("attendance.jsp?error=Error marking attendance");
            }
        }
    }

    @Override
    public void destroy() {
        attendanceService.closeConnection();
    }
}