package library;

/*
 * Customer constructor and methods
 * @author Aleksi Laine 
 */
public class Customer {


	String lastName, firstName = "";
	int customerId;
	
	Customer(int i){
		this.customerId = i;
	}
	
	void setName(String l, String f){
		lastName = l;
		firstName = f;
		System.out.print("customer " + this.customerId + " is now " + this.firstName);
	}
}
