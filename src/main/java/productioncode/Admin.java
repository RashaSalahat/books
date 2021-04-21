package productioncode;

public class Admin {
	private String adminusername;
	private String adminpassword;
	private boolean flacklogin;

	//set and get method for username
	public void setAdminUsername(String usernamevalue)
	{
		adminusername=usernamevalue;
	}
	public String getAdminUsername()
	{
		return adminusername;
	}

	//set and get method for password
	public void setAdminPassword(String passwordValue)
	{
		adminpassword=passwordValue;
	}
	public String getAdminPassword()
	{
		return adminpassword;
	}

	//set and get for flack_login 
	public void setflacklogin (boolean flackLoginValue)
	{
		flacklogin =flackLoginValue;
	}
	public boolean getflacklogin()
	{
		return flacklogin;
	}



	public String checkvalid(String s1, String s2) {
	    if ((adminusername.equals(s1))&&(adminpassword.equals(s2)))
	     return "true";
	    else if ((adminusername.equals(s1)))
	    	return "false";
	    else return "non";
	    
	}


}