package learning.restassured.jiraapi;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;




public class HttpMethodsJiraAPI2 {
	SessionFilter sessionData = new SessionFilter();
	String issueid;
	String commentid;
	
	@BeforeTest
	public void method1() {
		RestAssured.baseURI ="http://localhost:8084";
	}
    @Test
	public void m1() {
    	
		//sessionID cookie generation
		
		given().log().all().headers("Content-Type", "application/json").body(JiraUtils.getPostSessionRequest())
				.filter(sessionData).when().post("rest/auth/1/session").then().log().all().statusCode(200);
    }
        //creating issue
		@Test
		public void m2() {
		Response response = given().log().all().headers("Content-Type", "application/json").filter(sessionData)
				.body(JiraUtils.getPostIssueRequest()).when().post("rest/api/2/issue").then().assertThat()
				.statusCode(201).extract().response();
		String res = response.asString();
		System.out.println(res);
	    issueid = JsonPathUtils.jsonPathStringElementFetch(res, "id");
		System.out.println(issueid);
		String key = JsonPathUtils.jsonPathStringElementFetch(res, "key");
		System.out.println(key);
		}
		@Test
		public void m3() {
        //commenting on issue
		Response response2 = given().log().all().headers("Content-Type", "application/json")
				.pathParam("issueid", issueid).body(JiraUtils.postCommentRequest()).filter(sessionData).when()
				.post("rest/api/2/issue/{issueid}/comment").then().log().all().statusCode(201).extract().response();

		String commentResponse = response2.asString();
		System.out.println(commentResponse);
	    commentid = JsonPathUtils.jsonPathStringElementFetch(commentResponse, "id");
		System.out.println(commentid);
		}
		@Test
		public void m4() {
     //updating comment
		given().log().all().headers("Content-Type", "application/json").pathParam("commentid", commentid).pathParam("issueid", issueid)
				.body(JiraUtils.updateCommentRequest()).filter(sessionData).when()
				.put("rest/api/2/issue/{issueid}/comment/{commentid}").then().log().all().statusCode(200);
		}
		@Test
		public void m5() {
		//deleting issue
		given().log().all().pathParam("issueid", issueid).filter(sessionData).when()
				.delete("rest/api/2/issue/{issueid}").then().log().all().statusCode(204);
	}
	// .queryParams("notifyUsers", true)
}
