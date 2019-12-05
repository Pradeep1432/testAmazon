package com.amazonPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.amazonTestBase.AmazonBase;
import com.amazonUtil.AmazonUtility;

public class AmazonHomePage extends AmazonBase {

	@FindBy(id = "nav-link-accountList")
	WebElement navLink;
	
	@FindBy(id="nav-orders")
	WebElement orders;
	
	@FindBy(id="nav-cart")
	WebElement cart;
	
	@FindBy(id="nav-link-prime")
	WebElement prime;

	@FindBy(id = "nav-logo")
	WebElement logo;

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchTextBox;

	public AmazonHomePage() {
		PageFactory.initElements(driver, this);
	}

	public void homePageTitle() {
		String hpTitle = driver.getTitle();
		Assert.assertEquals(hpTitle,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}

	public AmazonLoginPage signInLink() {
		wait.until(ExpectedConditions.visibilityOf(navLink));
		navLink.click();
		softAssert.assertTrue(navLink.isDisplayed());
		return new AmazonLoginPage();
	}

	public AmazonPLPage keywordSearch() {
		searchTextBox.sendKeys("iPhone");
		searchTextBox.sendKeys(Keys.ENTER);
		return new AmazonPLPage();
	}
	
	public AmazonCartPage cartPage() throws InterruptedException {
		AmazonUtility.JSClick(cart);
		Thread.sleep(5000);
		String cartTitle = driver.getTitle();
		System.out.println(cartTitle);
		
		return new AmazonCartPage();
	}
	
}
