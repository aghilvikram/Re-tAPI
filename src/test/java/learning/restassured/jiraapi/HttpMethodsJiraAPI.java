package learning.restassured.jiraapi;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.Cookies;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class HttpMethodsJiraAPI {
	//SessionFilter sessionData= new SessionFilter();
	//private String issueid;
	//private String commentid;
	private static String name1;
	private static String value1;
	Cookies detailedCookies;
	    

	    @BeforeTest
	    public void n1() {
	    RestAssured.baseURI = "http://localhost:8084";
	    }
	    
	    
         @Test
         public void method1() {
		/*String jsonresponse = given()
		.headers("Content-Type", "application/json")
		.body(JiraUtils.getPostSessionRequest())
		//.filter(sessionData)
		.when()
		.post("rest/auth/1/session")
		.then().assertThat()
		.log().ifValidationFails()
		.statusCode(200).extract().response().asString();
        	 JsonPath path=new JsonPath(jsonresponse);
    		 name1 = path.getString("name");
    	    value1 = path.getString("value");
    		System.out.println(name1);
    		System.out.println(value1);
    		}*/
    		
		 detailedCookies = given()
				.headers("Content-Type", "application/json")
				.body(JiraUtils.getPostSessionRequest())
				//.filter(sessionData)
				.when()
				.post("rest/auth/1/session")
				.then().assertThat()
				.log().ifValidationFails()
				.statusCode(200).extract().detailedCookies();
		 System.out.println(detailedCookies);
         }
        /*  Map<String, String> cookies1 = given()
 				.headers("Content-Type", "application/json")
 				.body(JiraUtils.getPostSessionRequest())
 				//.filter(sessionData)
 				.when()
 				.post("rest/auth/1/session")
 				.then().assertThat()
 				.log().ifValidationFails()
 				.statusCode(200).extract().cookies();
          cookies1.get(name);
          
         }*/
         
		
		
		@Test(priority=1)
		public void m2(ITestContext testContext) {
	    //sessionData= new SessionFilter();

		Response response = given()
				.headers("Content-Type", "application/json")
				.cookies(detailedCookies)
				//.headers("cookie", name1+"="+value1)
				
				.body(JiraUtils.getPostIssueRequest())
				.when()
				.post("rest/api/2/issue")
				.then()
				.assertThat()
				.statusCode(201).log().ifValidationFails().extract().response();
		String res = response.asString();
		System.out.println(res);
	    String  issueid = JsonPathUtils.jsonPathStringElementFetch(res, "id");
	    //ITestContext
	    testContext.setAttribute("issueid1", issueid);
		System.out.println(issueid);
		String key = JsonPathUtils.jsonPathStringElementFetch(res, "key");
		System.out.println(key);
		}
		/*@Test(priority=2)
		public void m3(ITestContext testContext) {
			String issueid1 = (String)testContext.getAttribute("issueid1");
		Response response2 = given().headers("Content-Type", "application/json")
				.pathParam("issueid", issueid1)
				.body(JiraUtils.postCommentRequest())
				.filter(sessionData).when()
				.post("rest/api/2/issue/{issueid}/comment")
				.then()
				.log()
				.ifValidationFails()
				.statusCode(201).extract().response();

		String commentResponse = response2.asString();
		System.out.println(commentResponse);
		String commentid = JsonPathUtils.jsonPathStringElementFetch(commentResponse, "id");
		//ITestContext
		testContext.setAttribute("commentid1", commentid);
		System.out.println(commentid);
		}
		
		
		@Test(priority=3)
		public void m4(ITestContext testContext) {
			String commentid1 = (String)testContext.getAttribute("commentid1");
			String issueid1 = (String)testContext.getAttribute("issueid1");
	           given().log().all()
	            .headers("Content-Type", "application/json")
	            .pathParam("issueid", issueid1)
	            .pathParam("commentid", commentid1)
				.body(JiraUtils.updateCommentRequest()).filter(sessionData).when()
				.put("rest/api/2/issue/{issueid}/comment/{commentid}")
				.then().assertThat().log().ifValidationFails().statusCode(200);
	}
		@Test(priority=4)
		public void m5(ITestContext testContext) {
			
			String issueid1 = (String)testContext.getAttribute("issueid1");
		     given().log().all()
		        .pathParam("issueid", issueid1)
			   	.filter(sessionData)
			   	.when()
			   	.delete("rest/api/2/issue/{issueid}")
				.then()
				.log().ifValidationFails().statusCode(204);
		}
	// .queryParams("notifyUsers", true)*/
}
