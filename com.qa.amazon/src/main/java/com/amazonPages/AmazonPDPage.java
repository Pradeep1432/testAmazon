package com.amazonPages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazonTestBase.AmazonBase;

public class AmazonPDPage extends AmazonBase {

	@FindBy(id = "add-to-cart-button")
	WebElement addToCartBtn;

	@FindBy(id = "buy-now-button")
	WebElement buyNowBtn;

	@FindBy(xpath = "//div[@id='title_feature_div']/div/h1/span")
	WebElement productTitle;

	@FindBy(id = "averageCustomerReviews")
	WebElement reviews;

	@FindBy(id = "variation_color_name")
	WebElement colorSwatch;

	@FindBy(id = "priceblock_ourprice")
	WebElement price;

	public AmazonPDPage() {
		PageFactory.initElements(driver, this);
	}

	public void pdpPageTitle() {
		String pdpTitle = driver.getTitle();
		Assert.assertEquals(pdpTitle,
				"Remixmart™Camera Tempered Glass for iPhone 11 (Camera Tempered Glass only): Amazon.in: Electronics");
	}

	public void pdpElements() {
		buyNowBtn.isDisplayed();
		productTitle.isDisplayed();
		// reviews.isDisplayed();
		// colorSwatch.isDisplayed();
		String productPrice = price.getText();
		System.out.println(productPrice);
	}

	public AmazonCartPage pdpAddToCart() {
		addToCartBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return new AmazonCartPage();

	}

}
