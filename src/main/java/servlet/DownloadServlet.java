package servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import model.TestEmployee;
import service.TestEmployeeService;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
        // Get the employee ID from the request parameter (corrected to handle integer)   
        String employeeIdStr = request.getParameter("id");   
        if (employeeIdStr == null || employeeIdStr.isEmpty()) {   
            // Handle missing ID error (e.g., send error message)    
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);    
            return;   }   
        int employeeId;   
        try {    
        	employeeId = Integer.parseInt(employeeIdStr);   
        	} catch (NumberFormatException ex) 
        {    // Handle invalid ID format error (e.g., send error message)    
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);    
            return;   }   
            // Retrieve employee data based on the ID (using the corrected integer variable)   
            TestEmployeeService service = new TestEmployeeService();   
            TestEmployee employee = service.getEmployeeById(employeeId);    
            if (employee == null) {     
                // Handle employee not found error (e.g., send error message)     
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);     
                return;    
                
            }    
                // Prepare the data for download (replace with your logic for chosen format)    
                byte[] downloadContent = prepareDownloadData(employee);    // Set response headers for download    
                response.setContentType("application/octet-stream"); 
                // Adjust based on content type (e.g., CSV: text/csv)    
                response.setHeader("Content-Disposition","attachment; filename=employee_" + employeeId + ".csv"); 
                // Adjust filename extension    
                // Write the download content to the response    
                response.getOutputStream().write(downloadContent);   
                }   
                // Replace this method with your logic to convert employee data to downloadable format  
                private byte[] prepareDownloadData(TestEmployee employee) {    
                    // Implement logic to convert employee data to CSV format (replace with your desired format)    
                    String csvData = "ID, First Name, Last Name, Email, Department, Salary\n"+ 
                    employee.getId() + "," + 
                    employee.getFirstName() + "," + 
                    employee.getLastName() + "," + 
                    employee.getEmail() + "," + 
                    employee.getDepartment() + "," + 
                    employee.getSalary();
                    return csvData.getBytes(); 
                    // Assuming CSV data is stored in a String   
                    }  
    
}
   