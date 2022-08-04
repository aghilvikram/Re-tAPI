package learning.restassured.jiraapi;

import io.restassured.path.json.JsonPath;

public class JsonPathUtils {
	
	public static String jsonPathStringElementFetch(String response, String key) {
		JsonPath jp=new JsonPath(response);
		String value = jp.getString(key);
		return value;
		
	}
	public static int jsonPathIntegerElementFetch(String response, String key) {
		JsonPath jp=new JsonPath(response);
		int value = jp.getInt(key);
		return value;
		
	}
}
