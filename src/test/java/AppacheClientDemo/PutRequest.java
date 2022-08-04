package AppacheClientDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class PutRequest {

	public static void main(String[] args) throws Throwable {
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		HttpPut putRequest=new HttpPut("");
		String jsonBody="{\"firstName\":\"vikram\",\"lastName:balasubramanian\",\"sports:football\",\"country:india\",\"salary:50000\"}";
		StringEntity entity=new StringEntity(jsonBody, ContentType.APPLICATION_JSON);
		putRequest.setEntity(entity);
		putRequest.setHeader("Content-Type","application/json");
		CloseableHttpResponse httpResponse = closeableHttpClient.execute(putRequest);
		BufferedReader br=new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
		StringBuffer response=new StringBuffer();
		String responseLine=null;
		while((responseLine=br.readLine())!=null) {
			response.append(responseLine);
		}
		System.out.println(httpResponse.getStatusLine().getStatusCode());
		System.out.println(response);

	}

}
