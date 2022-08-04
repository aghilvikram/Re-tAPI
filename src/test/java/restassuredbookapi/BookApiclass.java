package restassuredbookapi;

public class BookApiclass {
	

	

		public static String getPOSTRequestBody() {
			
			return "{\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "  \"authorName\": \"Paulo Coelho\",\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "  \"bookTitle\": \"The Alchemist\",\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "  \"yearPublished\": 2005,\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "  \"genre\": \"Contemporary Fiction \",\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "  \"isbn\": \"9788172234980\"\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "}";
		}
		
	public static String getPUTRequestBody() {
			
			return "\\r\\n\"\r\n"
					+ "					+ \"  \\\"isbn\\\": \\\"9788172234980\\\"\\r\\n\"\r\n"
					+ "					+ \"\\r\\n";
		}
	
	
	
	public static String getPOSTRequestBody(String author, String bookTitle,String yearPublished ,String genre,String isbn) {
		return isbn;
	}}


