package ProductionCode;

public class Book {
private String bookTitle;
private String bookAuthor;
private String bookSignature;
private String bookISBN_10;
private String bookState;
//set and get methods  bookTitle
public void setBookTitle(String bookTitle_value)
{
	bookTitle=bookTitle_value;
}
public String getBookTitle()
{
	return bookTitle;
}

//set and get methods bookAuthor
public void setBookAuthor(String bookAuthor_value)
{
	bookAuthor=bookAuthor_value;
}
public String getBookAuthor()
{
	return bookAuthor;
}

//set and get methods bookSignature 
public void setBookSignature(String bookSignature_value)
{
	bookSignature=bookSignature_value;
}
public String getBookSignature()
{
	return bookSignature;
}

//set and get methods bookISBN_10
public void setBookISBN_10(String bookISBN_10_value)
{
	bookISBN_10=bookISBN_10_value;
}
public String getBookISBN_10()
{
	return bookISBN_10;
}

//set and get methods bookState

public void setBookState(String bookState_value)
{
	bookState=bookState_value;
}
public String getBookState()
{
	return bookState;
}
public boolean validISBN(String ISBN_value)
{ 
	int x=0;
	int sum=0;
	char c;
	String ch="";
	int length=ISBN_value.length();
	if (length!=10)
		return false;
	for(int i=0; i<=9;i++)
		{
		c=ISBN_value.charAt(i);
		ch=c+"";
		x=Integer.parseInt(ch);
		
		sum=sum+(x*(i+1));
		}
	
			if(sum%11==0)
			{       
				return true;}
			else return false;
}



}
