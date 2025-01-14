package apiTesting;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;



public class RequresApi {
	
	@Test
	public void t1() {
		
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
		
	}
	
	@Test
	public void create() {
		
		JSONObject js = new JSONObject();
		
		js.put("name", "morpheus");
		
		js.put("job", "leader");
		
		given().body(js.toJSONString()).when().post("https://reqres.in/api/users")
		.then().statusCode(201).log().all();
	
	}
	
	@Test
	public void registerSuccessful() {
		
		JSONObject js = new JSONObject();
		
		js.put("email", "eve.holt@reqres.in");
		
		js.put( "password", "pistol");
		
		given().contentType("application/json").body(js.toJSONString()).when().post("https://reqres.in/api/register")
		.then().statusCode(200).log().all();
		
	}
	
	

}
