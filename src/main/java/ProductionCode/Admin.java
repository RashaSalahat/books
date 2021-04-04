package ProductionCode;

public class Admin {
private String Admin_username;
private String Admin_password;
private boolean flack_login;

//set and get method for username
public void setAdmin_username(String username_value)
{
	Admin_username=username_value;
}
public String getAdmin_username()
{
	return Admin_username;
}

//set and get method for password
public void setAdmin_password(String password_value)
{
	Admin_password=password_value;
}
public String getAdmin_password()
{
	return Admin_password;
}

//set and get for flack_login 
public void setflack_login (boolean flack_login_value)
{
	flack_login =flack_login_value;
}
public boolean getflack_login()
{
	return flack_login;
}



public String checkvalid(String s1, String s2) {
    if ((Admin_username.equals(s1))&&(Admin_password.equals(s2)))
     return "true";
    else if ((Admin_username.equals(s1))&& !(Admin_password.equals(s2)))
    	return "false";
    else return "non";
    
}


}
