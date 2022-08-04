package TwitterAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Responsespec {
	String consumerKey="xWHMyhLRRkRUca6k2GyCLY2VB";
	String consumerSecret="FutMPITyF5Dg1mvdca10lgJUfWdFmgIgcBh9CjO5QeyzPf6zBN";
	String accessToken="1547060158114967552-EPhemBGLRO643WNHQoVwoCdoryFDAP";
	String accessSecret="Gv6anqeb8FeTogYCVOfDpet3B2I20AhnkiIiOblpjiK3N";
	String tweetid;
	RequestSpecBuilder requestBuilder;
	static RequestSpecification requestSpec;
	ResponseBuilder responseBuilder;
	static ResponseSpecification responseSpec;
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
//		RestAssured.baseURI="https://api.twitter.com";
//		RestAssured.basePath="/1.1/statuses";
		AuthenticationScheme authScheme=
				RestAssured.oauth(consumerKey, consumerSecret, accessToken, accessSecret);
		requestBuilder.setAuth(authScheme);
		requestBuilder=new RequestSpecBuilder();
		requestBuilder.setBaseUri("https://api.twitter.com");
		requestBuilder.setBasePath("/1.1/statuses");
		requestBuilder.addQueryParam("user_id", "apiautomation");
		requestSpec=requestBuilder.build();
		
		responseBuilder=new ResponseBuilder();
		responseBuilder.setStatusCode(200);
		//responseBuilder.setBody(null)
		responseSpec=(ResponseSpecification) responseBuilder.build();
		
		
	}
	
	@Test(dependsOnMethods= {"postTweet"})
	public void readTweet() {
		 given()
		   .log().all()
		   .spec(requestSpec)		
		.when()
		  .get("/user_timeline.json")
		.then()
		  .log().all()
		  .spec(responseSpec);
}}
