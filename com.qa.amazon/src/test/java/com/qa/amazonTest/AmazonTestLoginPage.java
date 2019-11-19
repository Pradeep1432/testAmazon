package com.qa.amazonTest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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

	@BeforeClass
	public void setUp() throws InterruptedException, IOException {
		initialization();
		amazonUtil = new AmazonUtility();
		amazonHP = new AmazonHomePage();
		amazonLP = new AmazonLoginPage();
	}

	@DataProvider
	public Object[][] getTestData() throws EncryptedDocumentException, IOException {
		Object data[][] = AmazonUtility.readTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getTestData")
	public void loginTest(String UserName, String Password) throws InterruptedException, IOException {
		amazonHP.signInLink();
		amazonLP.login(UserName, Password);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
