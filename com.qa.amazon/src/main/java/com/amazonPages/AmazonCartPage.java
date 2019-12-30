package com.amazonPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.amazonTestBase.AmazonBase;

public class AmazonCartPage extends AmazonBase {

	@FindBy(xpath = "//div[@id='huc-v2-order-row-messages']//following-sibling::h1")
	WebElement cartPageHeader;
	
	@FindBy(id="hlb-ptc-btn")
	WebElement ProceedToBuyBtn;
	
	@FindBy(id="hlb-view-cart-announce")
	WebElement cartBtn;
	
	@FindBy(xpath="(//div[@class='a-column a-span2 a-text-right a-span-last']//span)[1]")
	WebElement cartPrice;

	public AmazonCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void cartPageTitle() {
		String cartPageTitle = driver.getTitle();
		Assert.assertEquals(cartPageTitle, "Amazon.in Shopping Cart");
	}
	
	public void cartPageElements() {
		String cartHeaderText = cartPageHeader.getText();
		System.out.println(cartHeaderText);
		Assert.assertTrue(cartBtn.isDisplayed());
		cartBtn.click();
		wait.until(ExpectedConditions.visibilityOf(cartPrice));
		System.out.println(cartPrice.getText());
		
	}

}
