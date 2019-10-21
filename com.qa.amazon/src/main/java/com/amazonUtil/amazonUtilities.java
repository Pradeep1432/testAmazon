package com.amazonUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.amazonTestBase.amazonTestBase;

public class amazonUtilities extends amazonTestBase{
	
	public static long PAGELOADTIMEOUT = 30;
	public static long IMPLICITWAIT = 30;
	
	public static File src = new File("C:\\Users\\prapatil0\\eclipse-workspace\\com.qa.amazon\\src\\main\\java\\com\\amazonTestData\\amazonTestData.xlsx");
	
	public void screenshot() {		
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
		String dir = System.getProperty("user.dir");
	}
	
	public static String readExcel() throws IOException {
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		String data = sheet1.getRow(1).getCell(1).getStringCellValue();
		System.out.println("Test data at 1st row n 1 col is " +data);
		
		return data;
		
	}

}
