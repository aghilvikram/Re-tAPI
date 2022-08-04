package Oauth1;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Oauth1demo {
	static String consumer_key="05b32937a7b804355abcbb22c4c9554a";
	static String consumer_secret="73045726bca11d42";
	static String access_token="72157720851833317-f7b0d40c2c7af706";
	static String access_seceret="2e61b130bf94a01e";
	public static void main(String[] args) {
		RestAssured.baseURI = "http://www.flickr.com/services";
		String responseBody = given().relaxedHTTPSValidation()
				.log().all()
				.auth()
				.oauth(consumer_key,consumer_secret,access_token,access_seceret
						).queryParam("method","flickr.test.login")
				.when()
				.get("/rest").then().log().all()
				.assertThat().statusCode(200)
				.extract().response().toString();
		System.out.println(responseBody);

	}

}
