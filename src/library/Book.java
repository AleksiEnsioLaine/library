package library;

/*
 * Book constructor and methods
 * @author Aleksi Laine
 */
public class Book {
	final int MAXIMUM_PAGES = 3000;
	private int pages, yearPublishe, bookId;
	private String title, author, genre = "";
	double price;
	
	public void setTitle(String p){
		this.title = p;
		System.out.println("The Book pages set to " + p);
	}
	void getTitle(){
		System.out.println(this.title);
	}
	
}
