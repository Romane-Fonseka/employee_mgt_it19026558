package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Leave;
import model.TestEmployee;
import service.LeaveService;
import service.TestEmployeeService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;


/**
 * Servlet implementation class Applyleave
 */
@WebServlet("/Applyleave")
public class Applyleave extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LeaveService leaveService = new LeaveService();
        List<Leave> leaveDetails = leaveService.getLeaveDetails();
        request.setAttribute("leaveDetails", leaveDetails);
        request.getRequestDispatcher("leave.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String leaveType = request.getParameter("leaveType");
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        String status = "Pending";

        Leave leave = new Leave();

        LeaveService leaveService = new LeaveService();
        boolean success = leaveService.applyLeave(leave);

        if (success) {
            response.sendRedirect("leaveapp");
        } else {
            response.sendRedirect("error.html");
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int lId = Integer.parseInt(request.getParameter("lId"));
        int id = Integer.parseInt(request.getParameter("id"));
        String leaveType = request.getParameter("leaveType");
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        String status = request.getParameter("status");

        Leave leave = new Leave();

        LeaveService leaveService = new LeaveService();
        boolean success = leaveService.updateLeave(leave);

        if (success) {
            response.sendRedirect("leaveapp");
        } else {
            response.sendRedirect("error.html");
        }
    }
}