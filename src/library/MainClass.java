
package library;

import javax.swing.JFrame;
import javax.swing.JLabel;
/*
 * Main class of the library project
 * @author Aleksi Laine
 * 
 */


public class MainClass extends JFrame{

	public static void main(String[] args) {
		
		Book warAndPeace = new Book();
		Book javaBasics = new Book();
		
		Customer andy = new Customer(666, "Smith", "Andy");
		warAndPeace.setTitle("War and Peace");
		
		javaBasics.setTitle("Java 101");
		
		warAndPeace.getTitle();
		javaBasics.getTitle();
		
		
		Book programmingForDummies = new Book(1000, 2000, 444, "Programming for dummies", "John Dummy", "educative", 40.0);
		programmingForDummies.getTitlePrint();
	}

}
