package com.sandeep.RESTFW.StripeAPI;

import static io.restassured.RestAssured.given;

import com.sandeep.RESTFW.Setup.TestSetup;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ChargeAPI  extends TestSetup {

	public static  RequestSpecification setRequestSpecification2()
	{
		return given().accept(ContentType.JSON).auth().basic(configProperties.getsecretKey(), "").when();
	}
	
}
