package restassuredbookapi;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FileUploadDownload {

	@Test
	public void m1() throws IOException {
		RestAssured.baseURI = "http://localhost:8088/api";

		Response response = given().log().all().contentType(ContentType.MULTIPART).multiPart("fileName", new File(
				"C:\\Users\\qapiapi04\\eclipse-workspace\\RestAssured\\src\\test\\java\\restassuredbookapi\\multipart.jpg"))
				.when().post("/files/upload/database").then().assertThat().statusCode(200).extract().response();
		
		System.out.println(response.body());
		JsonPath js = new JsonPath(response.asString());

		String downloadurl = js.getString("downloadUri");

		// byte[] urlbytes = downloadurl.getBytes();
		System.out.println(downloadurl);
		Response response1 = given().log().all().when()
				.get(downloadurl).then()
				.assertThat().statusCode(200).extract().response();
		String fileName="C:\\Users\\QQA0431\\eclipse-workspace\\Ra\\newimage";
		BufferedInputStream in=null;
		FileOutputStream fout=null;
		in=new BufferedInputStream(new URL(downloadurl).openStream());
		fout=new FileOutputStream(fileName);
		byte[] buffer=new byte[1024];
		int count;

		while((count=in.read(buffer,0,1024))!=-1)
		{
		System.out.println(count);
		fout.write(buffer,0,count);
		}
		System.out.println(fileName);
fout.flush();
		in.close();
		fout.close();
		
		}
}







//	byte[] imgbyte = response1.getBody().asByteArray();
//	File dl = new File("C:\\Users\\qapiapi04\\eclipse-workspace\\RestAssured\\File");
//	Files.write(dl.toPath(), imgbyte);
	/*URL url=new URL(downloadUrl);
	InputStream is=url.openStream();
	OutputStream os=new FileOutputStream(fileName);*/
		
	


