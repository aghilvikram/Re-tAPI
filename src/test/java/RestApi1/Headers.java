package RestApi1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class Headers {
	
  
	
	@Test
	public void m1() {
		HashMap<String,Object> header=new HashMap<String, Object>();
		header.put("","");
		
				
	given()
	.baseUri("http://data.fixer.io/api")
	.queryParam("access_key","")
	.queryParams("","")
	.headers(header).when().get("/latest").then().log().all().statusCode(200);
		
	}
	
	

}
