 package BDD;
import java.util.ArrayList;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public  class Testcases {
	JSONObject req = new JSONObject();
	HashMap<String, Object> map = new HashMap<String, Object>();
	
	@BeforeClass
	public void postprereq()
	{	
		RestAssured.baseURI = "https://reqres.in/api/users";
		req.put("name","Anderson");
		req.put("job", "Athlete");	
		
	}
	
@Test
public void posttest()
{
	given()
	.body(req.toJSONString()).post()
	.then()
	.statusCode(201).log().all().assertThat().statusCode(201);		
}

@Test
public void posttest1()
{
	map.put("name","Anderson");
	map.put("job", "Athlete");	
	given()
	.body(map.toString()).post()
	.then()
	.statusCode(201).log().all().assertThat().statusCode(201);		
}


	@Test
public void gettest() 
{	
	Response response =  given().
	when().get("https://reqres.in/api/users?page=2").
	then().assertThat().body("data",hasSize(6))
	.statusCode(200)
	.assertThat().body("data[1].id", equalTo(8))
	.assertThat().statusCode(200)
	// get the entire data
	.extract().response();	
	// Converet in to String
	String str = response.asString();
	System.out.println("*************GET***********" + str);
	
	Assert.assertEquals(str.contains("To keep ReqRes free, contributions towards server costs are appreciated!"),true);
}
	
	@Test
	
	// Using manual json string 
	public void puttest()
	{
		given().
		body("{\n \"name\" : \"Korla\" , \n \"job\" : \"Pilot\"\n}").put("https://reqres.in/api/users/2")
		.then()
		.statusCode(200).log().all();			
	}
	@Test
	public void puttest1()
	{
		given().body(req.toJSONString()).put("https://reqres.in/api/users/2")
		.then()
		.statusCode(200).log().all();		
				
	}
	@Test
	public void DeletTest()
	{
		Response response = given()
		.when().delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204).log().all().extract().response();		
		System.out.println("*********  " + response.asString());		
		Assert.assertEquals(response.asString().contains("blbabla"), false);
	}
	
	
}
