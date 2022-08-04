package RestApi1;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.Cookie;

public class Cookies {
	HashMap<String,Object> header=new HashMap<String, Object>();
	@Test
	public void cookie() {
		
		header.put("","");
		
				
	given()
	.baseUri("http://data.fixer.io/api")
	.queryParam("access_key","")
	.queryParams("","")
	.cookie("","")
	.headers(header).when().get("/latest").then().log().all().statusCode(200);
		
	}
	
	@Test
	public void cookieBuilder() {
		
	Cookie cookie=new Cookie.Builder("","").setSecured(true).setComment("").build();
				
	given()
	.baseUri("http://data.fixer.io/api")
	.queryParam("access_key","")
	.queryParams("","")
	.cookie(cookie)
	.headers(header).when().get("/latest").then().log().all().statusCode(200);
		
	}
	
	
	

}
