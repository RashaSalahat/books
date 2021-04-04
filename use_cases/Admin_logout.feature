Feature: Admin logout
@b
Scenario Outline: Administrator logs out   
Given  The admins informations username and password is stored in the DataBase and status of login is ("true") into the library website 
   |ola@gmail.com  |ola456 |
   |amna@gmail.com |amna123|
   |rasha@gmail.com|rash321|
When admin has <username> and <password> press to logout button so it become status of button is ("true")
Then admin status of login is ("false") into the library website and logout successful
Examples:
|username|password|
|"amna@gmail.com"|"amna123"|
|"rasha@gmail.com"|"rash321"|
|"ola@gmail.com"|"ola456"|
