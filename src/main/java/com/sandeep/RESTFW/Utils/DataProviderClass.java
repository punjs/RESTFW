package com.sandeep.RESTFW.Utils;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.sandeep.RESTFW.Setup.TestSetup;


public class DataProviderClass extends TestSetup {
	
	/*@DataProvider(name="dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excelReader.getRowCount(sheetName);//5
		int cols = excelReader.getColumnCount(sheetName);//2

		Object[][] data = new Object[rows - 1][1];
		//int[] array= new int[1][1];
		//array[0][0]=10

		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) {//rows=3

			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum < cols; colNum++) {//cols=2

				table.put(excelReader.getCellData(sheetName, colNum, 1), excelReader.getCellData(sheetName, colNum,rowNum ));
				data[rowNum - 2][0] = table;//{endPoint=/customer,expectedCode=200}
			}

		}
		return data;

		// System.out.println(data); return data;

	}*/
	

	@DataProvider(name="dp")
	public  Object[][] getData(Method m) {

		//System.out.println(configProperties);
		//System.out.println("SheetName-->"+configProperties.getsheetname());
		String sheetName=configProperties.getsheetname();
		int rows = excelReader.getRowCount(sheetName);//100
		String testName = m.getName();
		System.out.println("The test case method running is "+testName);
		System.out.println("====================================================");
		System.out.println("The number of Total rows in sheet is "+rows);
		int testCaseRowNum = 1;

		for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {

			String testCaseName = excelReader.getCellData(sheetName, 0, testCaseRowNum);
			
			//System.out.println("TestCase name in excel-->"+testCaseName);
			if (testCaseName.equalsIgnoreCase(testName))
				break;

		}// Checking total rows in test case
		System.out.println("====================================================");

		System.out.println("The test case name found in Data Sheet is "+testName);
		int dataStartRowNum = testCaseRowNum + 2;//dataStartRowNum=8

		int testRows = 0;
		while (!excelReader.getCellData(sheetName, 0, dataStartRowNum + testRows).equalsIgnoreCase("endOfTestData")) {

			testRows++;
		}
		System.out.println("====================================================");
		System.out.println("The no of rows found after test case name to endofTestData is  "+testRows);
		// Checking total cols in test case

		//System.out.println("Total no of rows:"+testRows);
		int colStartColNum = testCaseRowNum + 1;//7
		System.out.println("====================================================");
		System.out.println("The column start number for data reading of test case is   "+colStartColNum);
		int testCols = 0;

		while (!excelReader.getCellData(sheetName, testCols, colStartColNum).equals("")) {

			testCols++;

		}
		//[2][1]
		System.out.println("====================================================");
		System.out.println("The total column for data reading in test case is   "+testCols);
		
		Object[][] data = new Object[testRows][1];
		//object[][] data= new Object[2][1];
		//data[0][0]=
		//data[1][0]=

		int i = 0;
		for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++) {

			Hashtable<String, String> table = new Hashtable<String, String>();

		
			for (int cNum = 0; cNum < testCols; cNum++) {

				String colName = excelReader.getCellData(sheetName, cNum, colStartColNum);
				String testData = excelReader.getCellData(sheetName, cNum, rNum);
				

				table.put(colName, testData);

			}

			data[i][0] = table;
			i++;

		}

		return data;
	}

}
