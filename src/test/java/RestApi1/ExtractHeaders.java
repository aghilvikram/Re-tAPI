package RestApi1;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.Headers;

public class ExtractHeaders {
	@Test
	public void ExtractingHeader() {
		HashMap<String,Object> header=new HashMap<String, Object>();
		header.put("","");
		
				
	Headers h = given()
	.baseUri("http://data.fixer.io/api")
	.queryParam("access_key","")
	.queryParams("","")
	.headers(header).when().get("/latest").then().log().all().statusCode(200).extract().headers();
	System.out.println(h.getValue(""));
		
	}
}
