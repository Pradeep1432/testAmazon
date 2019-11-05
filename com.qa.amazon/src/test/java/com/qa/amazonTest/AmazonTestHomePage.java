package com.qa.amazonTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.amazonPages.AmazonHomePage;
import com.amazonPages.AmazonLoginPage;
import com.amazonPages.AmazonPLPage;
import com.amazonTestBase.AmazonBase;

public class AmazonTestHomePage extends AmazonBase{
	
	AmazonHomePage amazonHP;
	AmazonLoginPage amazonLP;
	AmazonPLPage amazonPLP;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		amazonHP = new AmazonHomePage();
		amazonLP = new AmazonLoginPage();
		amazonPLP = new AmazonPLPage();
	}
	
	@Test
	public void homePageTitleTest() {
		amazonHP.homePageTitle();
		/*
		 * amazonHP.signInLink(); amazonLP.loginPageTitle();
		 */
		amazonHP.keywordSearch();
		amazonPLP.searchResultText();
		amazonPLP.sortBy();
		amazonPLP.selectDevice();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}	

}
