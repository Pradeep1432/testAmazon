package com.amazonPageTest;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazonPages.amazonHomePage;
import com.amazonPages.amazonLoginPage;
import com.amazonTestBase.amazonTestBase;

public class amazonHomePageTest extends amazonTestBase {

	public amazonHomePageTest() {
		super();
	}

	amazonHomePage hp;
	amazonLoginPage lp;

	@BeforeMethod
	public void setUP() {
		initilization();
		hp = new amazonHomePage();
		lp = new amazonLoginPage();
	}

	@Test(priority = 1)
	public void homePageTest() throws IOException {
		hp.homePageTest();
		hp.singin();
		hp.getTestData();
	}	

	@Test(priority = 2)
	public void loginInToApp() {
		hp.homePageTest();
		hp.singin();
		lp.login("pradeeppatil.dsi@gmail.com", "Pradeep@1986");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
