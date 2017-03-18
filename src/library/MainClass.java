package library;

/*
 * Main class of the library project
 * @author Aleksi Laine
 * 
 */
public class MainClass {

	public static void main(String[] args) {
		
		Book warAndPeace = new Book();
		Book javaBasics = new Book();
		
		Customer andy = new Customer(666);
		warAndPeace.setTitle("War and Peace");
		
		javaBasics.setTitle("Java 101");
		
		warAndPeace.getTitle();
		javaBasics.getTitle();
		
		andy.setName("Smith", "Andy");
	}

}
