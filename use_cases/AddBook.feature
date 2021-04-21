@c
Feature: Add book
Background:
Given  The admins informations and books is stored in the DataBase 
   |ola@gmail.com  |ola456 |The Linux Programming Interface                           |Michael Kerrisk|Kerrisk2010|1593272200|
   |amna@gmail.com |amna123|Programming Rust: Fast, Safe Systems Development Paperback|Jim Blandy     |Blandy2018 |1491927283|
   |rasha@gmail.com|rash321|Righting Software                                         |Juval Löwy     |Löwy2020   |0136524036|
   
Scenario Outline: Add a book when the administrator is logged in 
When the admin have <user> and <pass> and status of login is ("true") into the library website and fill <TheTitle> of book and <Author> and <Signature> and <ISBN> 
Then The state of book  should be ("Existing") and add successfuly
Examples: 
|user|pass|TheTitle|Author|Signature|ISBN|
|"amna@gmail.com"|"amna123"|"The Four Winds: A Novel"|"Kristin Hannah"|"Kristin2021"|"1250178606"|
|"rasha@gmail.com"|"rash321"|"Who is Maud Dixon?"|"Alexandra Andrews"|"Alexandra2021"|"0316500313"|
|"ola@gmail.com"|"ola456"|"Too Good to Be True:"|"Carola Lovering"|"Carola2021"|"1250271371"|


Scenario Outline: Add a book when the administrator is not logged in
When the admin have <user> and <pass> and status of login is ("false") into the library website and fill <TheTitle> of book and <Author> and <Signature> and <ISBN> 
Then the admin can't add book should be("Unexisting") and warining message ("please login then try again")display 
Examples: 
|user|pass|TheTitle|Author|Signature|ISBN|
|"amna@gmail.com"|"amna123"|"The Linux Programming Interface" |"Michael Kerrisk"|"Kerrisk2010"|"1593272200"|
|"rasha@gmail.com"|"rash321"|"Programming Rust: Fast, Safe Systems Development Paperback"|"Jim Blandy"|"Blandy2018"|"1491927283"|
|"ola@gmail.com"|"ola456"|"Righting Software"|"Juval Löwy"|"Löwy2020"|"0136524036"|