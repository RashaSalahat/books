package fall2021Project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import productioncode.Book;
import productioncode.GeneralSpec;
import productioncode.Search;

public class thesearchsteps {
	
	public ArrayList<Book> books=new ArrayList<Book>();
	boolean fadmin;
	Book book;
	String authora;
	String authorm;
	String sig;
	String sigm;
	String matcha;
	String ISBNa;
	String ISBN2;
	String title;
	String title2;
	String title3;
	String titlea;
	boolean flag;
	String author;
	String ISBN;
	String ras;
	boolean exist;
	public List<GeneralSpec> specList = new ArrayList<GeneralSpec>();
	
    private static Search  search;
	public thesearchsteps(Search search)
	{
		this.search=search;
		
		
	}
	
	
	@Given("these books are contained in the system")
	public void these_books_are_contained_in_the_system(io.cucumber.datatable.DataTable dataTable)  {
		List<List<String>> data =dataTable.asLists();
		for (int i = 0; i < data.size(); i++) {
			List<String> list = data.get(i);
			String l1 = list.get(0);
			String[] t1 = l1.split("_");
			 book=new Book();
			book.setBookTitle(t1[0]);
			ras=t1[0];
			
			book.setBookAuthor(t1[1]);
			book.setBookSignature(t1[2]);
			book.setBookISBN10(t1[3]);
			books.add(book);
			
			
		}
		
		
	 search = new Search((ArrayList<Book>) books);
		
	}
	List<Book> all=new ArrayList<Book>();
	
	@When("I search about book by using a substring {string}")
	public void i_search_about_book_by_using_a_substring(String string) {
		title=string;
	}

	@Then("books that contain a substring of the title should be returned and printed on the console")
	public void books_that_contain_a_substring_of_the_title_should_be_returned_and_printed_on_the_console() {
		System.out.println("Search by Title: "+title);
		all.clear();
		all.addAll(search.byTitle(title));
		for(Book i:all)
		{
			assertTrue(i.getBookTitle().contains(title));
			
		}
		
		search.printResult();
	
	}
	@When("I search about books by its  {string}")
	public void i_search_about_books_by_its(String string) {
		author=string;
	}

	@Then("book that contain a substring of the author should be returned and printed on the console")
	public void book_that_contain_a_substring_of_the_author_should_be_returned_and_printed_on_the_console() {
		System.out.println("Search by Author: "+author);
		all.clear();
		all.addAll(search.byAuthor(author));
		for(Book i:all)
		{
			assertTrue(i.getBookAuthor().contains(author));
		
	}
		search.printResult();
		
	}
	
	@When("I search about  books by the book's {string}")
	public void i_search_about_books_by_the_book_s(String string) {
		ISBN=string;
	}

	@Then("books that contain a substring of the ISBN should be returned and printed on the console")
	public void books_that_contain_a_substring_of_the_isbn_should_be_returned_and_printed_on_the_console() {
		System.out.println("Search by ISBN: "+ISBN);
		all.clear();
		all.addAll(search.byISBN(ISBN));
		for(Book i:all)
		{
		
			assertTrue(i.getBookISBN10().contains(ISBN));
	}
		search.printResult();
		
	
	}
	@Given("administrator\\/user is logged in")
	public void administrator_user_is_logged_in() {
		fadmin =search.loggedin();
	}

	@When("admininstrator\\/user search about a book by {string}")
	public void admininstrator_user_search_about_a_book_by(String string) {
		titlea=string;
	}

	@Then("a book that contains a substring of the title should be returned and printed")
	public void a_book_that_contains_a_substring_of_the_title_should_be_returned_and_printed() {
		System.out.println("Search by Title: "+titlea);
		all.clear();
		all.addAll(search.byTitle(titlea));
		for(Book i:all)
		{
			
			assertTrue(i.getBookTitle().contains(titlea));
			
		}
	
		
		search.printResult();
	}
	
	@Given("administrator\\/user is logged in to search using the book's author")
	public void administrator_user_is_logged_in_to_search_using_the_book_s_author() {
		fadmin =search.loggedin();
	}

	@When("admininstrator\\/user search about a book by the book's {string}")
	public void admininstrator_user_search_about_a_book_by_the_book_s(String string) {
	  authora=string;
	}

	@Then("books that contains a substring of the author should be returned and printed")
	public void books_that_contains_a_substring_of_the_author_should_be_returned_and_printed() {
		System.out.println("Search by Author: "+authora);
		all.clear();
		all.addAll(search.byAuthor(authora));
		for(Book i:all)
		{
			assertTrue(i.getBookAuthor().contains(authora));
		
	}
		search.printResult();
	}
	
	@Given("administrator\\/user is logged in to search using the book's ISBN")
	public void administrator_user_is_logged_in_to_search_using_the_book_s_isbn() {
		
		 fadmin =search.loggedin();
	}

	@When("admininstrator\\/user search about a book by the book {string}")
	public void admininstrator_user_search_about_a_book_by_the_book(String string) {
     ISBNa=string;
	}

	@Then("books that contains a substring of the ISBN should be returned and printed")
	public void books_that_contains_a_substring_of_the_isbn_should_be_returned_and_printed() {
		System.out.println("Search by ISBN: "+ISBNa);
		all.clear();
		all.addAll(search.byISBN(ISBNa));
		for(Book i:all)
		{
		
			assertTrue(i.getBookISBN10().contains(ISBNa));
	}
		search.printResult();
	}
	@Given("administrator\\/user is logged in to search using the book's Signature")
	public void administrator_user_is_logged_in_to_search_using_the_book_s_signature() {
		 fadmin =search.loggedin();
	}

	@When("admininstrator\\/user search about a book usingg  {string}")
	public void admininstrator_user_search_about_a_book_usingg(String string) {
	   sig=string;
	}

	@Then("books that contains a substring of the Signature should be returned and printed")
	public void books_that_contains_a_substring_of_the_signature_should_be_returned_and_printed() {
		System.out.println("Search by Sig: "+sig);
		all.clear();
		all.addAll(search.bySig(sig));
		for(Book i:all)
		{
		
			assertTrue(i.getBookSignature().contains(sig));
	}
		search.printResult();
	}
	
	@When("I search about a book using the book's {string}")
	public void i_search_about_a_book_using_the_book_s(String string) {
	   title2=string;
	}

	@Then("there would be no matches, there are no books in the system match the entered title")
	public void there_would_be_no_matches_there_are_no_books_in_the_system_match_the_entered_title() {
		System.out.println("Search by title: "+title2);
		all.clear();
		all.addAll(search.byTitle(title2));
	
			
	assertEquals(0,all.size());
		
		
			
	
		search.printResult();
	}
	@When("I search about a book written by {string}")
	public void i_search_about_a_book_written_by(String string) {
	 matcha=string;
	}

	@Then("there would be no matches, there are no books in the system match the entered author")
	public void there_would_be_no_matches_there_are_no_books_in_the_system_match_the_entered_author() {
		System.out.println("Search by Author: "+matcha);
		all.clear();
		all.addAll(search.byAuthor(matcha));
		assertEquals(0,all.size());
		search.printResult();
	}
	
	@When("I search about a book having {string}")
	public void i_search_about_a_book_having(String string) {
	  ISBN2=string;
	}

	@Then("there would be no matches, there are no books in the system match the entered ISBN")
	public void there_would_be_no_matches_there_are_no_books_in_the_system_match_the_entered_isbn() {
		System.out.println("Search by ISBN: "+ISBN2);
		all.clear();
		all.addAll(search.byISBN(ISBN2));
		assertEquals(0,all.size());
		search.printResult();
		
	}
	@When("I search about a book by their unique {string}")
	public void i_search_about_a_book_by_their_unique(String string) {
	   sigm=string;
	}

	@Then("there would be no matches, there are no books in the system match the entered signature")
	public void there_would_be_no_matches_there_are_no_books_in_the_system_match_the_entered_signature() {
		System.out.println("Search by Sig: "+sigm);
		all.clear();
		all.addAll(search.bySig(sigm));
		assertEquals(0,all.size());
		search.printResult();
	}
	
	@When("I search about a book by their {string}")
	public void i_search_about_a_book_by_their(String string) {
	   title3=string;
	}

	@Then("there would more than one match ,the consol will print all of them")
	public void there_would_more_than_one_match_the_consol_will_print_all_of_them() {
		System.out.println("Search by Title: "+title3);
		all.clear();
		all.addAll(search.byTitle(title3));
		for(Book i:all)
		{
			
			assertTrue(i.getBookTitle().contains(title3));
			
		}
		search.printResult();
	}
	@When("I search about books with an {string}")
	public void i_search_about_books_with_an(String string) {
	    authorm=string;
	}

	@Then("there would more than one match ,the consol will print all of the books")
	public void there_would_more_than_one_match_the_consol_will_print_all_of_the_books() {
		System.out.println("Search by Author: "+authorm);
		all.clear();
		all.addAll(search.byAuthor(authorm));
		for(Book i:all)
		{
			assertTrue(i.getBookAuthor().contains(authorm));
		
	}
		search.printResult();	
	}
}