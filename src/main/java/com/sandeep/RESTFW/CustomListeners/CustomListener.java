package com.sandeep.RESTFW.CustomListeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.sandeep.RESTFW.Setup.TestSetup;

public class CustomListener extends TestSetup implements ITestListener, ISuiteListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		Logger()
				.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
						+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
						+ " \n");


		String failureLogg = "This Test case got Failed";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		Logger().log(Status.FAIL, m);
		
		extent.flush();
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodname =result.getMethod().getMethodName();
		
		
		String LogTest = "<b>"+"Test Case:- " +methodname+" Skipped"+"</b>";
	


		
		Markup m = MarkupHelper.createLabel(LogTest, ExtentColor.YELLOW);
		Logger().log(Status.SKIP,m);		
		extent.flush();
		
	}

	public void onTestStart(ITestResult result) {
		ExtentTest child = ClasslevelLogger.get().createNode(result.getName());
		TestLevelLogger.set(child);
		
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodname =result.getMethod().getMethodName();
		
		
		String LogTest = "<b>"+"Test Case:- " +methodname+" Passed"+"</b>";
	


		
		Markup m = MarkupHelper.createLabel(LogTest, ExtentColor.GREEN);
		Logger().log(Status.PASS,m);		
		extent.flush();
		
	}

	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

}
