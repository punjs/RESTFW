package com.sandeep.RESTFW.Setup;

import java.lang.reflect.Method;

import org.aeonbits.owner.ConfigFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.sandeep.RESTFW.Utils.ConfigProperties;
import com.sandeep.RESTFW.Utils.ExcelReader;
import com.sandeep.RESTFW.Utils.ExtentManager;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestSetup {

	public static ConfigProperties configProperties=null;
	public static RequestSpecification requestspecification;
	
	public ExcelReader excelReader = new ExcelReader(System.getProperty("user.dir")+
			"\\src\\test\\resources\\testData\\TestData.xlsx");
	
	protected static ExtentReports extent;
    protected static ThreadLocal<ExtentTest> ClasslevelLogger = new ThreadLocal<ExtentTest>();
    protected static ThreadLocal<ExtentTest> TestLevelLogger = new ThreadLocal<ExtentTest>();
	

	@BeforeSuite
	public void setUp() {
		
		ConfigFactory.setProperty("environment", "dev");
		configProperties = ConfigFactory.create(ConfigProperties.class);
		extent=ExtentManager.GetExtent();

		RestAssured.baseURI = configProperties.getbaseURI();
		RestAssured.basePath = configProperties.getbasePath();
		//System.out.println(""+System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\TestData.xlsx");

	}

	@BeforeTest
	public void beforeTest() {
		

	}

	@BeforeClass
	public void beforeClass() {
		 ExtentTest parent = extent.createTest(getClass().getSimpleName());
	
		 ClasslevelLogger.set(parent);
		
	}

	@BeforeMethod
	public void beforeMethod(Method method)

	{
		//ExtentTest child = ClasslevelLogger.get().createNode(method.getName());
		//TestLevelLogger.set(child);
		requestspecification=setRequestSpecification(configProperties.getsecretKey());
		
		
		
	}

	@AfterMethod
	public void afterMethod(ITestResult TestCaseResult) {
		
		//if(TestCaseResult.getStatus()==TestCaseResult.FAILURE)
		//{
			//TestLevelLogger.get().fail("The testCase : "+TestCaseResult.getMethod().getMethodName()+" is failed");
			//	}
		//else if(TestCaseResult.getStatus()==TestCaseResult.SKIP)
		//{
			//TestLevelLogger.get().skip("The testCase : "+TestCaseResult.getMethod().getMethodName()+" is skipped ");
		//}
		//else
		//{
			//TestLevelLogger.get().pass("The testCase : "+TestCaseResult.getMethod().getMethodName()+" is Passed ");
		//}
		
		
		
		//extent.flush();

	}

	@AfterClass
	public void afterClass() {
 
	}

	@AfterTest
	public void afterTest() {

	}

	@AfterSuite
	public void tearDown() {
		//extent.flush();
	}

	public static ExtentTest Logger()
	{
		return TestLevelLogger.get();
	}	

	public static RequestSpecification setRequestSpecification(String Key)
	{
		return given().auth().basic(Key, "").when();
	}
	
	
	public static RequestSpecification setFormParams(String arguments,RequestSpecification requestspec)
	{
		String[] argument =arguments.split(";");
		for (String x:argument)
		{
			String[] KeyvaluePair=x.split(":");
			requestspec.formParams(KeyvaluePair[0], KeyvaluePair[1]);
			System.out.println(""+KeyvaluePair[0]+" , "+KeyvaluePair[1]);
		}
		
		return requestspec;
		}




}
	
 ///   given().auth().basic("sk_test_kzxPb2wjsBPiIh7QxZKqJU3a", "").get("customers/cus_DeMcLi6a0ci6tD").then().extract().response();
