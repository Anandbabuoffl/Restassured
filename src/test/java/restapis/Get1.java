package restapis;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Get1 {

	@Test
	public void get() {
		

		
		
		
		HashMap<String, String> map=new HashMap<String,String>();
		map.put("Email", "anand@gmail");
		map.put("Firstname", "anand");
		map.put("Lastname", "babu");
		RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification httprequest = RestAssured.given();
		
		httprequest.body(map);
		Response response = httprequest.request(Method.POST, "/Create");
		int statuscode1=response.statusCode();
		System.out.println(statuscode1);
		
		
		
		
		
		
		
		

		/*
		 * ResponseBody rb = response.getBody();
		 * System.out.println(rb.asPrettyString());
		 * System.out.println(response.statusCode());
		 * System.out.println(response.statusLine());
		 */

		/*
		 * RestAssured .given() .when() .get("/employees") .then() .statusCode(200);
		 */

	}

}
