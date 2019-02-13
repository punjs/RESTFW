package com.sandeep.RESTFW.Utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.sandeep.RESTFW.Setup.TestSetup;

public class TestUtils {
	
	public static int getExpectedStatusCode(String expectedStatusCode)
	{
		return Integer.parseInt(expectedStatusCode);
	}
	
	public static void moveReportToAchive()
	{
		String newFileName="TestReport";
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timestamp =f.format(new Date());
		newFileName = newFileName + timestamp+ ".html";
		File file =new File("./extentreport.html");
if (file.renameTo(new File("./src/test/resources/archivedReports/"+newFileName)))
{
	System.out.println("File has been moved");
	file.delete();
}
else
{
	System.out.println("File has not been moved");
	
}
	}
}
