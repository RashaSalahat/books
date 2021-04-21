package productioncode;

import java.util.ArrayList;
import java.util.List;

public class Admins extends Admin {
Admin admin1;
private List<Admin> listadmin=new ArrayList <Admin>();
public void setlistadmin(List<Admin> listadminValue) {
	listadmin=listadminValue;
}
public List<Admin> getlistadmin()
{
	return listadmin;
}
public void addAdmin(String usernamevalue,String passwordvalue,boolean flacklogin )	
{
	    
   	admin1=new Admin();
   	admin1.setAdminUsername(usernamevalue);
   	admin1.setAdminPassword(passwordvalue);
   	 admin1.setflacklogin(flacklogin );
   	listadmin.add(admin1);
 
}

public boolean checkAdmin(String adminusername, String adminpassword) {
	 String adminState;
	 for (int i=0;i<listadmin.size();i++)
	    {
    
	    adminState=	(listadmin.get(i).checkvalid(adminusername, adminpassword));
	    	
		if(adminState.equals("true"))
		{
			listadmin.get(i).setflacklogin(true);	
			return true;
		   	
		}
		else
		{	
			listadmin.get(i).setflacklogin(false); 
			
		}
		
}
	 return false;
	 
}

public boolean logState(String adminusername, String adminpassword) {
	 for (int i=0;i<listadmin.size();i++)
	    {
		 if(listadmin.get(i).getAdminUsername().equals(adminusername) && 
				 listadmin.get(i).getAdminPassword().equals(adminpassword)&&
				 listadmin.get(i).getflacklogin())
		     return true;
		 
	    }
	 return false;
}


}