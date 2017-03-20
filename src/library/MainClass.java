
package library;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/*
 * Main class of the library project
 * @author Aleksi Laine 
 * 
 */



@SuppressWarnings("serial")
public class MainClass extends JFrame{
	
	final static int MAX_QTY = 5; 
	static int books = 0;
	static int customers = 0;
	
	static Book[] booksDb = new Book[MAX_QTY]; 
	static Customer[] customerDb = new Customer[MAX_QTY];
	static JTable tableBooks;
	static JButton btnAddBook;
	static JButton btnAddCustomer;
	static JLabel info;
	static MyEventHandler commandHandler;
	private JLabel lblBooks;
	private JTable tableCustomers;
	
	public MainClass() {
		setTitle("Library Manager 3000");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(0,0,550,500);
		setLocationRelativeTo(null);
		
		btnAddBook = new JButton("Add book");
		btnAddBook.setBounds(192, 32, 157, 25);
		getContentPane().add(btnAddBook);
		
		
		btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.setBounds(192, 70, 157, 25);
		getContentPane().add(btnAddCustomer);
		
		JLabel info = new JLabel("info label");
		info.setBounds(75, 350, 389, 16);
		getContentPane().add(info);
		/*
		 * 
		 * Books table and header label
		 * 
		 */
		tableBooks = new JTable();
		tableBooks.setModel(new DefaultTableModel(
			new Object[MAX_QTY][3], 
			new String[] {"Title", "Author", "Genre"} 
		));
		tableBooks.setBounds(26, 163, 240, 80); 
		getContentPane().add(tableBooks);
		
		lblBooks = new JLabel("Books");
		lblBooks.setBounds(26, 141, 56, 16);
		getContentPane().add(lblBooks);
		
		/*
		 * Customers table and header label
		 * 
		 */
		tableCustomers = new JTable();
		tableCustomers.setModel(new DefaultTableModel(
			new Object[MAX_QTY][2],
			new String[] {"Firstname", "Lastname"}
		));
		tableCustomers.setBounds(309, 163, 160, 80);
		getContentPane().add(tableCustomers);
		
		JLabel lblCustomers = new JLabel("Customers");
		lblCustomers.setBounds(309, 141, 120, 16);
		getContentPane().add(lblCustomers);
		
		populateTableBooks();
		
		MyEventHandler commandHandler = new MyEventHandler();
		btnAddBook.addActionListener(commandHandler);
		btnAddCustomer.addActionListener(commandHandler);
	}
	/*
	 * populate books table 
	 */
	private void populateTableBooks(){
		for (int row=0; row<books; row++){
			tableBooks.setValueAt(booksDb[row].title, row, 0);  
			tableBooks.setValueAt(booksDb[row].author, row, 1);  
			tableBooks.setValueAt(booksDb[row].genre, row, 2);
		}
	}
	
	/*
	 * populate customers table 
	 */
	private void populateTableCustomers(){
		for (int row=0; row<customers; row++){
			tableCustomers.setValueAt(customerDb[row].firstName, row, 0);  
			tableCustomers.setValueAt(customerDb[row].lastName, row, 1);  
		}
	}
	
	/*
	 * Event handler class 
	 */
	private class MyEventHandler implements ActionListener{
		

			public void actionPerformed (ActionEvent myEvent){
				
				/*
				 * Handler for add book button
				 */
				if (myEvent.getSource() == btnAddBook){
					if (books < MAX_QTY){
						getNewBookFromUser();
						populateTableBooks();
					}
					else{
						JOptionPane.showMessageDialog(null, "You can not add more cars in your collection", "Info", JOptionPane.INFORMATION_MESSAGE);
					}
						
				}
				/*
				 * Handler for add Customer button
				 */
				if(myEvent.getSource() == btnAddCustomer){
					if (customers < MAX_QTY){
						getNewCustomerFromUser();
						populateTableCustomers();
					}
					else{
						JOptionPane.showMessageDialog(null, "You can not add more cars in your collection", "Info", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
	}
	/*
	 * get new book from user method, invoked by add book button
	 */
	private void getNewBookFromUser(){
	    JTextField title = new JTextField(10);
	    JTextField author = new JTextField(10);
	    JTextField genre = new JTextField(10);
 
	    JPanel myPanel = new JPanel();

	    myPanel.add(new JLabel("title:"));
	    myPanel.add(title);
	    
	    myPanel.add(new JLabel("author:"));
	    myPanel.add(author);
	    
	    myPanel.add(new JLabel("genre:"));
	    myPanel.add(genre);
	    
	    int result = JOptionPane.showConfirmDialog(null, myPanel, "Enter info for new book", JOptionPane.OK_CANCEL_OPTION);
	    
	    if (result == JOptionPane.OK_OPTION) {
	    	booksDb[books] = new Book( title.getText(), author.getText(), genre.getText()) ;	
	    	++books;
	    }
	}
	
	/*
	 * get new customer from user method, invoked by add book button
	 */
	private void getNewCustomerFromUser(){
	    JTextField firstName = new JTextField(10);
	    JTextField lastName = new JTextField(10);
 
	    JPanel myPanel = new JPanel();

	    myPanel.add(new JLabel("firstname:"));
	    myPanel.add(firstName);
	    
	    myPanel.add(new JLabel("lastname:"));
	    myPanel.add(lastName);
	    
	    
	    int result = JOptionPane.showConfirmDialog(null, myPanel, "Enter info for new book", JOptionPane.OK_CANCEL_OPTION);
	    
	    if (result == JOptionPane.OK_OPTION) {
	    	customerDb[customers] = new Customer( firstName.getText(), lastName.getText()) ;	
	    	++customers;
	    }
	}

	public static void main(String[] args) {
		
		MainClass gui = new MainClass();
		gui.setVisible(true);
	/*	
	 * some alpha testing
	 * 
		Book warAndPeace = new Book();
		Book javaBasics = new Book();
		
		Customer andy = new Customer(666, "Smith", "Andy");
		warAndPeace.setTitle("War and Peace");
		
		javaBasics.setTitle("Java 101");
		
		warAndPeace.getTitle();
		javaBasics.getTitle();
		
		
		Book programmingForDummies = new Book(1000, 2000, 444, "Programming for dummies", "John Dummy", "educative", 40.0);
		programmingForDummies.getTitlePrint();
	*/
	}
}
