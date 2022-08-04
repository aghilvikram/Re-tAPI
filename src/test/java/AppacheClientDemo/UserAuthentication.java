package AppacheClientDemo;

import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

public class UserAuthentication {

	public static void main(String[] args) {
		CredentialsProvider credentialsProvider=new BasicCredentialsProvider();
		//AuthScope authScope=new AuthScope("",80);
		Credentials credentials=new UsernamePasswordCredentials("","");
		
		//credentialsProvider.setCredentials(authScope, credentials);
		
		HttpClientBuilder httpClientBuilder = HttpClients.custom();
		httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		HttpGet getRequest =new HttpGet("");
		//CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(getRequest);
		//System.out.println(closeableHttpResponse.getStatusLine().getStatusCode());
		

	}

}
