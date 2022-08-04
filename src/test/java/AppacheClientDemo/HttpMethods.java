package AppacheClientDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpMethods {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		HttpGet getRequest=new HttpGet("http://localhost:8095/api/users");
		CloseableHttpResponse httpResponse = closeableHttpClient.execute(getRequest);
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
