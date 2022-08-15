package restapis;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Post extends Baseclass{

	@Test
	public void postemployee() {
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		httprequest=RestAssured.given();
		
		JSONObject jo=new JSONObject();
		jo.put("Name", ename());
		jo.put("ID",eid());
		jo.put("Age",eage());
		System.out.println(jo.toJSONString());
		httprequest.body(jo.toJSONString());
		response=httprequest.request(Method.POST,"/Create");
		
	}
}
