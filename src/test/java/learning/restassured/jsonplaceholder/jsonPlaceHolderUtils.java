package learning.restassured.jsonplaceholder;

public class jsonPlaceHolderUtils {
	
	public static String getPostBody() {
		return "{\r\n" + "    \"title\": \"vikram\",\r\n"
				+ "    \"body\": \"bar\",\r\n" + "    \"userId\": 1\r\n" + "  }";
	}
	
	
	public static String getPostUpdateBody() {
		return "{\r\n" + "    \"id\": 1,\r\n" + "    \"title\": \"vikram b\",\r\n"
				+ "    \"body\": \"updated\",\r\n" + "    \"userId\": 1\r\n" + "  }";
	}

}
