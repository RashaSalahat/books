package productioncode;

import java.util.ArrayList;
import java.util.List;

import java.util.logging.Logger;




public class Search {
	List<Book> bookResult;
	 List<Book> bookArray1;
	public static final boolean EXIST =false;
	 GeneralSpec spec;
	 Book book;
	 public static final Logger LOGGER = Logger.getLogger(Search.class.getName());
	public Search(List<Book> bookArray) {
		
		bookArray1=new ArrayList<Book>(bookArray);
		bookResult=new ArrayList<Book>();

	}
	public List<Book> printResult() {
		

		if ( bookResult.isEmpty()) {
			LOGGER.info("There is no book with such specifications :( ");	
		}
		else
		{	
		for (Book books:  bookResult) {
		
			LOGGER.info(books.getBookTitle() + books.getBookAuthor() + books.getBookISBN10() + books.getBookSignature());
			
		}
		}
		
		return   bookResult;
	}
	public boolean loggedin() {
		
		return true;
	}
	
	
	

	
	public List<Book> byTitle(String type) {
		 spec = new ByTitleSpec(type);
		
		 
		
		return checkSpec(spec);
	}
	
	public List<Book> byAuthor(String type) {
		 spec = new ByAuthor(type);
		
		 
		
		return checkSpec(spec);
	}
	
	public List<Book> byISBN(String type) {
		 spec = new ByISBN(type);
		
		 
		
		return checkSpec(spec);
	}
	public List<Book> bySig(String type) {
		 spec = new BySig(type);
		
		 
		
		return checkSpec(spec);
	}
	
	
	
	
	
	public List<Book> checkSpec(GeneralSpec spec) {
		
		
		for(Book a:bookArray1 )
			{
			
			if (spec.isSpecMatch(a))
			{
		
		      LOGGER.info( "\n");
			
				bookResult.add(a);
			}
			
			
		}
		return  bookResult;
	}

}
