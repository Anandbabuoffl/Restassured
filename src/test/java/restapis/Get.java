package restapis;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Get extends Baseclass{
	
	@BeforeClass
	public void getrequest1() {
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		httprequest=RestAssured.given();
		response=httprequest.request(Method.GET,"/employees");
	}
	
	@Test
	public void responsebody() {
		String responsebody= response.getBody().asString() ;
		System.out.println(responsebody);
		Assert.assertTrue(responsebody!=null);
		
	}
	
	@Test
	public void statuscode() {
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}
	
	@Test
	public void statusline() {
		String statusline=response.getStatusLine();
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	
	}
	
	@Test
	public void timetaken() {
		long time=response.getTime();
		if(time>2000)
			Assert.assertTrue(time<2000);
	}
		
		@Test
		public void contenttype() {
			String contenttype=response.header("Content-type");
			System.out.println(contenttype);
			Assert.assertEquals(contenttype, "text/html; charset=UTF-8");
		}
		
		@Test
		public void contentserver() {
			String server=response.header("Server");
			System.out.println(server);
			Assert.assertEquals(server, "nginx","");
		}
		
		@Test
		public void contentencoding() {
			String contentencoding=response.header("Content-Encoding");
			System.out.println(contentencoding);
			Assert.assertEquals(contentencoding, "br");
		}
		
		@Test
		public void contentlength() {
			String contentlength=response.header("Content-Length");
			System.out.println(contentlength);
			Assert.assertEquals(contentlength, 479);
		}
		
	}
	
	
	
	


