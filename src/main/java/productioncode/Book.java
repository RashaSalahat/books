package productioncode;

public class Book {
private String bookTitle;
private String bookAuthor;
private String bookSignature;
private String bookISBN10;
private String bookState;
//set and get methods  bookTitle
public void setBookTitle(String bookTitlevalue)
{
	bookTitle=bookTitlevalue;
}
public String getBookTitle()
{
	return bookTitle;
}

//set and get methods bookAuthor
public void setBookAuthor(String bookAuthorvalue)
{
	bookAuthor=bookAuthorvalue;
}
public String getBookAuthor()
{
	return bookAuthor;
}

//set and get methods bookSignature 
public void setBookSignature(String bookSignaturevalue)
{
	bookSignature=bookSignaturevalue;
}
public String getBookSignature()
{
	return bookSignature;
}

//set and get methods bookISBN_10
public void setBookISBN_10(String bookISBN10value)
{
	bookISBN10=bookISBN10value;
}
public String getBookISBN10()
{
	return bookISBN10;
}

//set and get methods bookState

public void setBookState(String bookStatevalue)
{
	bookState=bookStatevalue;
}
public String getBookState()
{
	return bookState;
}
public boolean validISBN(String iSBNvalue)
{ 
	int x=0;
	int sum=0;
	char c;
	String ch="";
	int length=iSBNvalue.length();
	if (length!=10)
		return false;
	for(int i=0; i<=9;i++)
		{
		c=iSBNvalue.charAt(i);
		ch=c+"";
		x=Integer.parseInt(ch);
		
		sum=sum+(x*(i+1));
		}
	
			if(sum%11==0)
			{       
				return true;}
			
			 return false;
}



}
