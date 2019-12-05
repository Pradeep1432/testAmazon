package com.amazonTestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.record.FilePassRecord;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class AmazonBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static SoftAssert softAssert;
	public static Actions act;
	public static Wait fWait;
	
	String propPath = "C:\\Users\\prapatil0\\git\\testAmazon\\com.qa.amazon\\src\\main\\java\\com\\amazonProperties\\amazon.properties";
	

	public AmazonBase() {
		try {
			prop = new Properties();
			FileInputStream filePath = new FileInputStream(propPath);
			prop.load(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Selenium\\SeleniumDrivers\\latestChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
		softAssert = new SoftAssert();
		act = new Actions(driver);
		fWait = new FluentWait(driver);
	}
}
