package restapis;

import org.apache.commons.lang3.RandomStringUtils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Baseclass {
	
	public static Response response;
	public static RequestSpecification httprequest;
	
	public static String ename() {
		String name=RandomStringUtils.randomAlphabetic(5);
		return name;
	}
	public static String eid() {
		String id=RandomStringUtils.randomNumeric(10);
		return id;
		
	}
	public  static String eage() {
		String age=RandomStringUtils.randomNumeric(10);
		return age;
		
	}
}
