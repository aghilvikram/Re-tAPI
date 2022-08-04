package learning.restassured.jsonplaceholder;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import learning.restassured.jiraapi.JiraUtils;

public class HttpMethodsJSONplaceHolder {

	@BeforeClass
	public void m() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	}

	@Test(priority = 1)
	public void m1() {
		// req1
		given()
		   
		   .headers("Content-Type", "application/json")
		.when()
		   .get("/posts/1")
		.then().assertThat().statusCode(200)
		   .log().ifValidationFails();
	}
		   
	

	@Test(priority = 2)
	public void m2() {

		// req2
		given()
		    .headers("Content-Type", "application/json")
		.when()
		    .get("/posts")
		.then().assertThat().statusCode(200)
		    .log()
		    .ifValidationFails();
	}
	

	@Test(priority = 3)
	public void m3() {
		// req3
		given()
		
		.headers("Content-Type", "application/json")
		.body(jsonPlaceHolderUtils.getPostBody())
		.when()
				.post("/posts")
				.then().assertThat().statusCode(201)
				.log().ifValidationFails();
			
			
	}
	

	@Test(priority = 4)
	public void m4() {
		// req4
		given()
		.headers("Content-Type", "application/json")
		.body(jsonPlaceHolderUtils.getPostUpdateBody())
				.when().put("/posts/1")
				.then().assertThat().
				statusCode(200).log().ifValidationFails();
	}

	@Test(priority = 5)
	public void m5() {
		// req5
		given()
		.log().all()
		.headers("Content-Type", "application/json")
				.body("{\r\n" + "    \"title\": \"API Testing\"\r\n" + "  }")
				.when()
				.patch("/posts/1").then().log().ifValidationFails().statusCode(200);
	}

	@Test(priority = 6)
	public void m6() {
		// req6
		given()
		.headers("Content-Type", "application/json")
		.when()
		.delete("/posts/1")
		.then()
		.log().ifValidationFails()
				.statusCode(200);
	}

	@Test(priority = 7)
	public void m7() {
		// req7
		given()
		
		.headers("Content-Type", "application/json")
		.when()
		.delete("/posts/1")
		.then()
		.log().ifValidationFails()
				.statusCode(200);
	}

	@Test(priority = 8)
	public void m8() {
		// req8->/posts?userId=1
		given()
		
		.headers("Content-Type", "application/json")
		.queryParam("userId", 1)
		.when().get("/posts").then().log().ifValidationFails()
				.statusCode(200);
	}

	@Test(priority = 9)
	public void m9() {
		// req9
		given()
		.headers("Content-Type", "application/json")
		.when()
		.get("/posts/1/comments")
		.then()
		.log().ifValidationFails().statusCode(200);
	}

	@Test(priority = 10)
	public void m10() {
		given()
		.headers("Content-Type", "application/json")
		.when()
		.get("/albums/1/photos")
		.then()
		.log().ifValidationFails().statusCode(200);
	}

	@Test(priority = 11)
	public void m11() {
		given()
		.headers("Content-Type", "application/json")
		.when().get("/users/1/albums")
		.then()
		.log().ifValidationFails()
				.statusCode(200);
	}

	@Test(priority = 12)
	public void m12() {
		given()
		.headers("Content-Type", "application/json")
		.when()
		.get("/users/1/todos")
		.then()
		.log().ifValidationFails()
				.statusCode(200);
	}

	@Test(priority = 13)
	public void m13() {
		// req13->/users/1/posts
		given()
		.headers("Content-Type", "application/json")
		.when()
		.get("/users/1/posts")
		.then()
		.log().ifValidationFails()
				.statusCode(200);
	

}}
