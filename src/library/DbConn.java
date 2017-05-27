package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {

	private static final String URL = "jdbc:mysql://localhost:3306/library";
	private static final String USERNAME = "root";
	private static final String PASS = "";
	
	private Connection conn = null;
	
	public DbConn() {
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASS); 
			
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.out.print("Connection failed");
			System.exit(1);
		} 
	}
	
	public void closeConn(){
		try {
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
		
	

