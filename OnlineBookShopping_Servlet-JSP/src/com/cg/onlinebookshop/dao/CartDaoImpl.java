package com.cg.onlinebookshop.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.cg.onlinebookshop.pojo.AddedBookInCart;
import com.cg.onlinebookshop.pojo.Book;

public class CartDaoImpl {
	
	private static Map<Integer,Book> books = new HashMap<Integer, Book>();
	
	private static Map<Integer,AddedBookInCart> addedBooks = new HashMap<Integer, AddedBookInCart>();
	
	private static Book mathematics = new Book(1, "Maths", "Fundamentals of Algebra", 599);
	private static Book science = new Book(2, "Science", "Science with fact", 499);
	private static Book civics = new Book(3, "Civics", "Civics in Modern World", 299);
	private static Book java = new Book(4, "Java", "Head First Java", 999);
	private static Book spring = new Book(5, "Spring", "Spring in Hand", 799);
	private static Book jee = new Book(6, "JEE", "JEE Magics", 899);
	private static Book dotnet = new Book(7, "Dotnet", "Dotnet in Capsule", 199);
	private static Book english = new Book(8, "English", "English in Simple Words", 99);
	private static Book history = new Book(9, "History", "Ancient History", 499);
static
	{
		books.put(mathematics.getBookId(), mathematics);
		books.put(science.getBookId(), science);
		books.put(civics.getBookId(), civics);
		books.put(java.getBookId(), java);
		books.put(spring.getBookId(), spring);
		books.put(jee.getBookId(), jee);
		books.put(dotnet.getBookId(), dotnet);
		books.put(english.getBookId(), english);
		books.put(history.getBookId(), history);
		
	}
	
	public void addBookIntoCarT(int bookId)
	{
		  if(addedBooks.get(bookId) == null)  
		    {
			  for(Book book : ViewBook())
			  {
				  if(book.getBookId()==bookId)
				  {
					  AddedBookInCart addedBookInCart = new AddedBookInCart(book,1);
					  addedBooks.put(bookId,addedBookInCart);
				  }
			  }
			  
		    }
		  else
		  {
		    AddedBookInCart addedBookInCart =  addedBooks.get(bookId);
		    addedBookInCart.setNoofBookAdded(addedBookInCart.getNoofBookAdded()+1);
		  }
	}
	
	public void removeBookFromCart(int bookId)
	{
		 if(addedBooks.get(bookId).getNoofBookAdded() > 1)  
		    {
			 addedBooks.get(bookId).setNoofBookAdded(addedBooks.get(bookId).getNoofBookAdded()-1); 
		    }
		  else
		  {
		    addedBooks.remove(bookId);
		  }
	}
	
	public Collection<AddedBookInCart> ViewCart()
	{
		return addedBooks.values();
	}

	public Collection<Book> ViewBook() {
		return books.values();
	}

	public int getCounter() {
		int counter = 0;
		for(AddedBookInCart item:addedBooks.values())
		{
			counter += item.getNoofBookAdded();
		}
		return counter;
	}

	public double getPrice() {
		double sum = 0;
		for(AddedBookInCart item:addedBooks.values())
		{
			sum += (item.getBookObject().getBookPrice())*(item.getNoofBookAdded());
		}
		return sum;
	}
}
