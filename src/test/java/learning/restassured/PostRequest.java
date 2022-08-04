package learning.restassured;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import learning.restassured.request.RequestPayload;

import static org.hamcrest.Matchers.*
;public class PostRequest {

	public static void main(String[] args) {
		Header header1=new Header("Content-Type","application/json");
		RestAssured.baseURI="http://localhost:8095/api";
		String responseBody = given()
		.log()
		.all()
		.header(header1)
		.body(RequestPayload.requestPayload())
		.when()
		.post("/users")
		.then()
		.assertThat()
		.statusCode(201)
		.extract()
		.body()
		.toString();
		
		
	JsonPath jsonValue=new JsonPath(responseBody); 
		System.out.println(jsonValue.getString("lastName"));
	}

}


