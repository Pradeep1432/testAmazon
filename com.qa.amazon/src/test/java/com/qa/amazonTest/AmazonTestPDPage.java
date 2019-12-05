package com.qa.amazonTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazonPages.AmazonHomePage;
import com.amazonPages.AmazonPDPage;
import com.amazonPages.AmazonPLPage;
import com.amazonTestBase.AmazonBase;

public class AmazonTestPDPage extends AmazonBase {

	AmazonHomePage amazonHP;
	AmazonPDPage amazonPDP;
	AmazonPLPage amazonPLP;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		amazonHP = new AmazonHomePage();
		amazonPLP = new AmazonPLPage();
		amazonHP.keywordSearch();
		amazonPLP.sortBy();
		amazonPLP.selectDevice();		
		amazonPDP = new AmazonPDPage();
		amazonPLP = new AmazonPLPage();
	}

	@Test(priority=1)
	public void PDPageTitleTest() {
		amazonPDP.pdpPageTitle();
	}

	@Test(priority=2)
	public void PDPageElementsTest() {
		amazonPDP.pdpElements();
	}
	
	@Test(priority=3)
	public void PDPAddToCart() {
		amazonPDP.pdpAddToCart();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
