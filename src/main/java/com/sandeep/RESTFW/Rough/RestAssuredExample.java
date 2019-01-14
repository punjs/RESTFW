package com.sandeep.RESTFW.Rough;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sandeep.RESTFW.Utils.ConfigProperties;

import io.restassured.RestAssured;
import io.restassured.response.Response;



public class RestAssuredExample {
	
	public static ConfigProperties config;
	
	@BeforeMethod
	public void beforemethod()
	{

	ConfigFactory.setProperty("environment", "Stage");
    config = ConfigFactory.create(ConfigProperties.class);
	System.out.println(""+config.getbasePath());
	System.out.println(""+config.getbaseURI());
	RestAssured.baseURI="";
	RestAssured.basePath="";
	 
	}
	
	
	
	 @Test public void createACustomer() 
	 {
		 
	  Response response =
			 given().auth().basic("sk_test_ioU0sh31xy8x56htaaZqLsQ1", "")
			 .formParam("email", "rahul111@gmail.com") .formParam("description",
			 "Added this customer using restasurred")
			 .post("/customers").then().extract().response();

}
}
