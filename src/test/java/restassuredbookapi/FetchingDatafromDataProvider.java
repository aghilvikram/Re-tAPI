package restassuredbookapi;

import static io.restassured.RestAssured.given;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class FetchingDatafromDataProvider {

	@DataProvider
	public Object[][] m2() {
		Object[] bookOne = { "Astha Anand", "A Million Thoughts", 2021, "Poetry", "1639573704" };

		Object[] bookTwo = { "Lori Gottlieb", "Maybe You Should Talk To Someone", 2019, "Personal Transformation",
				"9389143519" };

		Object[] bookThree = { "Dale Carnegie", "How to Win Friends and Influence People", 2021,
				"Personal Transformation", "9354403778" };

		return new Object[][] { bookOne, bookTwo, bookThree };
	}
	
	
	
	

	@Test(dataProvider = "m2")
	public void getPOSTRequestBody(String author, String bookTitle, int yearPublished, String genre, String isbn) {
		RestAssured.baseURI = "http://localhost:8090/api/";

		// GET Request
		

		String response = given().headers("Content-Type", "application/json").body("{\n"

				+ " \"authorName\": \"+" + author + ""

				+ " \"bookTitle\": \"+" + bookTitle + ""

				+ " \"yearPublished\"+" + yearPublished + ""

				+ " \"genre\": \"+" + genre + ""

				+ " \"isbn\": \"+" + isbn + ""

				+ " }").when().post("books").then().log().all().extract().response()
				.asString();
		//JsonPath jp = new JsonPath(response);
		//String bookid = jp.getString("bookId");
		//System.out.println(bookid);

	}

}
