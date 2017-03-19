package library;

/*
 * Customer constructor and methods
 * @author Aleksi Laine 
 */
public class Customer {


	String lastName, firstName = "";
	int customerId;
	
	Customer( String lastName, String firstName){
		this.setName(lastName, firstName);
	}
	
	Customer(int id, String lastName, String firstName){
		this.setId(id);
		this.setName(lastName, firstName);
	}
	
	void setId(int i){
		this.customerId = i;
	}
	
	void setName(String l, String f){
		lastName = l;
		firstName = f;
		System.out.println("customer " + this.customerId + " is now " + this.firstName + " " + this.lastName);
	}
}
