package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("login")) {
            login(request, response);
        } else if (action != null && action.equals("register")) {
            register(request, response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int username = Integer.parseInt(request.getParameter("employeeId"));
        String password = request.getParameter("employeePassword");

        UserService userService = null;
        try {
            userService = new UserService();
            String role = userService.authenticateUser(username, password);

            if (role != null) {
                // Successful authentication
                if (role.equals("AD")) {
                    // Redirect admin to admin dashboard
                    response.sendRedirect("TestEmpDash.html");
                } else if (role.equals("RE")) {
                    // Redirect regular employee to employee dashboard
                    response.sendRedirect("attendance.jsp");
                } else {
                    // Unknown role, handle accordingly
                	request.setAttribute("errorMessage", "Invalid role.");
                    response.sendRedirect("login.jsp");
                }
            } else{
                // Authentication failed, redirect to login page with error message
                request.setAttribute("errorMessage", "Invalid username or password.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Log the exception and redirect to an error page
            request.setAttribute("errorMessage", "Invalid username or password.");
            response.sendRedirect("login.jsp");
        } finally {
            if (userService != null) {
                userService.closeConnection();
            }
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int username = Integer.parseInt(request.getParameter("username"));
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        User user = new User();
        UserService userService = null;
		try {
			userService = new UserService();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        boolean registrationSuccess = userService.registerUser(user);
        userService.closeConnection(); // Close the database connection
        
        // Redirect to appropriate page based on registration success
        if (registrationSuccess) {
            response.sendRedirect("login.jsp");
        } else {
        	// Unknown role, handle accordingly
        	request.setAttribute("errorMessage", "Invalid role.");
            response.sendRedirect("user.jsp");
        }
    }
}
