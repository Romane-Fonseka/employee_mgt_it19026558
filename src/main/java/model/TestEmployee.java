/**
 * 
 */
package model;

/**
 * @author USER
 *
 */
public class TestEmployee {

		private int id;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String department;
	    private double salary;
	    private String role;
	    
	    public TestEmployee() {};

	    public TestEmployee(
	    		int id, 
				String firstName, 
				String lastName, 
				String email,
				String department, 
				double salary,
				String role) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.department = department;
			this.salary = salary;
			this.role = role;
		}
	    
	    // Constructor
	    
	    /**
	    public  TestEmployee(int id, String firstName, String lastName, String email, String department, double salary, String role) {
	    	this.id = id;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.department = department;
	        this.salary = salary;
	        this.role = role;
	    }
	    **/

	    // Getters and setters
	    
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	        }
	    
	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getDepartment() {
	        return department;
	    }

	    public void setDepartment(String department) {
	        this.department = department;
	    }

	    public double getSalary() {
	        return salary;
	    }

	    public void setSalary(double salary) {
	        this.salary = salary;
	    }
	    
	    public String getRole() {
	        return role;
	    }

	    public void setRole(String role) {
	        this.role = role;
	    }
	}

