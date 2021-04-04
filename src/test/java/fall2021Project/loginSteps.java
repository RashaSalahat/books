package fall2021Project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.picocontainer.annotations.Inject.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import productioncode.Admin;
import productioncode.Admins;


public class loginSteps {

	public Admins listAdmins;
	public boolean expected;
	public String Admin_pass;
	Admin admin1;

	public boolean flack;

	public  loginSteps (Admin admin1,Admins listAdmins)
	{
		this.admin1=admin1;
		this.listAdmins=listAdmins;
	}


	
	@Given("The admins informations username and password is stored in the DataBase like")
	public void the_admins_informations_username_and_password_is_stored_in_the_data_base_like(io.cucumber.datatable.DataTable table)
	 {     List<String> admin=table.transpose().asList();
	       listAdmins=new Admins();
           for (int i=0;i<3;i++)
	      {   
        	   listAdmins.addAdmin(table.cell(i,0), table.cell(i,1), false);
        	
	      }
        
	 }

       @When("Admin fill username as {string} and password as {string}")
	   public void admin_fill_username_as_and_password_as(String Admin_username, String Admin_password) 
	   { 
    	   flack=listAdmins.checkAdmin(Admin_username, Admin_password);
		
    	   
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

