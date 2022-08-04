package learning.restassured.datadrivern;

public class BookAPIUtilClass {
	
	public static String getPostBody(String authorName, String bookTitle, int yearPublished, String genre, String isbn ) {
		return  "{\"authorName\":\""+authorName+"\","
				+ "\"bookTitle\":\""+bookTitle+"\","
				+ "\"yearPublished\":"+yearPublished+","
				+ "\"genre\":\""+genre+"\","
				+ "\"isbn\":\""+isbn+"\"}";	
}}
