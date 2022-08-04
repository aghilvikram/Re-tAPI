package learning.restassured.javabasics;
import static learning.restassured.javabasics.Books.*;

public class Comics implements 	Books {
	private String bookName;
	private int bookPrice;

	public Comics(String bookName, int bookPrice) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}

	@Override
	public String getbookName() {
		System.out.println("BookName is:" +bookName);
		return bookName;
		
	}

	@Override
	public int getbookPrice() {
		
		System.out.println("BookPrice is: "+ bookPrice);
		return bookPrice;
	}

	
	

}
