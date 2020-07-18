package com.sandeep.RESTFW.Setup;

import static io.restassured.RestAssured.given;

import java.lang.reflect.Method;
import java.util.Arrays;

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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.sandeep.RESTFW.Utils.ConfigProperties;
import com.sandeep.RESTFW.Utils.ExcelReader;
import com.sandeep.RESTFW.Utils.ExtentManager;
import com.sandeep.RESTFW.Utils.JSONUtils;
import com.sandeep.RESTFW.Utils.TestUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import sun.rmi.runtime.Log;

public class TestSetup
{

    public static ConfigProperties configProperties = null;

    public static RequestSpecification requestspecification;

    public static SoftAssert softassertion = new SoftAssert();

    public ExcelReader excelReader =
        new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\TestData.xlsx");

    protected static ExtentReports extent;

    protected static ThreadLocal<ExtentTest> ClasslevelLogger = new ThreadLocal<ExtentTest>();

    protected static ThreadLocal<ExtentTest> TestLevelLogger = new ThreadLocal<ExtentTest>();

    @BeforeSuite
    public void setUp()
    {

        ConfigFactory.setProperty("environment", "dev");
        configProperties = ConfigFactory.create(ConfigProperties.class);
        extent = ExtentManager.GetExtent();

        RestAssured.baseURI = configProperties.getbaseURI();

        RestAssured.basePath = configProperties.getbasePath();
        // System.out.println(""+System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\TestData.xlsx");
        TestUtils.moveReportToAchive();
    }

    @BeforeTest
    public void beforeTest()
    {

    }

    @BeforeClass
    public void beforeClass()
    {
        ExtentTest parent = extent.createTest(getClass().getSimpleName());

        ClasslevelLogger.set(parent);

    }

    @BeforeMethod
    public void beforeMethod(Method method)

    {
        ExtentTest child = ClasslevelLogger.get().createNode(method.getName());
        TestLevelLogger.set(child);
        //requestspecification = setRequestSpecification(configProperties.getsecretKey());

    }

    @AfterMethod
    public void afterMethod(ITestResult TestCaseResult)
    {
    	
    	
    	if(TestCaseResult.getStatus()==TestCaseResult.FAILURE)
    	{
    		String excepionMessage = Arrays.toString(TestCaseResult.getThrowable().getStackTrace());
    		Logger()
    				.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
    						+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
    						+ " \n");


    		String failureLogg = "This Test case got Failed";
    		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
    		Logger().log(Status.FAIL, m);
    		
    		
    	}
    		else if(TestCaseResult.getStatus()==TestCaseResult.SKIP)
    		{
    			String methodname =TestCaseResult.getMethod().getMethodName();
    			
    			
    			String LogTest = "<b>"+"Test Case:- " +methodname+" Skipped"+"</b>";
    		


    			
    			Markup m = MarkupHelper.createLabel(LogTest, ExtentColor.YELLOW);
    			Logger().log(Status.SKIP,m);		
    			
    		}
    		else
    		{
    			String methodname =TestCaseResult.getMethod().getMethodName();
    			
    			
    			String LogTest = "<b>"+"Test Case:- " +methodname+" Passed"+"</b>";
    		}
    	
    	extent.flush();
    	}
    	
    	

/*        // if(TestCaseResult.getStatus()==TestCaseResult.FAILURE)
        // {
        // TestLevelLogger.get().fail("The testCase : "+TestCaseResult.getMethod().getMethodName()+" is failed");
        // }
        // else if(TestCaseResult.getStatus()==TestCaseResult.SKIP)
        // {
        // TestLevelLogger.get().skip("The testCase : "+TestCaseResult.getMethod().getMethodName()+" is skipped ");
        // }
        // else
        // {
        // TestLevelLogger.get().pass("The testCase : "+TestCaseResult.getMethod().getMethodName()+" is Passed ");
        // }

        // extent.flush();

    }*/

    @AfterClass
    public void afterClass()
    {

    }

    @AfterTest
    public void afterTest()
    {

    }

    @AfterSuite
    public void tearDown()
    {
        // extent.flush();
    }

    public static ExtentTest Logger()
    {
        return TestLevelLogger.get();
    }

public static <T> void logDetails(final T response,String logtype)
{
	String res = JSONUtils.toJSON(response);
	Logger().log(Status.INFO,
	("<details>" + "<summary>" + "<b>" + "<font color=" + "blue>" + logtype
	+ "</font>" + "</b >" + "</summary>" + res.replaceAll(",", "<br>") + "</details>"
	+ " \n"));
}		



}

//    public static RequestSpecification setRequestSpecification(String Key)
//    {
//        return given().accept(ContentType.JSON).auth().basic(Key, "");
//
//    }

//    public static RequestSpecification setRequestSpecification1()
//    {
//        return given().accept(ContentType.JSON).auth().basic(configProperties.getsecretKey(), "").when();
//    }
//
//    public static RequestSpecification setFormParams(String arguments, RequestSpecification requestspec)
//    {
//        String[] argument = arguments.split(";");
//        for (String x : argument) {
//            String[] KeyvaluePair = x.split(":");
//            requestspec.formParams(KeyvaluePair[0], KeyvaluePair[1]);
//            System.out.println("" + KeyvaluePair[0] + " , " + KeyvaluePair[1]);
//        }
//
//        return requestspec;
//    }
//
//}
//
///// given().auth().basic("sk_test_kzxPb2wjsBPiIh7QxZKqJU3a",
///// "").get("customers/cus_DeMcLi6a0ci6tD").then().extract().response();
