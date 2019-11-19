package com.qa.amazonTest;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.amazonPages.AmazonHomePage;
import com.amazonPages.AmazonLoginPage;
import com.amazonPages.AmazonPLPage;
import com.amazonTestBase.AmazonBase;
import com.amazonUtil.AmazonUtility;

public class AmazonTestHomePage extends AmazonBase {

	public AmazonTestHomePage() {
		super();
	}

	AmazonHomePage amazonHP;
	AmazonLoginPage amazonLP;
	AmazonPLPage amazonPLP;
	AmazonUtility amazonUtil;

	@BeforeMethod
	public void setUp() throws InterruptedException, IOException {
		initialization();
		amazonHP = new AmazonHomePage();
		amazonLP = new AmazonLoginPage();
		amazonPLP = new AmazonPLPage();
		amazonUtil = new AmazonUtility();
	}

	@Test(priority = 1)
	public void cartPage() throws InterruptedException {
		amazonHP.cartPage();
		
	}

	/*
	 * @Test(priority = 2) public void homePageTitleTest() {
	 * amazonHP.homePageTitle();
	 * 
	 * amazonHP.signInLink(); amazonLP.loginPageTitle();
	 * 
	 * amazonHP.keywordSearch(); amazonPLP.searchResultText(); amazonPLP.sortBy();
	 * amazonPLP.selectDevice(); }
	 */

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
