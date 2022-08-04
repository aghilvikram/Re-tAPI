package restassuredbookapi;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class JsonFile {
	@Test
	public void m1() throws IOException {
	RestAssured.baseURI = "http://localhost:8088/api/";

//	Path path = Paths.get("C:\\Users\\qapiapi04\\eclipse-workspace\\RestAssured\\JsonFile\\newstatic.json");
//	byte[] readAllBytes = Files.readAllBytes(path);
//	String jsonreqBody=new String(readAllBytes);
	File file=new File("C:\\Users\\qapiapi04\\eclipse-workspace\\RestAssured\\JsonFile\\newstatic.json");

	given().log().all().headers("Content-Type", "application/json").body(file).when().post("books").then().log().all().assertThat().statusCode(201).extract().response()
			.asString();

	
	

			


}}
