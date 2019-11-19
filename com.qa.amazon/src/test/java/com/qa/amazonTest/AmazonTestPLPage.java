package com.qa.amazonTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.amazonPages.AmazonHomePage;
import com.amazonPages.AmazonPLPage;
import com.amazonTestBase.AmazonBase;

public class AmazonTestPLPage extends AmazonBase {

	AmazonPLPage amazonPLP;
	AmazonHomePage amazonHP;
	
	public AmazonTestPLPage() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		amazonPLP = new AmazonPLPage();
		amazonHP = new AmazonHomePage();
		amazonHP.keywordSearch();
	}

	@Test(priority = 1)
	public void amazonPLPTitleTest() {
		amazonPLP.searchResultText();
		amazonPLP.sortBy();
	}

	@Test(priority = 2)
	public void amazonPLPTest() {
		amazonPLP.sortBy();
		amazonPLP.selectDevice();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
