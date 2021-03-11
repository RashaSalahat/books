package fall2021Project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.picocontainer.annotations.Inject.*;

import ProductionCode.Admin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class loginSteps {
	public ArrayList<Admin> admins=new ArrayList<Admin>();
	
	public boolean expected;
	public String Admin_pass;
	Admin admin1;
	public String adminState;
	public boolean flack;

	public  loginSteps (Admin admin1)
	{
		this.admin1=admin1;
	}


	
	@Given("The admins informations username and password is stored in the DataBase like")
	public void the_admins_informations_username_and_password_is_stored_in_the_data_base_like(io.cucumber.datatable.DataTable table)
	 {     List<String> admin=table.transpose().asList();
	       
           for (int i=0;i<3;i++)
	      {   
        	admin1=new Admin();
        	admin1.setAdmin_username(table.cell(i,0));
        	admin1.setAdmin_password(table.cell(i,1));
        	 admin1.setflack_login(false);
        	admins.add(admin1);
	      }
        
	 }

       @When("Admin fill username as {string} and password as {string}")
	   public void admin_fill_username_as_and_password_as(String Admin_username, String Admin_password) 
	   { 
		
		    for (int i=0;i<admins.size();i++)
		    {

		    adminState=	(admins.get(i).checkvalid(Admin_username, Admin_password));
		    	
			if(adminState.equals("true"))
			{
				admins.get(i).setflack_login(true);
				flack=true;
			
				
			}
			else if(adminState.equals("false"))
			{	
				admins.get(i).setflack_login(false); 
				flack=false;
			
				
			}
			
	   }
	}

       @Then("the flack should be {string} and the admin login to the home page successfully")
       public void the_flack_should_be_and_the_admin_login_to_the_home_page_successfully(String adminState)
       {
    	   
    	   expected=Boolean.parseBoolean(adminState);
		   assertTrue(expected==flack); 
       }
         

       @Then("the flack should be {string} and error message displayed with invalid password")
       public void the_flack_should_be_and_error_message_displayed_with_invalid_password(String adminState)
       {
    	  
    	   expected=Boolean.parseBoolean(adminState);
		   assertTrue(expected==flack);
		   System.out.print("Your password wrong please try again");
       }



}

