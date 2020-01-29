package com.amazonUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.Destination;

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

	public static String Path = "C:\\Users\\prapatil0\\git\\testAmazon\\com.qa.amazon\\src\\main\\java\\com\\amazonTestdata\\amazonTestData.xlsx";
	public static Workbook wb;
	public static Sheet sheet;

	public static Object[][] readTestData(String sheetName) {
		try {
			FileInputStream file = new FileInputStream(Path);
			wb = new WorkbookFactory().create(file);
			wb.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// create a 2D object array
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(data);

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = i + 1; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		return data;
	}
	
	public void takeScreenshot() throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir");
		FileUtils.copyFile(src, new File(destination + "/screenshot" +System.currentTimeMillis() + ".png"));		
	}	
	

	public static void mouseHover(WebElement ele) {
		act.moveToElement(ele).perform();
	}

	public static void selectDropDownValue(WebElement ele, String value) {
		Select select = new Select(ele);
		select.selectByValue(value);
	}

	public static void selectDropDownIndex(WebElement ele, Integer No) {
		Select select = new Select(ele);
		select.selectByIndex(No);
	}

	public static void selectDropDownByVisibleText(WebElement ele, String text) {
		Select select = new Select(ele);
		select.selectByVisibleText(text);
	}

	public static void switchToFrameById(Integer index) {
		driver.switchTo().frame(index);
	}

	public static void switchToFrameEle(WebElement ele) {
		driver.switchTo().frame(ele);
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
