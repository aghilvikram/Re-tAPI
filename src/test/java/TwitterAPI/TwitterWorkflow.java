package TwitterAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TwitterWorkflow {
	String consumerKey="xWHMyhLRRkRUca6k2GyCLY2VB";
	String consumerSecret="FutMPITyF5Dg1mvdca10lgJUfWdFmgIgcBh9CjO5QeyzPf6zBN";
	String accessToken="1547060158114967552-EPhemBGLRO643WNHQoVwoCdoryFDAP";
	String accessSecret="Gv6anqeb8FeTogYCVOfDpet3B2I20AhnkiIiOblpjiK3N";
	String tweetid;
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
	public void postTweet() {
		Response response = given()
		.auth()
		.oauth(consumerKey, consumerSecret, accessToken, accessSecret)
		.queryParam("status", "my second tweet")
		.when()
		.post("/update.json")
		.then().statusCode(200)
		.extract()
		.response();
		
		
		 tweetid=response.path("id_str");
		System.out.println(tweetid);
}
	@Test(dependsOnMethods= {"postTweet"})
	public void readTweet() {
		Response response = given()
		.auth()
		.oauth(consumerKey, consumerSecret, accessToken, accessSecret)
		.queryParam("id", tweetid)
		.when()
		.get("/show.json")
		.then().statusCode(200)
		.extract()
		.response();
		
		
		String text=response.path("text");
		System.out.println(text);
	}@Test(dependsOnMethods= {"readTweet"})
	public void deleteTweet() {
		given()
		.auth()
		.oauth(consumerKey, consumerSecret, accessToken, accessSecret)
		.queryParam("id", tweetid)
		.when()
		.post("/destroy.json")
		.then().statusCode(200);
		
		
		
		
	}@Test(dependsOnMethods= {"readTweet"})
	public void delete1Tweet() {
		given()
		.auth()
		.oauth(consumerKey, consumerSecret, accessToken, accessSecret)
		.pathParam("id", tweetid)
		.when()
		.post("/destroy/{id}.json")
		.then().statusCode(200);
		
		}}


