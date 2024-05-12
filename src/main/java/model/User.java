/**
 * 
 */
package model;

/**
 * 
 */

public class User {
    
    private int username;
    private String password;
    private String role; // "ADMIN" or "EMPLOYEE"
    private TestEmployee employee; // Reference to Employee
    
    // Constructors, getters, setters, and other methods
    
    public int getUsername() {
        return username;
    }

    
    public void setUsername(int username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public TestEmployee getEmployee() {
        return employee;
    }
    
    public void setEmployee(TestEmployee employee) {
        this.employee = employee;
    }
}
