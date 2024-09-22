package apiTesting;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class SimplebookRestAssured {
	
	@Test
	public void status() {
		
	  given().get("https://simple-books-api.glitch.me/status").then().statusCode(200).log().all();
	  
	}
	
	@Test
	public void listOfBooks() {
		
		given().get("https://simple-books-api.glitch.me/books").then().statusCode(200).log().all();
	}
	
	@Test
	public void GetaSingleBook() {
		
		given().get("https://simple-books-api.glitch.me/books/6").then().statusCode(200).log().all();
		
	}
	
	@Test
	public void APIAuthetication() {
		
		JSONObject js = new JSONObject();
		
		js.put("clientName", "Simran");
		
		js.put( "clientEmail", "Samhujhdhjej@gmail.com");
		
		
		given().contentType("application/json").body(js.toJSONString()).when().post("https://simple-books-api.glitch.me/api-clients/")
		.then().statusCode(201).log().all();
	}
	
	@Test
	public void SubmitandOrder() {
		
		JSONObject js = new JSONObject();
		
		js.put("bookId", "1");
		
		js.put("customerName", "John");
		
		given().header("Authorization", "Bearer " + "a2c93a96d9a5a52e588a64ce6a550d7b4f8495d4ee6278d945be4b2c771f3b97")
		.contentType(ContentType.JSON).body(js.toJSONString()).when().post("https://simple-books-api.glitch.me/orders/").then()
		.statusCode(201).log().all();
		
	
	}
	
	@Test
	public void GetallOrder() {
		
		JSONObject js = new JSONObject();
		
		given().header("Authorization", "Bearer " + "a2c93a96d9a5a52e588a64ce6a550d7b4f8495d4ee6278d945be4b2c771f3b97")
		.contentType(ContentType.JSON).body(js.toJSONString())
		.get("https://simple-books-api.glitch.me/orders").then().statusCode(200).log().all();
		
			
	}
	
	@Test
	public void GetanOrder() {
		
		JSONObject js = new JSONObject();
		
		given().header("Authorization", "Bearer " + "a2c93a96d9a5a52e588a64ce6a550d7b4f8495d4ee6278d945be4b2c771f3b97")
		.contentType(ContentType.JSON).body(js.toJSONString()).get("https://simple-books-api.glitch.me/orders/PJGebIe_T_vfDI6XV3oP6").then().statusCode(200).log().all();
			
	}
	
	@Test
	public void UpdateanOrder() {
		
		JSONObject js = new JSONObject();
		
		js.put("customerName", "Daisy");
		
		given().header("Authorization", "Bearer " + "a2c93a96d9a5a52e588a64ce6a550d7b4f8495d4ee6278d945be4b2c771f3b97")
		.contentType(ContentType.JSON).body(js.toJSONString()).when().patch("https://simple-books-api.glitch.me/orders/PJGebIe_T_vfDI6XV3oP6").then().statusCode(204).log().all();
	}
	
	

}
