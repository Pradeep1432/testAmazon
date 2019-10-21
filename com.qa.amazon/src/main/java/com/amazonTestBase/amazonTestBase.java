package com.amazonTestBase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class amazonTestBase {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public amazonTestBase() {
		
	}
	
	public static void initilization() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\SeleniumDrivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
	}
	
	
	

}
