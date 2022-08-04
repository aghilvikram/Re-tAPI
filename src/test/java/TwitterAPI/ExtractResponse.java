package TwitterAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class ExtractResponse {
	String consumerKey="xWHMyhLRRkRUca6k2GyCLY2VB";
	String consumerSecret="FutMPITyF5Dg1mvdca10lgJUfWdFmgIgcBh9CjO5QeyzPf6zBN";
	String accessToken="1547060158114967552-EPhemBGLRO643WNHQoVwoCdoryFDAP";
	String accessSecret="Gv6anqeb8FeTogYCVOfDpet3B2I20AhnkiIiOblpjiK3N";
//	API SECRET
//	FutMPITyF5Dg1mvdca10lgJUfWdFmgIgcBh9CjO5QeyzPf6zBN  
//	API KEY
//	xWHMyhLRRkRUca6k2GyCLY2VB  
//	Access token
//	1547060158114967552-EPhemBGLRO643WNHQoVwoCdoryFDAP
//	Access Secret
//	Gv6anqeb8FeTogYCVOfDpet3B2I20AhnkiIiOblpjiK3N  
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI="https://api.twitter.com";
		RestAssured.basePath="/1.1/statuses";
	}
	@Test
	public void statusCodeVerification() {
		Response response = given()
		.auth()
		.oauth(consumerKey, consumerSecret, accessToken, accessSecret)
		.queryParam("status", "my second tweet")
		.when()
		.post("/update.json")
		.then().statusCode(200)
		.extract()
		.response();
		
		Headers headers = response.headers();
		System.out.println(headers);
		ResponseBody body = response.body();
		System.out.println(body);
		String id=response.path("id_str");
		System.out.println(id);
}}
