/**
 * 
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import model.TestEmployee;

/**
 * @author USER
 *
 */
public class TestEmployeeService {
	
	public boolean addEmployee(TestEmployee employee) {
        String sql = "INSERT INTO employee (id, first_name, last_name, email, department, salary, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setInt(1, employee.getId());
            pstmt.setString(2, employee.getFirstName());
            pstmt.setString(3, employee.getLastName());
            pstmt.setString(4, employee.getEmail());
            pstmt.setString(5, employee.getDepartment());
            pstmt.setDouble(6, employee.getSalary());
            pstmt.setString(7, employee.getRole());
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
	
	// Method to retrieve all employees from the database
    public List<TestEmployee> getAllEmployees() {
        List<TestEmployee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");
                String role = rs.getString("role");
                TestEmployee employee = new TestEmployee(id, firstName, lastName, email, department, salary, role);
                employees.add(employee);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return employees;
    }
    
    //update an employee record
    public boolean updateEmployee(TestEmployee employee) {
        String sql = "UPDATE employee SET first_name=?, last_name=?, email=?, department=?, salary=?, role=? WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, employee.getFirstName());
            pstmt.setString(2, employee.getLastName());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, employee.getDepartment());
            pstmt.setDouble(5, employee.getSalary());
            pstmt.setString(6, employee.getRole());
            pstmt.setInt(7, employee.getId());

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public TestEmployee getEmployeeById(int id) {
    	  TestEmployee employee = null;
    	  String sql = "SELECT * FROM employee WHERE id = ?";
    	  try (Connection conn = DBUtil.getConnection();
    	       PreparedStatement pstmt = conn.prepareStatement(sql)) {
    	    pstmt.setInt(1, id);
    	    ResultSet rs = pstmt.executeQuery();
    	    if (rs.next()) {
    	      // Retrieve employee data from the result set
    	      int empId = rs.getInt("id");
    	      String firstName = rs.getString("first_name");
    	      String lastName = rs.getString("last_name");
    	      String email = rs.getString("email");
    	      String department = rs.getString("department");
    	      double salary = rs.getDouble("salary");
    	      String role = rs.getString("role");
    	  
    	      // Create a new TestEmployee object with the retrieved data
    	      employee = new TestEmployee(empId, firstName, lastName, email, department, salary, role);
    	    }
    	  } catch (SQLException ex) {
    	    ex.printStackTrace();
    	  }
    	  return employee;
    	}



    // Method to delete an employee
    public boolean deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }


}
