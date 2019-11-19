package com.amazonUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ContextClickAction;
import org.openqa.selenium.support.ui.Select;

import com.amazonTestBase.AmazonBase;

public class AmazonUtility extends AmazonBase {

	public AmazonUtility() throws IOException {
		super();
	}

	public static String filePath = "C:\\Users\\prapatil0\\git\\testAmazon\\com.qa.amazon\\src\\main\\java\\com\\amazonTestdata\\amazonTestData.xlsx";
	public static Workbook wb;
	public static Sheet sheet;

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

	public static void screenshot() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(destination + "/screenshot" + System.currentTimeMillis() + ".png"));
	}

	public static void mouseHover(WebElement ele) {
		act.moveToElement(ele).perform();
	}

	public static void selectDropDownValue(WebElement ele, String value) {
		Select select = new Select(ele);
		select.deselectByValue(value);
	}

	public static void JSClick(WebElement ele) {
		if (ele.isDisplayed() && ele.isEnabled()) {
			System.out.println("clicking on element using java script");
			((JavascriptExecutor) driver).executeScript("arguments[0].click", ele);
			System.out.println("clicked on the element");
		} else {
			System.out.println("unable to click on the element");
		}
	}

	public static void scrollByPixel(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public static void scrollByVisibleElement(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}

	public static void moveToElement(WebElement ele) {
		act.moveToElement(ele);
	}

	public static void doubleClick(WebElement ele) {
		act.doubleClick();
	}
	
	public static void rightClick(WebElement ele) {
		act.contextClick(ele).build().perform();
	}
}
