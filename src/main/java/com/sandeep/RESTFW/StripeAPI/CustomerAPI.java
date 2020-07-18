package com.sandeep.RESTFW.StripeAPI;

import java.util.Hashtable;

import com.sandeep.RESTFW.Setup.TestSetup;

import io.restassured.response.Response;

public class CustomerAPI extends TestSetup {
	
//	public static Response sendPostRequestWithValidData(Hashtable<String,String> data)
	
	{
		//System.out.println("Hallo");
		//Response response =
//				 setFormParams(data.get("argument"),requestspecification)
//				 .post(data.get("endpoint")).then().extract().response();
//			return response;
	}
	
	
public static Response senddeleteRequest(Hashtable<String,String> data)
	
	{
		Response response =
				 requestspecification
				 .delete(data.get("endpoint")).then().extract().response();
			return response;
	}




public static Response sendgetRequest(Hashtable<String,String> data)

{
	System.out.println(""+data.get("endpoint"));
	Response response =
			 requestspecification
			 .get(data.get("endpoint")).then().extract().response();
		return response;
}


public static Response sendPostRequestWithSingleData(Hashtable<String,String> data)

{
	System.out.println(data.get("description"));
	System.out.println(data.get("endpoint"));
	Response response =
			 
			requestspecification.formParam(data.get("description"))
			.post(data.get("endpoint")).then().extract().response();
	System.out.println("Hallo2");
		return response;
}


}
///   given().auth().basic("sk_test_kzxPb2wjsBPiIh7QxZKqJU3a", "").get("customers/cus_DeMcLi6a0ci6tD").then().extract().response();