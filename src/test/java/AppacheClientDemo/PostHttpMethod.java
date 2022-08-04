package AppacheClientDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class PostHttpMethod {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		HttpPost postRequest=new HttpPost("");
		String jsonBody="{\"firstName\":\"vikram\",\"lastName:balasubramanian\",\"sports:cricket\",\"country:india\",\"salary:25000\"}";
		StringEntity entity=new StringEntity(jsonBody, ContentType.APPLICATION_JSON);
		postRequest.setEntity(entity);
		postRequest.setHeader("Content-Type","application/json");
		CloseableHttpResponse httpResponse = closeableHttpClient.execute(postRequest);
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


