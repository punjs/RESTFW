package com.sandeep.RESTFW.Testcases;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sandeep.RESTFW.Setup.TestSetup;

import io.restassured.http.Method;
import io.restassured.response.Response;

public class SampleTest2 extends TestSetup {

	@Test
	public void check4()
	{
		
		Logger().log(Status.SKIP,"Assertion is being skipped");
	}
	
	@Test
	public void check5()
	{
		
		softassertion.assertEquals(true, true);
		Logger().log(Status.PASS,"Assertion for the Status code is Passed");
		
		softassertion.fail();
		Logger().log(Status.FAIL,"Assertion for the Status code is Failed");
		
		softassertion.assertEquals(true, true);
		Logger().log(Status.PASS,"Assertion for the Status code is Passed2");
		
		softassertion.assertAll();
		
	}
	@Test
	public void check6()
	{
		softassertion.fail();
		Logger().log(Status.FAIL,"Assertion for the Status code is Failed");
		softassertion.assertAll();
	}
	
	@Test
    public void test2()
    {
    	Response response = given().
    			auth().basic(
                "sk_test_51H3hf8G1vWrroZEBLBS7lK3oVThSnY0hwBpkUvFDAkcBlK7d17p5ac37xjOXHedlRnxmmFrd50x3miFuORGxmkJ100EKkIMm26",
                " ").formParam("description", "My Test").request(Method.POST, "https://api.stripe.com/v1/customers").then()
                .extract().response();
    	
    	//Converter conv = new Converter();
    	//System.out.println(conv.getresponse(response));
    	logDetails(response.asString(), "ResponseofAPI");
    	
    	
    	
    }
	
	
	
	
}
