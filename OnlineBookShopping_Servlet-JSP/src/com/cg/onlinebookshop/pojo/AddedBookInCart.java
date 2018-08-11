package com.cg.onlinebookshop.pojo;

public class AddedBookInCart {

    private Book bookObject;
    private int noofBookAdded;
	
   
	public Book getBookObject() {
		return bookObject;
	}
	public void setBookObject(Book bookObject) {
		this.bookObject = bookObject;
	}
	public int getNoofBookAdded() {
		return noofBookAdded;
	}
	public void setNoofBookAdded(int noofBookAdded) {
		this.noofBookAdded = noofBookAdded;
	}
	@Override
	public String toString() {
		return "AddedBookInCart [bookObject=" + bookObject + ", noofBookAdded=" + noofBookAdded + "]";
	}
	public AddedBookInCart(Book bookObject, int noofBookAdded) {
		super();
		this.bookObject = bookObject;
		this.noofBookAdded = noofBookAdded;
	}
	
	
	
}
