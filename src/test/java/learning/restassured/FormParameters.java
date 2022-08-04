
package learning.restassured;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

public class FormParameters {
	public static void main(String[] args) {
		RestAssured.baseURI = "http://localhost:8081/api";
		String responseBody = given()
				.log().all()
				.contentType(ContentType.URLENC)
				.formParam("delay", 10000)
				.when()
				.get("/books").then()
				.assertThat().statusCode(200)
				.extract().response().toString();
		System.out.println(responseBody);

	}
}