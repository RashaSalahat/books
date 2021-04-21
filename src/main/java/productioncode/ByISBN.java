package productioncode;

public class ByISBN implements GeneralSpec{
	private String type;

	public ByISBN(String type) {
		this.type = type;
	
	}
	
	public boolean isSpecMatch(Book book) {
		
		return ((book.getBookISBN10()).contains(this.type));
	}
	
	
	
}