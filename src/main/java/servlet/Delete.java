package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TestEmployeeService;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private TestEmployeeService testEmployeeService = new TestEmployeeService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Retrieve the employee ID from the request
        int id = Integer.parseInt(request.getParameter("id"));
        
        // Delete the employee record using the service
        boolean success = testEmployeeService.deleteEmployee(id);
        
        // Redirect to the employee list page
        if (success) {
            response.sendRedirect("emplist.jsp");
        } else {
            // Handle deletion failure
            response.sendRedirect("error.html");
        }
    }
}