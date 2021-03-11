package fall2021Project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import ProductionCode.Admin;
import ProductionCode.Book;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddBookSteps {

	public ArrayList<Admin> admins=new ArrayList<Admin>();
	public ArrayList<Book> books=new ArrayList<Book>();
	Book book;
	Book book1;
	Admin admin1;
    String bookState_Exist="Existing";
    String bookState_Unexist="Unexisting";
    String MSG;
	
	public AddBookSteps(Book book,Admin admin)
	{
		this.book=book;
		this.book1=book;
		this.admin1=admin;
	}

	@Given("The admins informations and books is stored in the DataBase")
	public void The_admins_informations_and_books_is_stored_in_the_DataBase (io.cucumber.datatable.DataTable table) 
	{
		 List<String> admin=table.transpose().asList();
	       
         for (int i=0;i<3;i++)
	      {   
      	     admin1=new Admin();
      	     admin1.setAdmin_username(table.cell(i,0));
      	     admin1.setAdmin_password(table.cell(i,1));
      	     admin1.setflack_login(false);
      	     admins.add(admin1);
	      }
         for (int i=0; i<3;i++)
         {
        	 book1 =new Book();
        	 book1.setBookTitle(table.cell(i, 2));
   		     book1.setBookAuthor(table.cell(i, 3));
   		     book1.setBookSignature(table.cell(i, 4));
   		     book1.setBookISBN_10(table.cell(i, 5));
   		     book1.setBookState("Existing");
   		     books.add(book1);
   		    
         }
        	 
	}



	@When("the admin have {string} and {string} and status of login is \\({string}) into the library website and fill {string} of book and {string} and {string} and {string}")
	public void the_admin_have_and_and_status_of_login_is_into_the_library_website_and_fill_of_book_and_and_and(String Admin_username, String Admin_password,
			String Admin_state,String titleBook,String authorBook, String signuature, String ISBN)
	{
		  book.setBookTitle(titleBook);
		  book.setBookAuthor(authorBook);
		  book.setBookSignature(signuature);
		  book.setBookISBN_10(ISBN);
		  book.setBookState("NON");
		  if(book.validISBN(ISBN)==true)
		  {   
			  boolean state;    
	      state=Boolean.parseBoolean(Admin_state);
		 
		  for(int j=0; j<admins.size();j++)
			 {
				if(admins.get(j).getAdmin_username().equals(Admin_username) && admins.get(j).getAdmin_password().equals(Admin_password))
				{
					if(state==true)
					{	
					 for(int i=0; i<books.size();i++) 
						{
							
							if( (books.get(i).getBookISBN_10().equals(ISBN)) ||( books.get(i).getBookSignature().equals(signuature)))
							{    
								book.setBookState(bookState_Unexist);
								break;
							}
							else book.setBookState(bookState_Exist);
							 System.out.print("invalid ISBN or Signature");
					    }
					}
					else book.setBookState(bookState_Unexist);
					System.out.print("Admin must be logged in");
				}
			 }
		  }
		  else 
			  {
			  book.setBookState(bookState_Unexist);
			  System.out.print("invalid ISBN");
			  }
	}
	
	

	 @Then("The state of book  should be \\({string}) and add successfuly")
	   public void the_state_of_book_should_be_and_add_successfuly(String bookState) 
		{
	    assertTrue(bookState.equals(book.getBookState()));
	   
	    } 
	 //when admin logout
	 
     @Then("the admin can't add book should be\\({string}) and warining message \\({string})display")
           public void the_admin_can_t_add_book_should_be_and_warining_message_display(String bookState, String msg) 
              {
        	 assertTrue((bookState.equals(book.getBookState())));
        	 System.out.print(" "+msg);
                  }



	
	


}
