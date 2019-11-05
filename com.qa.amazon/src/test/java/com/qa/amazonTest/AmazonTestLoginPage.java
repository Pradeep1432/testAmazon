package com.qa.amazonTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazonPages.AmazonHomePage;
import com.amazonPages.AmazonLoginPage;
import com.amazonTestBase.AmazonBase;
import com.amazonUtil.AmazonUtility;

public class AmazonTestLoginPage extends AmazonBase {

	AmazonUtility amazonUtil;
	AmazonLoginPage amazonLP;
	AmazonHomePage amazonHP;

	String sheetName = "AmazonData";

	public AmazonTestLoginPage() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		amazonUtil = new AmazonUtility();
		amazonHP = new AmazonHomePage();
		amazonLP = new AmazonLoginPage();
	}

	@DataProvider
	public Object[][] acessTestData() throws EncryptedDocumentException, IOException {
		Object data[][] = AmazonUtility.readTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "acessTestData")
	public void loginTest(String UserName, String Password) throws InterruptedException {
		amazonHP.signInLink();
		amazonLP.login(UserName, Password);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
