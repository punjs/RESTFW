package com.sandeep.RESTFW.Testcases;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandeep.RESTFW.POJOClasses.Customer;
//import com.sandeep.RESTFW.POJOClasses.RetrieveCustomer.GetCustomer;
import com.sandeep.RESTFW.Setup.TestSetup;
import com.sandeep.RESTFW.StripeAPI.CustomerAPI;
import com.sandeep.RESTFW.Utils.DataProviderClass;
import com.sandeep.RESTFW.Utils.TestUtils;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class VerifyCreateCustomerAPI extends TestSetup {
	
	
		
		
		@Test(dataProviderClass=DataProviderClass.class,dataProvider="dp",enabled = false)
		public void verifyCreateCustomer(Hashtable<String, String> data) throws JsonParseException, JsonMappingException, IOException
		{
			Response response=CustomerAPI.sendPostRequestWithSingleData(data);
			ObjectMapper mapper = new ObjectMapper();
			Customer customer =mapper.readValue(response.asString(), Customer.class);
			Logger().log(Status.INFO, "Applying soft assertion on the Status Code");
			softassertion.assertEquals(response.getStatusCode(), TestUtils.getExpectedStatusCode(data.get("expectedStatusCode")));
			Logger().log(Status.INFO, "Applying soft assertion on the Email ID");
			softassertion.assertEquals(customer.getEmail(), data.get("email"));
			
		}
			
		
		@Test(dataProviderClass=DataProviderClass.class,dataProvider="dp",enabled = false)
		public void VerifyDeleteCustomer(Hashtable<String, String> data) throws JsonParseException, JsonMappingException, IOException
		{
			Response response=CustomerAPI.senddeleteRequest(data);
			System.out.println("the deletion id is"+response.asString());
		    JsonPath json=response.jsonPath();
			System.out.println(json.get("id"));
		
		}
		
		@Test(dataProviderClass=DataProviderClass.class,dataProvider="dp",enabled = false)
		public void VerifyRetrieveCustomer(Hashtable<String, String> data) throws JsonParseException, JsonMappingException, IOException
		{
			
			Response response=CustomerAPI.sendgetRequest(data);
			System.out.println(""+response.asString());
			ObjectMapper mapper = new ObjectMapper();
			Customer customer =mapper.readValue(response.asString(), Customer.class);
			System.out.println(customer.getSubscriptions().getUrl());
		}
		

		@Test(dataProviderClass=DataProviderClass.class,dataProvider="dp",enabled = false)
		public void VerifyUpdateCustomer(Hashtable<String, String> data) throws JsonParseException, JsonMappingException, IOException
		{
			
			Response response=CustomerAPI.sendPostRequestWithSingleData(data);
			System.out.println(""+response.asString());
			ObjectMapper mapper = new ObjectMapper();
			Customer customer =mapper.readValue(response.asString(), Customer.class);
			System.out.println(customer.getLivemode());
			System.out.println(customer.getDescription());
		}
		
		@Test(dataProviderClass=DataProviderClass.class,dataProvider="dp",enabled = false)
		public void VerifyUpdateCustomer1(Hashtable<String, String> data) throws JsonParseException, JsonMappingException, IOException
		{
			
			Response response=CustomerAPI.sendPostRequestWithSingleData(data);
			System.out.println(""+response.asString());
			ObjectMapper mapper = new ObjectMapper();
			Customer customer =mapper.readValue(response.asString(), Customer.class);
			System.out.println(customer.getLivemode());
			System.out.println(customer.getDescription());
		}

		

		@Test(dataProviderClass=DataProviderClass.class,dataProvider="dp",enabled = false)
		public void VerifyAllCustomer(Hashtable<String, String> data) throws JsonParseException, JsonMappingException, IOException
		{
			
			Response response=CustomerAPI.sendgetRequest(data);
			System.out.println(""+response.asString());
			ObjectMapper mapper = new ObjectMapper();
			Customer customer =mapper.readValue(response.asString(), Customer.class);
			System.out.println(response.asString());
			//System.out.println(customer.getDescription());
		}
		
		@Test
		public  void bodyexample()
		{
			// This is a sample of sending Json as body using the map
			
			System.out.println("Checked");
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", "sandeep");
			map.put("job", "fighter");
			Response response =given().contentType(ContentType.JSON).body(map).when().post("https://reqres.in/api/users").then().extract().response();
			System.out.println(response.asString());
			response.prettyPrint();
			JsonPath json = response.jsonPath();
			Assert.assertEquals(json.get("name"),"sandeep");
			Logger().log(Status.PASS, "Assertion is passed");
			
		}
		
		@Test()
		public void JsonBodyasJson()
		{
			Response response=given().contentType(ContentType.JSON).body(new File ("./src/test/resources/JsonData/test.json")).when().post("https://reqres.in/api/users").then().extract().response();
			JsonPath json = response.jsonPath();
			Assert.assertEquals(json.get("name"),"morpheus");
			Logger().log(Status.PASS, "Assertion is passed when we passed Json body as a input");

		}
		


		}
		
		
		

		