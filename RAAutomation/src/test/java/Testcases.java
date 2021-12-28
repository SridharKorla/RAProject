import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Testcases {

	
	@Test
	void testscode()
	
	{
		// Assign BaseURI
		RestAssured.baseURI = "https://reqres.in";
		
		// Request Object
		RequestSpecification httprequestobj = RestAssured.given();
		
		//Response object
		Response responseobj = httprequestobj.request(Method.GET,"/api/users?page=2");
		
	String responsebody = responseobj.getBody().asString();
//	responseobj.toString()
System.out.println( "Status line " + " " + responseobj.getStatusLine());

System.out.println( "Content Type " + " " + responseobj.getContentType());

System.out.println( "Content Type " + " " + responseobj.getHeader("Content-Type"));

System.out.println("***************************");
System.out.println(responsebody);
int statuscode = responseobj.getStatusCode();

Assert.assertEquals(statuscode,200);
Assert.assertEquals(responseobj.getContentType(),"application/json; charset=utf-8");
		
	}
	@Test
void testscode2()
	
	{
		// Assign BaseURI
		RestAssured.baseURI = "https://reqres.in";
		
		// Request Object
		RequestSpecification httprequestobj = RestAssured.given();
		
		//Response object
		Response responseobj = httprequestobj.request(Method.GET,"/api/users?page=2");
		
	String responsebody = responseobj.getBody().asString();
//	responseobj.toString()
System.out.println( "Status line " + " " + responseobj.getStatusLine());

System.out.println( "Content Type " + " " + responseobj.getContentType());

System.out.println( "Content Type " + " " + responseobj.getHeader("Content-Type"));

System.out.println("***************************");
System.out.println(responsebody);
int statuscode = responseobj.getStatusCode();

Assert.assertEquals(statuscode,200);
Assert.assertEquals(responseobj.getContentType(),"application/json; charset=utf-8");
		
	}
@Test
void testscode3()

{
	// Assign BaseURI
	RestAssured.baseURI = "https://reqres.in";
	
	// Request Object
	RequestSpecification httprequestobj = RestAssured.given();
	
	//Response object
	Response responseobj = httprequestobj.request(Method.GET,"/api/users?page=2");
	
String responsebody = responseobj.getBody().asString();


responsebody.strip();
//responseobj.toString()

System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*");
System.out.println( "body " + " " + responseobj.body());

System.out.println( "Content Type " + " " + responseobj.getContentType());

System.out.println( "Content Type " + " " + responseobj.getHeader("Content-Type"));

System.out.println("***************************");

System.out.println( "Body Strip " + " " + responsebody);
System.out.println("***************************");
HashMap<Object, Object> hm = responseobj.jsonPath().get("data[1]");

ArrayList hm1 = responseobj.jsonPath().get("data");
System.out.println(".............................,,,,,,,,,,,,,,,,,,,,,,,,,,,,");

 System.out.println(" Size of the data arraylist " + " " + hm1.size());

//for (Object i : hm1.keySet()) {
//	  System.out.println("key: " + i + " value: " + hm1.get(i));
//	}

//String stg = responseobj.jsonPath().get("data[1].last_name"));
//System.out.println(stg);

Assert.assertEquals(hm1.size(), 6);
int statuscode = responseobj.getStatusCode();
Assert.assertEquals(statuscode,200);
Assert.assertEquals(responseobj.getContentType(),"application/json; charset=utf-8");
	
}
	
}
