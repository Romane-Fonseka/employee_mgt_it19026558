/**
 * 
 */
/**
 * @author TestEmployee
 *
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {

    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/employee_management?useSSL=false";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root123";
    
    

    /**public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }**/
    
    public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
