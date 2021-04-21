package productioncode;

public class BySig implements GeneralSpec {
	private String type;

	public BySig(String type) {
		this.type = type;
	
	}
	
	public boolean isSpecMatch(Book book) {

		return extracted(book);
	}

	private boolean extracted(Book book) {
		return (book.getBookISBN10()).contains(this.type);
	}
	

}
