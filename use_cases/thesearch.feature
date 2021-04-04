Feature: Search about some books
Background:
The System has a repository of books with their specifications (title-author-signature-ISBN) 
	Given  these books are contained in the system 
|The Linux Programming Interface_Michael Kerrisk_Kerrisk2010_1593272200|
|Programming Rust: Fast, Safe Systems Development Paperback_Jim Blandy_Blandy2018_1491927283|
|Righting Software_Juval Löwy_Löwy2020_0136524036|



@d
Scenario Outline: search about books for a substring of the title
When I search about book by using a substring <TheTitle> 
Then books that contain a substring of the title should be returned and printed on the console 
Examples:
|TheTitle|
|"The Linux Programming Interface"|
|"Programming Rust: Fast, Safe Systems Development Paperback"|
|"Righting Software"|
|"Programming"|

@d
Scenario Outline: search books for a substring of the author
When I search about books by its  <Author> 
Then book that contain a substring of the author should be returned and printed on the console 
Examples:
|Author|
|"Michael Kerrisk"|
|"Jim Blandy"|
|"Juval Löwy"|
|"Jim"|
|"J"|


@d
Scenario Outline: search about books for a substring of the ISBN
When I search about  books by the book's <ISBN> 
Then books that contain a substring of the ISBN should be returned and printed on the console 
Examples:
|ISBN|
|"1593272200"|
|"1491927283"|
|"0136524036"|
|"1"|
|"272"|


@d
Scenario Outline: search books for a substring of the title when the user/administrator is logged in
Given administrator/user is logged in 
When admininstrator/user search about a book by <TheTitle> 
Then a book that contains a substring of the title should be returned and printed 
Examples:
|TheTitle|
|"The Linux Programming Interface"|
|"Programming Rust: Fast, Safe Systems Development Paperback"|
|"Righting Software"|
|"Programming"|


@d
Scenario Outline: search books for a substring of the author when the user/administrator is logged in
Given administrator/user is logged in to search using the book's author
When admininstrator/user search about a book by the book's <Author> 
Then books that contains a substring of the author should be returned and printed 
Examples:
|Author|
|"Michael Kerrisk"|
|"Jim Blandy"|
|"Juval Löwy"|
|"Jim"|
|"J"|

@d
Scenario Outline: search books for a substring of the ISBN when the user/administrator is logged in
Given administrator/user is logged in to search using the book's ISBN
When admininstrator/user search about a book by the book <ISBN> 
Then books that contains a substring of the ISBN should be returned and printed 
Examples:
|ISBN|
|"1593272200"|
|"1491927283"|
|"0136524036"|
|"1"|
|"272"|


@d
Scenario Outline: search books for a substring of the Signature when the user/administrator is logged in
Given administrator/user is logged in to search using the book's Signature
When admininstrator/user search about a book usingg  <Signature> 
Then books that contains a substring of the Signature should be returned and printed 
Examples: 
|Signature|
|"Kerrisk2010"|
|"Blandy2018"|
|"Löwy2020"|
|"er"|
|"20"|
|"2010"|


@d
Scenario Outline: No books match the critera
When I search about a book using the book's <TheTitle> 
Then there would be no matches, there are no books in the system match the entered title
Examples:
|TheTitle|
|"rasha book"|
|"folklore"|
|"cardigan"|

@d
Scenario Outline: No books match the critera by searching for author
When I search about a book written by <Author> 
Then there would be no matches, there are no books in the system match the entered author
Examples:
|Author|
|"rasha"|
|"george"|
|"taylor"|


@d
Scenario Outline: No books match the critera by searching for ISBN
When I search about a book having <ISBN> 
Then there would be no matches, there are no books in the system match the entered ISBN
Examples:
|ISBN|
|"0482573921"|
|"234567876"|
|"098765431345"|

@d
Scenario Outline: No books match the critera by searching for signature
When I search about a book by their unique <Signature> 
Then there would be no matches, there are no books in the system match the entered signature
Examples:
|Signature|
|"Kerrisssk2010"|
|"Blandyyy2018"|
|"Löwyyyy2020"|


@d
Scenario Outline: Find more than one book
When I search about a book by their <TheTitle> 
Then there would more than one match ,the consol will print all of them
Examples:
|TheTitle|
|"The Linux Programming Interface"|
|"Programming Rust: Fast, Safe Systems Development Paperback"|
|"Righting Software"|
|"The"|
|"Programming"|


@d
Scenario Outline: Find more than one book with the same author
When I search about books with an <Author> 
Then there would more than one match ,the consol will print all of the books
Examples:
|Author|
|"Michael Kerrisk"|
|"Jim Blandy"|
|"Juval Löwy"|
|"Jim"|
|"J"|