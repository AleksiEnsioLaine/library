package library;

/*
 * Book constructor and methods
 * @author Aleksi Laine
 */
public class Book {

	//final int MAXIMUM_PAGES = 3000;
	//int pages, yearPublished, bookId;
	String title, author, genre = "";
	double price;
	//Book(){
	//}
	
	public Book(String title, String author, String genre) {
		setTitle(title);
		setAuthor(author);
		setGenre(genre);
	}
	/*
	Book(int pages, int yearPublished, int bookId, String title, String author, String genre, double price){
		setTitle(title);
		setAuthor(author);
		setGenre(genre);
		setPages(pages);
		setYearPublished(yearPublished);
		setBookId(bookId);
		setPrice(price);
	}
	*/
	void setTitle(String p){
		this.title = p;
		System.out.println("The Book title set to " + p);
	}
	
	void setAuthor(String a){
		this.author = a;
	}
	
	void setGenre(String g){
		this.genre = g;
	}
	
	String getTitle(){
		return this.title;
	}
	
	void getTitlePrint(){
		System.out.println(this.title);
	}
	/*
	void setPages(int p){
		this.pages = p;
	}
	void setYearPublished(int y){
		this.yearPublished = y;
	}
	void setBookId(int i){
		this.bookId = i;
	}
	void setPrice(double p){
		this.price = p;
	}
	*/
	
	
	
	
}
