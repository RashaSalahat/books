package productioncode;

import java.util.ArrayList;
import java.util.List;

public class Books extends Book {
	Book book;
	public List<Book> listbooks=new ArrayList<Book>();
	public Books(Book book){
		this.book=book;
	}
	public void setlistbooks(List<Book> listbooksValue) {
		 listbooks=listbooksValue;
	}
	public List<Book> getlistbooks()
	{
		return listbooks;
	}
	public void addBook(String title,String author, String signuature, String iSBN_10,String state)
	{
		    book=new Book();
         	 book.setBookTitle(title);
		     book.setBookAuthor(author);
		     book.setBookSignature(signuature);
		     book.setBookISBN10(iSBN_10);
		     book.setBookState(state);
		     listbooks.add(book);
	}
	
	public boolean isExistISBNSig(String iSBN,String sig,List<Book> book,String title)
	{ 

		 for(int i=0; i <4;i++) 
			{
	
				if( ((book.get(i).getBookISBN10().equals(iSBN))  && !(book.get(i).getBookTitle().equals(title) )) ||
						(listbooks.get(i).getBookSignature().equals(sig) &&  !(book.get(i).getBookTitle().equals(title) ) ))
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
		
		 

	
	
	
	public int findBook(String title,String author, String sig, String iSBN)
	{
		for(int i=0; i<6;i++)
		{
			if(listbooks.get(i).getBookTitle().equals(title)&&listbooks.get(i).getBookAuthor().equals(author) &&
					listbooks.get(i).getBookSignature().equals(sig)&&listbooks.get(i).getBookISBN10().equals(iSBN)	)
				return i;
				
		}
		return 0;
	}
}