package RestAssuredAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetRequestDemo {
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI="https://maps.googleapis.com";
		RestAssured.basePath="/maps/api";
		
	}
	@Test
	public void statusCodeVerification() {
		ValidatableResponse statusCode = given()
		.param("units", "imperial")
		.param("destinations", "New+York+City")
		.param("origins", "Washington,DC")
		.param("key", "qw213")
		.when()
		.get("/distancematrix/json")
		.then()
		.statusCode(200);
		System.out.println(statusCode);
	}
	@Test
	public void response() {
		 Response response = given()
		.param("units", "imperial")
		.param("destinations", "New+York+City")
		.param("origins", "Washington,DC")
		.param("key", "qw213")
		.when()
		.get("/distancematrix/json");
		System.out.println(response.body().asString()); 
		// System.out.println(response);
		//destination_addresses
		//"error_message" : "The provided API key is invalid. ",
		
	}

}
