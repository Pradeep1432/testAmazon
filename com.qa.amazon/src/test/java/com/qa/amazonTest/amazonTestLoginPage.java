package com.qa.amazonTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazonPages.amazonHomePage;
import com.amazonPages.amazonLoginPage;
import com.amazonTestBase.amazonBase;
import com.amazonUtil.amazonUtility;

public class amazonTestLoginPage extends amazonBase {

	amazonUtility amazonUtil;
	amazonLoginPage amazonLP;
	amazonHomePage amazonHP;

	String sheetName = "AmazonData";

	public amazonTestLoginPage() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		amazonUtil = new amazonUtility();
		amazonHP = new amazonHomePage();
		amazonLP = new amazonLoginPage();
	}

	@DataProvider
	public Object[][] acessTestData() throws EncryptedDocumentException, IOException {
		Object data[][] = amazonUtility.readTestData(sheetName);
		return data;
	}

	@Test(priority = 1)
	public void testHomePage() {
		amazonHP.homePageTitle();
	}

	@Test(priority = 2, dataProvider = "acessTestData")
	public void loginTest(String UserName, String Password) {
		amazonLP.login(UserName, Password);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
