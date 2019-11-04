package com.amazonUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.amazonTestBase.amazonBase;

public class amazonUtility extends amazonBase {

	public static String filePath = "C:\\Users\\prapatil0\\git\\testAmazon\\com.qa.amazon\\src\\main\\java\\com\\amazonTestdata\\amazonTestData.xlsx";
	static Workbook wb;
	static Sheet sheet;

	public static Object[][] readTestData(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(filePath);
		wb = WorkbookFactory.create(file);
		sheet = wb.getSheet(sheetName);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum() + "---" + sheet.getRow(0).getLastCellNum());

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		return data;
	}

}
