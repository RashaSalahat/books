Feature: Admin_login
Background:
Given  The admins informations username and password is stored in the DataBase like
   |ola@gmail.com  |ola456 |
   |amna@gmail.com |amna123|
   |rasha@gmail.com|rash321|
   
@a
Scenario Outline: Administrator can log in with valid credentials

When  Admin fill username as <username> and password as <password>
Then the flack should be "true" and the admin login to the home page successfully
Examples:
|username|password|
|"amna@gmail.com"|"amna123"|
|"rasha@gmail.com"|"rash321"|
|"ola@gmail.com"|"ola456"|

@a
Scenario Outline:  Administrator has the wrong password
When Admin fill username as <username> and password as <passwordwrong>
Then the flack should be "false" and error message displayed with invalid password 
Examples:
|username|passwordwrong|
|"amna@gmail.com"|"amna"|
|"rasha@gmail.com"|"rasha"|
|"ola@gmail.com"|"ola"|
