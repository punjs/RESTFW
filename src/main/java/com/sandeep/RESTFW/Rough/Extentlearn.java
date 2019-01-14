package com.sandeep.RESTFW.Rough;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extentlearn {
	
	private static ExtentReports extent1;
	private static ExtentHtmlReporter htmlreporter1;
	private static String filePath = "./extentreport.html";
	
	public ExtentReports getExtent()
	{
		if(extent1!=null)
		{
			return extent1;
		}else
		extent1 =new ExtentReports();	
		extent1.attachReporter(getReporter());
		extent1.setSystemInfo("Host Name", "Rahul@Java");
		
		extent1.setAnalysisStrategy(AnalysisStrategy.CLASS);
		return extent1;
	}
	
	
	public ExtentHtmlReporter getReporter()
	{
		
		htmlreporter1 = new ExtentHtmlReporter(filePath);
		htmlreporter1.loadXMLConfig(System.getProperty("user.directory")+"src\\test\\resources\\extentConfigproperty\\ReportsConfig.xml");
		return htmlreporter1;
		
		
	}
	
	
	ThreadLocal<ExtentTest> ClassLevelLog =new ThreadLocal<ExtentTest>();
	ThreadLocal<ExtentTest> MethodLevelLog =new ThreadLocal<ExtentTest>();
	
	
}
