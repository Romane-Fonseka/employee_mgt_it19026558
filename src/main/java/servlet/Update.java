package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TestEmployee;
import service.TestEmployeeService;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    
	    private TestEmployeeService testEmployeeService = new TestEmployeeService();

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        TestEmployee employee = testEmployeeService.getEmployeeById(id);
	        request.setAttribute("employee", employee);
	        request.getRequestDispatcher("update.jsp").forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String email = request.getParameter("email");
	        String department = request.getParameter("department");
	        double salary = Double.parseDouble(request.getParameter("salary"));
	        String role = request.getParameter("role");

	        TestEmployee updatedEmployee = new TestEmployee(id, firstName, lastName, email, department, salary, role);
	        boolean success = testEmployeeService.updateEmployee(updatedEmployee);

	        if (success) {
	            response.sendRedirect("emplist.jsp");
	        } else {
	            response.sendRedirect("error.html");
	        }
	    }
	}