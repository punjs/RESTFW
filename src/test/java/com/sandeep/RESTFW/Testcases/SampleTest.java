package com.sandeep.RESTFW.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.sandeep.RESTFW.Setup.TestSetup;

public class SampleTest extends TestSetup {
	
	
	
	
	@Test
	public void check2()
	{
		
		Logger().log(Status.SKIP,"Assertion is being skipped");
	}
	
	@Test
	public void check3()
	{
		
		Assert.assertEquals(true, true);
		Logger().log(Status.PASS,"Assertion for the Status code is Passed");
	}
	@Test
	public void check1()
	{
		softassertion.fail();
		Logger().log(Status.FAIL,"Assertion for the Status code is Failed");
	}

}
