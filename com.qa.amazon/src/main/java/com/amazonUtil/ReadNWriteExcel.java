package com.amazonUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadNWriteExcel {

	public static String ReadNWriteExcel() throws IOException {

		// path of the test data sheet
		File src = new File(
				"C:\\Users\\prapatil0\\eclipse-workspace\\com.qa.amazon\\src\\main\\java\\com\\amazonTestData\\amazonTestData.xlsx");

		FileInputStream fis = new FileInputStream(src);
		//take a xssf workbook to load the test data sheet
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//specify the sheet name of the workbook using getSheetAt method
		XSSFSheet sheet = workbook.getSheetAt(0);
		//using the sheet specify the row and column which we need to interact
		String data0 = sheet.getRow(1).getCell(2).getStringCellValue();
		
		System.out.println("data from excel is " +data0);
		
		return data0;
		
	}
}
