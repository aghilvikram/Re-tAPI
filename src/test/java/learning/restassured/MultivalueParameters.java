package learning.restassured;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class MultivalueParameters {

	public static void main(String[] args) {
		RestAssured.baseURI = "http://localhost:8081/api/test/multivalue";
		String parameterList="nokia,samsung,apple";
		String responseBody = given()
				.log().all().param("params", parameterList)
				.when()
				.get().then()
				.assertThat().statusCode(200)
				.extract().response().toString();
		System.out.println(responseBody);

	}

}
