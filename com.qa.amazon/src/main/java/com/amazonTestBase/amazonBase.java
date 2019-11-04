package com.amazonTestBase;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazonBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static void initialization() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\SeleniumDrivers\\latestChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.in");
	}
}
