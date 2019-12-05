package com.qa.amazonTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazonPages.AmazonCartPage;
import com.amazonPages.AmazonHomePage;
import com.amazonPages.AmazonPDPage;
import com.amazonPages.AmazonPLPage;
import com.amazonTestBase.AmazonBase;

public class AmazonTestCartPage extends AmazonBase {

	AmazonHomePage amazonHP;
	AmazonPDPage amazonPDP;
	AmazonPLPage amazonPLP;
	AmazonCartPage AmazonCart;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		amazonHP = new AmazonHomePage();
		amazonPLP = new AmazonPLPage();
		amazonPDP = new AmazonPDPage();
		amazonPLP = new AmazonPLPage();
		AmazonCart = new AmazonCartPage();
		amazonHP.keywordSearch();
		amazonPLP.sortBy();
		amazonPLP.selectDevice();
		amazonPDP.pdpAddToCart();
	}

	@Test
	public void testCartPageTitle() {
		AmazonCart.cartPageTitle();
		AmazonCart.cartHeaderText();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
