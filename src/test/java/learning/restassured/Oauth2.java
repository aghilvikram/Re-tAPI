package learning.restassured;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Oauth2 {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://api.github.com";
		String responseBody = given()
				.log().all()
				.auth().oauth2("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")
				.header("Accept", "application/vnd.github+json")
				.pathParam("owner", "aghilvikram")
				.pathParam("repo", "JavaBasic_new")
				.when()
				.get("/repos/{owner}/{repo}").then().log().all()
				.assertThat().statusCode(200)
				.extract().response().toString();
		System.out.println(responseBody);

	}

}
