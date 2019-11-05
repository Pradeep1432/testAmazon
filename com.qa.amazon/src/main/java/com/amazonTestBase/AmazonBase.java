package com.amazonTestBase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class AmazonBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static SoftAssert softAssert;

	public static void initialization() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium\\SeleniumDrivers\\latestChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
		wait = new WebDriverWait(driver, 30);
		softAssert = new SoftAssert();
		
	}
}
