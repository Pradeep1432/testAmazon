package com.amazonPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazonTestBase.amazonBase;

public class amazonHomePage extends amazonBase {
	
	@FindBy(id="nav-link-accountList")
	WebElement navLink;
	
	@FindBy(id="nav-logo")
	WebElement logo;
	
	public amazonHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void homePageTitle() {
		String hpTitle = driver.getTitle();
		Assert.assertEquals(hpTitle, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		System.out.println("homepage titls pass");
	}
	
	public void signInLink() {
		navLink.click();
		System.out.println("clicked on nav link");
	}

}
