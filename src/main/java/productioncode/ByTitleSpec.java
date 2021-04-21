package productioncode;


public class ByTitleSpec implements GeneralSpec {
	private String type;

	public ByTitleSpec(String type) {
		this.type = type;
	
	}
	
	public boolean isSpecMatch(Book book) {
		
		return ((book.getBookTitle()).contains(this.type));
	}
	
	
}
