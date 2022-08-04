package RestAssuredAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class ValidatingResponse {
	@Test
	public void response() {
		 given()
		.param("units", "imperial")
		.param("destinations", "New+York+City")
		.param("origins", "Washington,DC")
		.param("key", "qw213")
		.when()
		.get("/distancematrix/json")
		.then()
		.statusCode(200)
		.and()
		.body("error_message", equalTo("The provided API key is invalid. "))
		.contentType(ContentType.JSON);
		
		
		
		
	}

}
