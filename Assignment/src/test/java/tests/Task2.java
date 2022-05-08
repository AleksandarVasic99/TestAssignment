package tests;

import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Task2 {
	
//This test will work but because i lack experience and knowledge about RestAssured,the token need to be manually added.	
	@Test
	@Order(1)
	public void creatingNewUser() {
	    
	    Header authorizationHeader = new Header("Authorization", "Bearer 753caa41dcc7ff29aa41b85a0b4fc53052cff4ea3b1689ef7649695c328730bc");
	    RequestSpecification httpRequest = RestAssured.given();
	   
	    String user = "{\r\n" + "\r\n" + "        \"name\": \"Marko Markovic \",\r\n"
				+ "        \"email\": \"markic@schneider.io\",\r\n" + "        \"gender\": \"male\",\r\n"
				+ "        \"status\": \"inactive\"\r\n" + "    }";
	    
	    Response response = httpRequest.header(authorizationHeader).header("Content-Type", "application/json").body(user).post("https://gorest.co.in/public/v2/users");
	    Assert.assertEquals(201, response.getStatusCode());
	}
	

//And again because a lack of experience and knowledge i'm not able to automatically pull the id of the user that i made,also i think that it is impossible because the get method doesn't pull all of the users.	
	@Test
	@Order(2)
	public void updatingNewUser() {
		Header authorizationHeader = new Header("Authorization", "Bearer 753caa41dcc7ff29aa41b85a0b4fc53052cff4ea3b1689ef7649695c328730bc");
		RequestSpecification httpRequest = RestAssured.given();
		 String payload = "{\r\n" + "\r\n" + "        \"name\": \"Milenaa \",\r\n"
					+ "        \"email\": \"milenana@schneider.io\",\r\n" + "        \"gender\": \"male\",\r\n"
					+ "        \"status\": \"inactive\"\r\n" + "    }";
		Response res = httpRequest.when().get("https://gorest.co.in/public/v2/users");
		JsonPath js =res.jsonPath();
		Object aaa = js.getList("id");
		System.out.println(aaa);
		
		Response response = httpRequest.header(authorizationHeader).header("Content-Type", "application/json").body(payload).put("https://gorest.co.in/public/v2/users/4056");
		Assert.assertEquals(200, response.getStatusCode());
		
	}
	
	
	@Test
	@Order(3)
	public void deletingNewUser() {
		Header authorizationHeader = new Header("Authorization", "Bearer 753caa41dcc7ff29aa41b85a0b4fc53052cff4ea3b1689ef7649695c328730bc");
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.when().header(authorizationHeader).delete("https://gorest.co.in/public/v2/users/4025");
		Assert.assertEquals(204, response.getStatusCode());
	}


	
	


}
