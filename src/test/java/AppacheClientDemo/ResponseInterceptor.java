package AppacheClientDemo;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;

public class ResponseInterceptor {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpResponseInterceptor responseInterceptor=new HttpResponseInterceptor() {

			public void process(HttpResponse response, HttpContext context) throws HttpException, IOException {
				System.out.println("adding headers");
				response.setHeader("my-custom-header","abcdef");
				response.setHeader("new-header","123456");
				System.out.println("headers added");
				
				
			}
			
		};
		CloseableHttpClient closeableHttpClient = HttpClients.custom().addInterceptorFirst(responseInterceptor).build();
		HttpGet getRequest=new HttpGet("");
		CloseableHttpResponse httpResponse = closeableHttpClient.execute(getRequest);
		Header[] allHeaders = httpResponse.getAllHeaders();
		for(int i=0; i<allHeaders.length; i++) {
			System.out.println(allHeaders[i].getName());
		}

	}

}
