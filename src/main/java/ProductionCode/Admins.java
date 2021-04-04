package ProductionCode;

import java.util.ArrayList;
import java.util.List;

public class Admins extends Admin {
Admin admin1;
public List<Admin> admins=new ArrayList <Admin>();
public void addAdmin(String username_value,String password_value,boolean flack_login )	
{
	    
   	admin1=new Admin();
   	admin1.setAdmin_username(username_value);
   	admin1.setAdmin_password(password_value);
   	 admin1.setflack_login(flack_login );
   	admins.add(admin1);
 
}

public boolean checkAdmin(String Admin_username, String Admin_password) {
	 String adminState;
	 for (int i=0;i<admins.size();i++)
	    {
    
	    adminState=	(admins.get(i).checkvalid(Admin_username, Admin_password));
	    	
		if(adminState.equals("true"))
		{
			admins.get(i).setflack_login(true);	
			return true;
		   	
		}
		else
		{	
			admins.get(i).setflack_login(false); 
			
		}
		
}
	 return false;
	 
}

public boolean logState(String Admin_username, String Admin_password) {
	 for (int i=0;i<admins.size();i++)
	    {
		 if(admins.get(i).getAdmin_username().equals(Admin_username) && 
				 admins.get(i).getAdmin_password().equals(Admin_password)&&
				 admins.get(i).getflack_login()==true)
		     return true;
		 
	    }
	 return false;
}


}
