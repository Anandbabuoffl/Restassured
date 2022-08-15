package restapis;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Post1 {
	
	@Test
	public void appslovwpost() {
		RestAssured.baseURI="http://restapi.adequateshop.com";
	
		/*
		 * HashMap<String, String> hs=new HashMap<String, String>();
		 * hs.put("touristname", "Anand"); hs.put("touristemail", "anand@gamil.com");
		 * hs.put("touristlocation", "America");
		 */
		
		JSONObject js=new JSONObject();
		js.put("touristname", "Anand");
		js.put("touristemail", "anand@gamil.com");
		js.put("touristlocation", "America");
		
		RestAssured.given()
		.header("Content-Type","application/json")
		.body(js.toJSONString())
		.when()
		.post("api/Tourist")
		.then()
		.statusCode(201)
		.log().all()
		;	
	}

	@Test
    public void appsloveget() {
		RestAssured.baseURI="http://restapi.adequateshop.com";
		JSONObject js=new JSONObject();
		js.put("touristname", "Anand");
		js.put("touristemail", "anand@gamil.com");
		js.put("touristlocation", "America");
		
		 RequestSpecification httprequest= RestAssured.given();
		 httprequest.header("Content-Type","application/json; charset=utf-8");
		 httprequest.body(js);
		 Response response=httprequest.request(Method.POST,"/api/Tourist");
		 ResponseBody rs= response.body();
		 System.out.println(rs.asPrettyString());
		 
	}
	
}
