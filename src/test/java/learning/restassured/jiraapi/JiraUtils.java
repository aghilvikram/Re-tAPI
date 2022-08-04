package learning.restassured.jiraapi;

public class JiraUtils {
	
	
	public static String getPostIssueRequest() {
		return "{\r\n"
				+ "		    \"fields\": {\r\n"
				+ "		        \"project\":\r\n"
				+ "		        {\r\n"
				+ "		           \"key\": \"NEW\"\r\n"
				+ "		        },\r\n"
				+ "		        \"summary\": \"new issue created\",\r\n"
				+ "		        \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
				+ "		        \"issuetype\": {\r\n"
				+ "		           \"name\": \"Bug\"\r\n"
				+ "		        }\r\n"
				+ "		    }\r\n"
				+ "		 }";

}
	public static String getPostSessionRequest() {
		return "{ \"username\": \"vikram\", \"password\": \"Vikramaghil777@\" }";

}

	public static String postCommentRequest() {
		return "{\r\n"
				+ "    \"body\": \"new com comments\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}";

}
	public static String updateCommentRequest() {
		return "{\r\n"
				+ "    \"body\": \"updating comments again\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}";
}}
