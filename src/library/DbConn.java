package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbConn {

	private static final String URL = "";
	private static final String USERNAME = "";
	private static final String PASS = "";
	
	private Connection conn = null;
	private PreparedStatement selectAllBooks = null;
	private PreparedStatement insertBook = null;
	
	public DbConn() {
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASS); 
			
			selectAllBooks = conn.prepareStatement("SELECT * FROM books"); 
			
			insertBook = conn.prepareStatement("INSERT INTO books VALUES (?,?,?,?)");
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}
	}
}
		
	

