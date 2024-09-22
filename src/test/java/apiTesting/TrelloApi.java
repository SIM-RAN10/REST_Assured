package apiTesting;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class TrelloApi {
	
	String id;
	
	@Test
	public void createBoard() {
		
		RestAssured.baseURI="https://api.trello.com";
		 Response Board = given().contentType(ContentType.JSON).queryParam("name", "Daisy")
		.queryParam("key", "92ec2e4db5ff34dadd97be142cc34bcd")
		.queryParam("token", "ATTAa5d540736550f3c862c5ac785976a1086c8ff5151aa00db73a095fb09877c5cdC15FB6D0")
		.when().post("/1/boards/").then().extract().response();
		String Extract = Board.asString();
		
		JsonPath jP = new JsonPath(Extract);
		
	    id = jP.get("id");
	    
		System.out.println(id);
		
	}
	
	@Test
	public void getAboard() {
		
		RestAssured.baseURI="https://api.trello.com";
		given().contentType(ContentType.JSON)
		.queryParam("key", "92ec2e4db5ff34dadd97be142cc34bcd")
		.queryParam("token", "ATTAa5d540736550f3c862c5ac785976a1086c8ff5151aa00db73a095fb09877c5cdC15FB6D0")
		.get("/1/boards/" + id).then().log().all();
	}
	
	@Test
	public void DeleteaBoard() {
		
		RestAssured.baseURI="https://api.trello.com";
		given().contentType(ContentType.JSON)
		.queryParam("key", "92ec2e4db5ff34dadd97be142cc34bcd")
		.queryParam("token", "ATTAa5d540736550f3c862c5ac785976a1086c8ff5151aa00db73a095fb09877c5cdC15FB6D0")
		.delete("/1/boards/" + id).then().log().all();
	}

}
