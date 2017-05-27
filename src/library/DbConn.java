package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConn {

	private static final String URL = "jdbc:mysql://localhost:3306/library";
	private static final String USERNAME = "root";
	private static final String PASS = "";
	
	private Connection conn = null;
	
	
	private PreparedStatement getBooks = null;
	private PreparedStatement addBook = null;
	
	private PreparedStatement getCustomers = null;
	private PreparedStatement addCustomer = null;
	
	
	public DbConn() {
		
		try {
			
			//connect to database
			conn = DriverManager.getConnection(URL, USERNAME, PASS); 
			
			//prepare statements
			getBooks = conn.prepareStatement("SELECT * FROM books"); 
			addBook = conn.prepareStatement("INSERT INTO books VALUES (?,?,?,?)");
			
			getCustomers = conn.prepareStatement("SELECT * FROM custemers"); 
			addCustomer = conn.prepareStatement("INSERT INTO customers VALUES (?,?)");
			
		}
		//if something goes sideways throw error at it
		catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			System.out.print("Connection failed");
			System.exit(1);
		} 
		
	}
	//method inserts new book to database
	public void addBook(Book book) {
		
		try {
			addBook.setString(1, book.title);
			addBook.setString(2, book.author);
			addBook.setString(3, book.genre);
			addBook.setInt(4, book.pages);
			
			addBook.executeUpdate(); 
		}
		
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}	
}
	
	//Method inserts new Customer to database
	public void addCustomer(Customer customer) {
		
		try {
			addCustomer.setString(1, customer.firstName);
			addCustomer.setString(2, customer.lastName);
			
			addCustomer.executeUpdate(); 
		}
		
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
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
		
	

