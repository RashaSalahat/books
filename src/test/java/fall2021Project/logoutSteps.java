package fall2021Project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import ProductionCode.Admin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class logoutSteps  {
	Admin admin1;
	boolean flack=true;
	public ArrayList<Admin> admins=new ArrayList<Admin>();
	public logoutSteps(Admin admin)
	{

		this.admin1=admin;
	}
	

	@Given("The admins informations username and password is stored in the DataBase and status of login is \\({string}) into the library website")
	public void the_admins_informations_username_and_password_is_stored_in_the_data_base_and_status_of_login_is_into_the_library_website(String Admin_state, io.cucumber.datatable.DataTable table) 
	{
		 List<String> admin=table.transpose().asList();
		 boolean state;
	     state=Boolean.parseBoolean(Admin_state);
         for (int i=0;i<3;i++)
	      {   
      	    admin1=new Admin();
      	    admin1.setAdmin_username(table.cell(i,0));
        	admin1.setAdmin_password(table.cell(i,1));
        	 admin1.setflack_login(state);
      	    admins.add(admin1);
	      }
	}

   
	@When("admin has {string} and {string} press to logout button so it become status of button is \\({string})")
	public void admin_has_and_press_to_logout_button_so_it_become_status_of_button_is(String Admin_username, String Admin_password, String buttonState) 
	{
		  boolean Bstate;
		   Bstate=Boolean.parseBoolean(buttonState);
		for (int i=0;i<admins.size();i++)
	    {    
			
		   if (admins.get(i).getAdmin_username().equals(Admin_username) && admins.get(i).getAdmin_password().equals(Admin_password)&&admins.get(i).getflack_login()==true)
		   {   if (Bstate==true)
		  { 
		   flack=false;
		   admin1.setflack_login(false);
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
