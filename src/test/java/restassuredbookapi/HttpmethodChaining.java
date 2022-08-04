package restassuredbookapi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HttpmethodChaining {

	public class HttpMethodChaining {

		@Test
		public void testUserAPI() {
			// GET -> POST -> PUT -> GET -> DELETE
			RestAssured.baseURI = "http://localhost:8088/api/";

			// GET Request

			given().log().all().headers("Content-Type", "application/json").body("").when().get("books").then()
					.assertThat().statusCode(200);
//					JsonPath path=new JsonPath(response);
           //post request
			String response = given().headers("Content-Type", "application/json").body("{\n"

					+ " \"authorName\": \"Alan John Richardson\",\n"

					+ " \"bookTitle\": \"Automating and Testing a REST API\",\n"

					+ " \"yearPublished\": 2021,\n"

					+ " \"genre\": \"Education\",\n"

					+ " \"isbn\": \"0956733313\"\n"

					+ " }").when().post("books").then().assertThat().statusCode(201).extract().response().asString();
			JsonPath jp = new JsonPath(response);
			String bookid1 = jp.getString("bookId");
			String isbn = jp.getString("isbn");
			System.out.println(isbn);
			System.out.println(bookid1);
			// put request
			String resp = given().headers("Content-Type", "application/json").body("{\n"

					+ " \"yearPublished\": 2022"

					+ "}").pathParam("id", bookid1).when().put("books/{id}").then().assertThat().statusCode(200)
					.extract().asString();
			JsonPath jsondata=new JsonPath(resp);
			String bookid2 = jsondata.getString("bookId");
			System.out.println(bookid2);
            //get request
			given().headers("Content-Type", "application/json").when().get("books").then().assertThat().statusCode(200)
					.extract().asString();
            //delete request
			given().headers("Content-Type", "application/json").pathParam("id", bookid1).when().delete("books/{id}")
					.then().assertThat().statusCode(204);
		}
	}
}
