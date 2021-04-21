package productioncode;

public class ByAuthor implements GeneralSpec{
	private String type;

	public ByAuthor(String type) {
		this.type = type;
	
	}
	
	public boolean isSpecMatch(Book book) {
		
		return ((book.getBookAuthor()).contains(this.type));
	}
	
	
	
}
