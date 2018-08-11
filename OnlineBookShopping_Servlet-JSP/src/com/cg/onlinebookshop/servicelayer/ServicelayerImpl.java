package com.cg.onlinebookshop.servicelayer;

import java.util.Collection;

import com.cg.onlinebookshop.dao.CartDaoImpl;
import com.cg.onlinebookshop.pojo.AddedBookInCart;
import com.cg.onlinebookshop.pojo.Book;

public class ServicelayerImpl {

	CartDaoImpl cartdaoImpl = new CartDaoImpl(); 
	
	public void addBookIntoCarT(int bookId)
	{
	  cartdaoImpl.addBookIntoCarT(bookId);
	}
	
	
	public void removeBookFromCart(int bookId)
	{
		cartdaoImpl.removeBookFromCart(bookId);
	}
	
	
	public Collection<AddedBookInCart> ViewCart()
	{
		return cartdaoImpl.ViewCart();
	}
	
	
	public Collection<Book> ViewBook()
	{
		return cartdaoImpl.ViewBook();
	}



	public int getCounter() {
		return cartdaoImpl.getCounter();
	}


	public double getPrice() {
		// TODO Auto-generated method stub
		return cartdaoImpl.getPrice();
	}
	
	
}
