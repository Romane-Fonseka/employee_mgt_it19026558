package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TestEmployee;
import service.TestEmployeeService;

/**
 * Servlet implementation class TestEmployeeServlet TestEmployeeServlet
 */
@WebServlet("/TestEmployeeServlet")
public class TestEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private TestEmployeeService testemployeeservice;
	private TestEmployeeService testEmployeeService = new TestEmployeeService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchText = request.getParameter("searchText");
        List<TestEmployee> employees;
        if (searchText != null && !searchText.isEmpty()) {
            try {
                int id = Integer.parseInt(searchText);
                employees = List.of(testEmployeeService.getEmployeeById(id)); // Assuming getEmployeeById returns a single employee
            } catch (NumberFormatException e) {
                // Handle invalid search text (not a number)
            	request.setAttribute("errorMessage", "No Results Found.");
                employees = null; // Indicate no search result
            }
        } else {
            employees = testEmployeeService.getAllEmployees();
        }
        request.setAttribute("listEmployees", employees);
        request.getRequestDispatcher("emplist.jsp").forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int id = Integer.parseInt(request.getParameter("id"));
		    String firstName = request.getParameter("firstName");
		    String lastName = request.getParameter("lastName");
		    String email = request.getParameter("email");
		    String department = request.getParameter("department");
		    double salary = Double.parseDouble(request.getParameter("salary"));
		    String role = request.getParameter("role");

		    TestEmployee employee = new TestEmployee(id,firstName, lastName, email, department, salary, role);
		    TestEmployeeService employeeService = new TestEmployeeService();
		    boolean success = employeeService.addEmployee(employee);

		    if (success) {
		        // Redirect or show success message
		    	
		        response.sendRedirect("user.jsp");
		    } else {
		        // Redirect or show error message
		        response.sendRedirect("TestEmployeeService.html");
		    }
		
	}
	
	/**
	//update employee
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
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
    **/
	
	/**
	//delete employee
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean success = testEmployeeService.deleteEmployee(id);

        if (success) {
            response.sendRedirect("emplist.jsp");
        } else {
            response.sendRedirect("error.html");
        }
    }
	**/
	
}


