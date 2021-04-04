package fall2021Project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import productioncode.Admin;
import productioncode.Admins;
import productioncode.Book;
import productioncode.Books;

public class AddBookSteps {

	
	public ArrayList<Book> books=new ArrayList<Book>();
	Book book;
	Admins listAdmins;
	Books listBooks1;
    String bookState_Exist="Existing";
    String bookState_Unexist="Unexisting";
    String MSG;
    int i;
	
	public AddBookSteps(Admins listAdmins,Books listBooks1)
	{

		this.listAdmins=listAdmins;
		this.listBooks1=listBooks1;
		
	}

	@Given("The admins informations and books is stored in the DataBase")
	public void The_admins_informations_and_books_is_stored_in_the_DataBase (io.cucumber.datatable.DataTable table) 
	{
		 List<String> admin=table.transpose().asList();
		 listAdmins=new Admins();
	       
         for (int i=0;i<3;i++)
	      {   
        	 listAdmins.addAdmin(table.cell(i,0), table.cell(i,1), false);
      	   
        	 
	      }
         for (int i=0; i<3;i++)
         {
        	 listBooks1.addBook(table.cell(i, 2), table.cell(i, 3), table.cell(i, 4), table.cell(i, 5), "Existing");
        	
        	
         }
         
	}



	@When("the admin have {string} and {string} and status of login is \\({string}) into the library website and fill {string} of book and {string} and {string} and {string}")
	public void the_admin_have_and_and_status_of_login_is_into_the_library_website_and_fill_of_book_and_and_and(String Admin_username, String Admin_password,
			String Admin_state,String titleBook,String authorBook, String signuature, String ISBN)
	{

	 
		listBooks1.addBook(titleBook, authorBook,signuature, ISBN,"NON" ); 

		
		 i=listBooks1.findBook(titleBook, authorBook, signuature, ISBN);
	   
		  if(listBooks1.getlistbooks().get(i).validISBN(ISBN)==true)
		  {   
			  boolean state;    
	      state=Boolean.parseBoolean(Admin_state);
		 
		  for(int j=0; j<listAdmins.getlistadmin().size();j++)
			 {
		
			  if(listAdmins.checkAdmin(Admin_username, Admin_password))
				{
					if(state==true)
					{	
			
						    if(listBooks1.isExistISBNSig(ISBN, signuature,listBooks1.getlistbooks(),titleBook))
							{    
								
								System.out.print("invalid ISBN or Signuature");
								break;
							}
							else listBooks1.getlistbooks().get(i).setBookState(bookState_Exist);
					 
					}
					else {
					      
						listBooks1.getlistbooks().get(i).setBookState(bookState_Unexist);
						
					   }
				}
			 }
		  }
		  else 
			  {
			  listBooks1.getlistbooks().get(i).setBookState(bookState_Unexist);
			  System.out.print("invalid ISBN");
			  }
	}
	
	

	 @Then("The state of book  should be \\({string}) and add successfuly")
	   public void the_state_of_book_should_be_and_add_successfuly(String bookState) 
		{
	    assertTrue(bookState.equals(  listBooks1.getlistbooks().get(i).getBookState()));
	   
	    } 
	 //when admin logout
	 
     @Then("the admin can't add book should be\\({string}) and warining message \\({string})display")
           public void the_admin_can_t_add_book_should_be_and_warining_message_display(String bookState, String msg) 
              {
    	 assertEquals(bookState , listBooks1.getlistbooks().get(i).getBookState());
        	 System.out.print(" "+msg);
                  }



	
	


}
