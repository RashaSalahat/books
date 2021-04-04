package ProductionCode;

import java.util.ArrayList;

public class Books extends Book {
	Book book;
	public ArrayList<Book> books=new ArrayList<Book>();
	public Books(Book book){
		this.book=book;
	}
	public void addBook(String title,String author, String signuature, String ISBN_10,String state)
	{
		    book=new Book();
         	 book.setBookTitle(title);
		     book.setBookAuthor(author);
		     book.setBookSignature(signuature);
		     book.setBookISBN_10(ISBN_10);
		     book.setBookState(state);
		     books.add(book);
	}
	
	public boolean isExistISBN_Sig(String ISBN,String sig,ArrayList<Book> book,String title)
	{ 

		 for(int i=0; i <4;i++) 
			{
	
				if( ((book.get(i).getBookISBN_10().equals(ISBN))  && !(book.get(i).getBookTitle().equals(title) )) ||
						(books.get(i).getBookSignature().equals(sig) &&  !(book.get(i).getBookTitle().equals(title) ) ))
				{ 
				
					
							book.get(i).setBookState("Unexisting");
					
					
					return true;
				}
				else 
				{	
						book.get(i).setBookState("Existing");
				}
					}
		 return false;
	}
		
		 

	
	
	
	public int findBook(String title,String author, String sig, String ISBN)
	{
		for(int i=0; i<6;i++)
		{
			if(books.get(i).getBookTitle().equals(title)&&books.get(i).getBookAuthor().equals(author) &&
					books.get(i).getBookSignature().equals(sig)&&books.get(i).getBookISBN_10().equals(ISBN)	)
				return i;
				
		}
		return 0;
	}
}