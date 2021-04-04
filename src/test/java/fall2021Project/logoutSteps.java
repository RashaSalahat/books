package fall2021Project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import productioncode.Admin;
import productioncode.Admins;

public class logoutSteps  {
	Admin admin1;
	Admins listAdmins;
	boolean flack=true;

	public logoutSteps(Admin admin,Admins listAdmins)
	{
		this.admin1=admin;
		this.listAdmins=listAdmins;
	}
	

	@Given("The admins informations username and password is stored in the DataBase and status of login is \\({string}) into the library website")
	public void the_admins_informations_username_and_password_is_stored_in_the_data_base_and_status_of_login_is_into_the_library_website(String Admin_state, io.cucumber.datatable.DataTable table) 
	{
		 List<String> admin=table.transpose().asList();
		 boolean state;
		 listAdmins= new Admins();
	     state=Boolean.parseBoolean(Admin_state);
		 
         for (int i=0;i<3;i++)
	      {   
        	 listAdmins.addAdmin(table.cell(i,0), table.cell(i,1), state);
      	    
      	 
	      }
	}

   
	@When("admin has {string} and {string} press to logout button so it become status of button is \\({string})")
	public void admin_has_and_press_to_logout_button_so_it_become_status_of_button_is(String Admin_username, String Admin_password, String buttonState) 
	{
		  boolean Bstate;
		   Bstate=Boolean.parseBoolean(buttonState);
		for (int i=0;i<listAdmins.admins.size();i++)
	    {    
			
		
			if(listAdmins.logState(Admin_username, Admin_password))
		   {   if (Bstate==true)
		  { 
		   flack=false;
		   admin1.setflacklogin(false);
		  }
		   }
	   }
	}


	@Then("admin status of login is \\({string}) into the library website and logout successful")
	public void admin_status_of_login_is_into_the_library_website_and_logout_successful(String Admin_state)
	{
		boolean state;
		state=Boolean.parseBoolean(Admin_state);
		assertTrue(flack==state);
	
	}
	



}
