package RestApi1;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Headers;

public class ExtractingCookies {
	@Test
	public void ExtractingCookies() {
		HashMap<String,Object> header=new HashMap<String, Object>();
		header.put("","");
		
				
	 Map<String, String> cookies = given()
	.baseUri("http://data.fixer.io/api")
	.queryParam("access_key","")
	.queryParams("","")
	.headers(header).when().get("/latest").then().log().all().statusCode(200).extract().cookies();
	System.out.println(cookies.get(""));
		
	}
}
