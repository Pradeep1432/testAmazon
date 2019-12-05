package com.amazonPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazonTestBase.AmazonBase;

public class AmazonCartPage extends AmazonBase {

	@FindBy(xpath = "//div[@id='huc-v2-order-row-messages']//following-sibling::h1")
	WebElement cartPageHeader;
	
	@FindBy(id="hlb-ptc-btn")
	WebElement ProceedToBuyBtn;

	public AmazonCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void cartPageTitle() {
		String cartPageTitle = driver.getTitle();
		Assert.assertEquals(cartPageTitle, "Amazon.in Shopping Cart");
	}
	
	public void cartHeaderText() {
		String cartHeaderText = cartPageHeader.getText();
		System.out.println(cartHeaderText);
		
	}

}
