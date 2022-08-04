package RestApi1;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

public class ValidatingHeaderResponse {
	
	@Test
	public void validatingHeader() {
		HashMap<String,Object> header=new HashMap<String, Object>();
		header.put("","");
		
				
	given()
	.baseUri("http://data.fixer.io/api")
	.queryParam("access_key","")
	.queryParams("","")
	.headers(header).when().get("/latest").then().log().all().statusCode(200).header("server","cloudFare");
		
	}
	
}
