package AppacheClientDemo;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HttpContext;

public class RequestInterceptor {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpRequestInterceptor requestInterceptor=new  HttpRequestInterceptor() {

			public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
				if(request.containsHeader("my-custom-header")) {
					System.out.println("remove my-custom-header");
					request.removeHeaders("my-custom-header");
				}
				Header[] remainingHeaders = request.getAllHeaders();
				for(int i=0; i<remainingHeaders.length; i++) {
					System.out.println(remainingHeaders[i].getName());
				}
				
			}
			
		};
		CloseableHttpClient closeableHttpClient = HttpClients.custom().addInterceptorFirst(requestInterceptor).build();
		
		HttpGet getRequest=new HttpGet("");
		getRequest.setHeader(new BasicHeader("my-custom-header","asdferr"));
		getRequest.setHeader(new BasicHeader("new-custom-header","newser123"));
		
		CloseableHttpResponse httpGetResponse=closeableHttpClient.execute(getRequest);
		System.out.println(httpGetResponse.getStatusLine().getStatusCode());
		
		
		
		
			
		

	}

}
