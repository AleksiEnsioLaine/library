
package library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	static int dbItems = 0;
	
	static Book[] myDB = new Book[MAX_QTY]; 
	
	static JTable tableBooks;
	static JButton btnAddBook;

	
	public MainClass() {
		setTitle("Library Manager 3000");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(0,0,550,500);
		setLocationRelativeTo(null);
		
		JButton btnAddBook = new JButton("Add book");
		btnAddBook.setBounds(192, 32, 157, 25);
		getContentPane().add(btnAddBook);
		
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.setBounds(192, 70, 157, 25);
		getContentPane().add(btnAddCustomer);
		
		JLabel lblInfoLabel = new JLabel("info label");
		lblInfoLabel.setBounds(75, 350, 389, 16);
		getContentPane().add(lblInfoLabel);
		
		tableBooks = new JTable();
		tableBooks.setModel(new DefaultTableModel(
			new Object[MAX_QTY][3], 
			new String[] {"Title", "Author", "Genre"} 
		));
		tableBooks.setBounds(109, 163, 240, 100); 
		getContentPane().add(tableBooks);
		
		MyEventHandler commandHandler = new MyEventHandler();
		btnAddBook.addActionListener(commandHandler);
	}
	private class MyEventHandler implements ActionListener{
		
			public void actionPerformed (ActionEvent myEvent){
				
				if (myEvent.getSource() == btnAddBook){
					if (dbItems < MAX_QTY){
						getNewBookFromUser();
					}
					else{
						JOptionPane.showMessageDialog(null, "You can not add more cars in your collection", "Info", JOptionPane.INFORMATION_MESSAGE);
					}
						
				}
			}
	}
	
	
	private void getNewBookFromUser(){
		/*
		JTextField pages = new JTextField(10);
	    JTextField yearPublished = new JTextField(10);
	    JTextField bookId = new JTextField(10);
	    */
	    JTextField title = new JTextField(10);
	    JTextField author = new JTextField(10);
	    JTextField genre = new JTextField(10);
	    //JTextField price = new JTextField(10);
 
	    JPanel myPanel = new JPanel();
	    /*
	    myPanel.add(new JLabel("Pages in a book:"));
	    myPanel.add(pages);
	    
	    myPanel.add(new JLabel("When published:"));
	    myPanel.add(yearPublished);

	    myPanel.add(new JLabel("bookId:"));
	    myPanel.add(bookId);
		*/
	    myPanel.add(new JLabel("title:"));
	    myPanel.add(title);
	    
	    myPanel.add(new JLabel("author:"));
	    myPanel.add(author);
	    
	    myPanel.add(new JLabel("genre:"));
	    myPanel.add(genre);
	    
	    //myPanel.add(new JLabel("price:"));
	    //myPanel.add(price);
	    
	    
	    int result = JOptionPane.showConfirmDialog(null, myPanel, "Enter info for new book", JOptionPane.OK_CANCEL_OPTION);
	    
	    if (result == JOptionPane.OK_OPTION) {
	    	myDB[dbItems] = new Book( title.getText(), author.getText(), genre.getText()) ;	
	    	++dbItems;
	    }
	}

	public static void main(String[] args) {
		
		MainClass gui = new MainClass();
		gui.setVisible(true);
	/*	
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
