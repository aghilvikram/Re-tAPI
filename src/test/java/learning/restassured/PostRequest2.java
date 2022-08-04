package learning.restassured;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import learning.restassured.model.User;
import learning.restassured.request.RequestPayload;

import static org.hamcrest.Matchers.*
;public class PostRequest2 {

	public static void main(String[] args) {
		RestAssured.baseURI="http://localhost:8095/api";
		User response= given()
		.headers("Content-Type","application/json")
		.body(RequestPayload.requestPayload())
		.when()
		.post("/users")
		.then()
		.assertThat()
		.statusCode(201)
		.extract()
		.as(User.class);
		System.out.println(response);
		
		
		
	
	}

}


