package restapis;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

public class Simplerequest {

	@Test
	public void getreq() {
		
	Response response=	RestAssured.get("https://reqres.in/api/users?page=2");
	int statuscode=response.statusCode();
	String statusline=response.statusLine();
	ResponseBody responsebody= response.body();
	System.out.println(responsebody.asPrettyString());
	
	
	//System.out.println(statuscode);
	//System.out.println(statusline);
	
	
	}
	
	@Test
	public void getreq1() {
		RestAssured.baseURI="https://reqres.in/api";
		
		ValidatableResponse response= RestAssured
	 .given()
	 .when()
	 .get("/users/2") 
	. then()
	 .statusCode(200);
System.out.println(response);
	}
	
	@Test
	public void post()
	{ 
		JSONObject jo=new JSONObject();
		jo.put("job","Testing" );
		jo.put("name","Anand");
		System.out.println(jo.toJSONString());
		
		
		RestAssured.baseURI="https://reqres.in/api";
		
		RestAssured
		.given()
		.when()
		.body(jo.toJSONString())
		.post("/users/7") 
		.then()
		.statusCode(201)
		.log().all();
		
		
	}
	
	@Test
	public void put() {
		
		JSONObject jo=new JSONObject();
		jo.put("Name", "Anand");
		jo.put("Job", "Testing");
		
		RestAssured.baseURI="https://reqres.in/api/";
		
		RestAssured
		.given()
		.when()
		.body(jo.toJSONString())
		.put("/users/2")
		.then()
		.statusCode(200);
		
	}
	@Test
	public void patch() {
		RestAssured.baseURI="https://reqres.in/api/";
		
		JSONObject jo=new JSONObject();
		jo.put("Name","Arun");
		jo.put("Job","Devloper");
		
		RestAssured
		.given()
		.when()
		.body(jo.toJSONString())
		.patch("/users/4")
		.then()
		.statusCode(200);
	}
	@Test
	public void delete()
	{
		RestAssured.baseURI="https://reqres.in/api/";
		
	RestAssured
	.given()
	.when()
	.delete("/user/5")
	.then()
	.statusCode(204);
	}
}
