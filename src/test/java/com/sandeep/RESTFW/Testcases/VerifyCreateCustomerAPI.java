package com.sandeep.RESTFW.Testcases;

import java.io.IOException;
import java.util.Hashtable;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandeep.RESTFW.POJOClasses.Customer;
//import com.sandeep.RESTFW.POJOClasses.RetrieveCustomer.GetCustomer;
import com.sandeep.RESTFW.Setup.TestSetup;
import com.sandeep.RESTFW.StripeAPI.CustomerAPI;
import com.sandeep.RESTFW.Utils.DataProviderClass;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class VerifyCreateCustomerAPI extends TestSetup {
	
	
		
		
		@Test(dataProviderClass=DataProviderClass.class,dataProvider="dp",enabled = true)
		public void verifyCreateCustomer(Hashtable<String, String> data) throws JsonParseException, JsonMappingException, IOException
		{
			Response response=CustomerAPI.sendPostRequestWithValidData(data);
			//Assert.assertEquals(response.getStatusCode(),data.get("expectedStatusCode"));//assertEquals(response.getStatusCode(), data.get("expectedStatusCode"));
			
			//System.out.println(response.asString());
			
			ObjectMapper mapper = new ObjectMapper();
			Customer customer =mapper.readValue(response.asString(), Customer.class);
			
			System.out.println(""+customer.getEmail());
			//System.out.println(""+data.get("argument"));
			//Assert.assertEquals(customer.getEmail(),data.get("email"));
			
		}
			
		
		@Test(dataProviderClass=DataProviderClass.class,dataProvider="dp",enabled = true)
		public void VerifyDeleteCustomer(Hashtable<String, String> data) throws JsonParseException, JsonMappingException, IOException
		{
			Response response=CustomerAPI.senddeleteRequest(data);
			System.out.println("the deletion id is"+response.asString());
			//ObjectMapper mapper = new ObjectMapper();
			//Customer customer =mapper.readValue(response.asString(), Customer.class);
			//System.out.println("the deletion id is"+customer.getId());
			JsonPath json=response.jsonPath();
			System.out.println(json.get("id"));
			
			
		
		}
		
		@Test(dataProviderClass=DataProviderClass.class,dataProvider="dp",enabled = true)
		public void VerifyRetrieveCustomer(Hashtable<String, String> data) throws JsonParseException, JsonMappingException, IOException
		{
			
			Response response=CustomerAPI.sendgetRequest(data);
			System.out.println(""+response.asString());
			ObjectMapper mapper = new ObjectMapper();
			Customer customer =mapper.readValue(response.asString(), Customer.class);
			System.out.println(customer.getSubscriptions().getUrl());
		}
		

		@Test(dataProviderClass=DataProviderClass.class,dataProvider="dp",enabled = true)
		public void VerifyUpdateCustomer(Hashtable<String, String> data) throws JsonParseException, JsonMappingException, IOException
		{
			
			Response response=CustomerAPI.sendPostRequestWithSingleData(data);
			System.out.println(""+response.asString());
			ObjectMapper mapper = new ObjectMapper();
			Customer customer =mapper.readValue(response.asString(), Customer.class);
			System.out.println(customer.getLivemode());
			System.out.println(customer.getDescription());
		}
		
		@Test(dataProviderClass=DataProviderClass.class,dataProvider="dp",enabled = true)
		public void VerifyUpdateCustomer1(Hashtable<String, String> data) throws JsonParseException, JsonMappingException, IOException
		{
			
			Response response=CustomerAPI.sendPostRequestWithValidData(data);
			System.out.println(""+response.asString());
			ObjectMapper mapper = new ObjectMapper();
			Customer customer =mapper.readValue(response.asString(), Customer.class);
			System.out.println(customer.getLivemode());
			System.out.println(customer.getDescription());
		}

		

		@Test(dataProviderClass=DataProviderClass.class,dataProvider="dp",enabled = true)
		public void VerifyAllCustomer(Hashtable<String, String> data) throws JsonParseException, JsonMappingException, IOException
		{
			
			Response response=CustomerAPI.sendgetRequest(data);
			System.out.println(""+response.asString());
			ObjectMapper mapper = new ObjectMapper();
			Customer customer =mapper.readValue(response.asString(), Customer.class);
			System.out.println(response.asString());
			//System.out.println(customer.getDescription());
		}

		}
		
		
		

		