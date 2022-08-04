package learning.restassured.datadrivern;

import static io.restassured.RestAssured.given;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class FetchingDatafromDataProvider {
	static String fileName = "C:\\Users\\qapiapi04\\eclipse-workspace\\RestAssured\\Dataxlsx\\RestAssuredDataDriven.xlsx";
	static String sheetName = "booksapidata";
	static String testcaseLiteral = "TestCases";
	static String testcaseNameOne="bookOne";
	static String testcaseNameTwo="bookTwo";
	//static Map<String, Integer> rowcolmap;
	@DataProvider
	public Object[][] m2() throws Exception {
		Map<String, Integer> rowcolMap = DataDriven.searchForTestCase(fileName,sheetName,testcaseLiteral);
		ArrayList<Object> dataforTestCase1 = DataDriven.getDataforTestCase(rowcolMap, fileName, sheetName, testcaseNameOne);
		ArrayList<Object> dataforTestCase2 = DataDriven.getDataforTestCase(rowcolMap, fileName, sheetName, testcaseNameTwo);
		Object[] bookOne = dataforTestCase1.toArray();
		Object[] bookTwo = dataforTestCase2.toArray();
		System.out.println(bookOne);
		System.out.println(bookTwo);
		

//		Object[] bookTwo = { "Lori Gottlieb", "Maybe You Should Talk To Someone", 2019, "Personal Transformation",
//				"9389143519" };
//
//		Object[] bookThree = { "Dale Carnegie", "How to Win Friends and Influence People", 2021,
//				"Personal Transformation", "9354403778" };

		return new Object[][] { bookOne, bookTwo };
	}
	
	
	
	

	@Test(dataProvider = "m2")
	public void getPOSTRequestBody(String authorName, String bookTitle, String yearPublished, String genre, String isbn) {
		RestAssured.baseURI = "http://localhost:8081/api/";

		// GET Request
		

		String response = given().headers("Content-Type", "application/json")
				.body(BookAPIUtilClass.getPostBody(authorName, bookTitle, Integer.valueOf(yearPublished), genre, isbn))
				.when().post("books")
				.then().log().all().extract().response()
				.asString();
		System.out.println(response);
		//JsonPath jp = new JsonPath(response);
		//String bookid = jp.getString("bookId");
		//System.out.println(bookid);

	}

}
