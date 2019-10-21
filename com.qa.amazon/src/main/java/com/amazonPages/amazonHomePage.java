package com.amazonPages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.amazonTestBase.amazonTestBase;
import com.amazonUtil.ReadNWriteExcel;
import com.amazonUtil.amazonUtilities;

public class amazonHomePage extends amazonTestBase {

	@FindBy(id = "nav-cart")
	WebElement cart;

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchTextBox;

	@FindBy(xpath = "(//div[@class='a-section aok-relative s-image-fixed-height']/img)[1]")
	WebElement appleProduct;

	@FindBy(id = "add-to-cart-button")
	WebElement addToCartBtn;

	@FindBy(id = "nav-link-accountList")
	WebElement navLink;

	@FindBy(xpath = "//div[@id='nav-flyout-ya-signin']/child::a")
	WebElement signInlink;

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchTextbox;

	public amazonHomePage() {
		PageFactory.initElements(driver, this);
	}

	public void homePageTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		Assert.assertTrue(cart.isDisplayed());
	}

	public void searchProduct() {
		searchTextBox.sendKeys("iphone");
		searchTextBox.sendKeys(Keys.ENTER);
		appleProduct.click();
	}

	public void addPoduct() {
		ArrayList<String> window = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(window.get(1));
		Assert.assertTrue(addToCartBtn.isDisplayed());
		addToCartBtn.click();
	}

	public amazonLoginPage singin() {
		wait.until(ExpectedConditions.visibilityOfAllElements(navLink));
		navLink.click();
		signInlink.click();
		System.out.println("Successfully logged into the site");
		return new amazonLoginPage();
	}

	public void addProduct() {
		searchTextbox.sendKeys("Smartphones");
		searchTextbox.sendKeys(Keys.ENTER);
	}

	public void getTestData() throws IOException {
		amazonUtilities.readExcel();
	}
}
