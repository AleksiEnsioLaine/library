package library;

import java.util.Date;

public class Loan {

	Customer customer;
	Book book;
	Date loanStartDate;
	
	public Loan(Customer cust, Book bookToLoan, Date loanDate) {
	customer = cust;
	book = bookToLoan;
	loanStartDate =  loanDate;
	}
	

}
