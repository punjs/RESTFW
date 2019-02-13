package com.sandeep.RESTFW.Testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandeep.RESTFW.POJOClasses.Allcharge;
import com.sandeep.RESTFW.POJOClasses.AllnewCharges;
//import com.sandeep.RESTFW.POJOClasses.Charges;
import com.sandeep.RESTFW.POJOClasses.Customer;
import com.sandeep.RESTFW.POJOClasses.test;
import com.sandeep.RESTFW.Setup.TestSetup;
import com.sandeep.RESTFW.StripeAPI.ChargeAPI;
import com.sandeep.RESTFW.StripeAPI.CustomerAPI;
import com.sandeep.RESTFW.Utils.DataProviderClass;
import com.sun.media.jfxmedia.logging.Logger;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class VerifyChargeAPI extends TestSetup {
	
	@Test(dataProviderClass=DataProviderClass.class,dataProvider="dp",enabled = false)
	public void verifyCreateCharge(Hashtable<String, String> data) throws JsonParseException, JsonMappingException, IOException
	{
		//Response response = 
			//	setFormParams(data.get("argument"),requestspecification).when().post("/charges").then()
		//.extract().response();
		
		
		
		
		
		Response response=CustomerAPI.sendPostRequestWithValidData(data);
		//System.out.println(response.asString());
		//ObjectMapper mapper = new ObjectMapper();
       //Charges charge =mapper.readValue(response.asString(), Charges.class);
       System.out.println(response.asString());
		
		
		
		//Charges charge =new ObjectMapper().readValue(response.asString(), Charges.class);
		//System.out.println(response.getStatusCode());
		//int a=charge.getObject().length();
		//System.out.println(""+charge.getCreated());
		Logger().info(response.prettyPrint());	
		Logger().log(Status.INFO, "Applying soft assertion on the Status Code");
		//System.out.println(""+charge.getId());\
	Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
	
		

	}

	@Test (dataProviderClass=DataProviderClass.class,dataProvider="dp",enabled = true,priority =1)
	public void verifyRetrieveCharge(Hashtable<String, String> data) throws JsonParseException, JsonMappingException, IOException
	{
		Response response =
				ChargeAPI.setRequestSpecification2().get(data.get("endpoint"))
				.then()
				.extract()
				.response();
		//Charges charge =new ObjectMapper().readValue(response.asString(), Charges.class);
		
		JsonPath jsonpath =new JsonPath(response.asString());
		Logger().log(Status.INFO,"The reponse is " +response.prettyPrint());
		try{
	Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
	    Logger().log(Status.PASS,"Assertion for the Status code is passed");
		}
		catch(Exception e) {
			Logger().log(Status.FAIL,"Assertion for the Status code is Failed");
			e.getStackTrace();
			}
		try{
		Assert.assertEquals("ch_1DwmfkJ06AnIpd2yPPLsRCv9", jsonpath.get("id"));	
		 Logger().log(Status.PASS,"Assertion for the Charge id is passed");
		}
		catch(Exception e) {
			Logger().log(Status.FAIL,"Assertion for the Status code is Failed");
			e.getStackTrace();
			}
	}
		@Test (dataProviderClass=DataProviderClass.class,dataProvider="dp",enabled = true,priority =2)
		public void verifyRetrieveAllCharge(Hashtable<String, String> data) throws JsonParseException, JsonMappingException, IOException
		{
			Response response =ChargeAPI.setRequestSpecification2()
			.param("limit",data.get("limit")).when().get(data.get("endpoint")).then()
			.extract().response();
			
			AllnewCharges charge =new ObjectMapper().readValue(response.asString(), AllnewCharges.class);
			//ObjectMapper mapper = new ObjectMapper();
			//test[] AllnewCharges = mapper.readValue(response.asString(), test[].class);
			//int a =charge.getData().length;
			
			for (int a =0; a<charge.getData().length;a++)
			{
				System.out.println("+++++++   "+charge.getData()[a].getId());
				
			}
			
			
		}
	
		
		
		
	}
	
	
	
	
	
	
	
	
	




//given().accept(ContentType.JSON).auth().basic("sk_test_jC6eITHKDfkrV9KkdYZBYML9", "")
//.param("amount", "100").param("currency", "USD").param("source", "token_mastercard")
//.param("description", "Testing the API through framework").when().post("ttps://api.stripe.com/v1/charges").then()
//.extract().response();
