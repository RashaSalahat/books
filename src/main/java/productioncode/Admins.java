package productioncode;

import java.util.ArrayList;
import java.util.List;

public class Admins extends Admin {
Admin admin1;
public List<Admin> admins=new ArrayList <Admin>();
public void addAdmin(String username_value,String password_value,boolean flack_login )	
{
	    
   	admin1=new Admin();
   	admin1.setAdminUsername(username_value);
   	admin1.setAdminPassword(password_value);
   	 admin1.setflacklogin(flack_login );
   	admins.add(admin1);
 
}

public boolean checkAdmin(String Admin_username, String Admin_password) {
	 String adminState;
	 for (int i=0;i<admins.size();i++)
	    {
    
	    adminState=	(admins.get(i).checkvalid(Admin_username, Admin_password));
	    	
		if(adminState.equals("true"))
		{
			admins.get(i).setflacklogin(true);	
			return true;
		   	
		}
		else
		{	
			admins.get(i).setflacklogin(false); 
			
		}
		
}
	 return false;
	 
}

public boolean logState(String Admin_username, String Admin_password) {
	 for (int i=0;i<admins.size();i++)
	    {
		 if(admins.get(i).getAdminUsername().equals(Admin_username) && 
				 admins.get(i).getAdminPassword().equals(Admin_password)&&
				 admins.get(i).getflacklogin()==true)
		     return true;
		 
	    }
	 return false;
}


}
