package com.amazonPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazonTestBase.AmazonBase;

public class AmazonHomePage extends AmazonBase {

	@FindBy(id = "nav-link-accountList")
	WebElement navLink;

	@FindBy(id = "nav-logo")
	WebElement logo;
	
	@FindBy(id="twotabsearchtextbox")
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
		/*
		 * Actions act = new Actions(driver);
		 * act.moveToElement(navLink).click().build().perform();
		 */
		navLink.click();
		softAssert.assertTrue(navLink.isDisplayed());
		return new AmazonLoginPage();
	}
	
	public void keywordSearch() {
		searchTextBox.sendKeys("iPhone");
		searchTextBox.sendKeys(Keys.ENTER);
	}
}
