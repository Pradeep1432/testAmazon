package com.amazonPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazonTestBase.AmazonBase;

public class AmazoncartPage extends AmazonBase {

	@FindBy(xpath = "(//div[@class='a-row sc-cart-header']//h1)[1]")
	WebElement cartPageHeader;

	public AmazoncartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void cartHeaderText() {
		String cartHeaderText = cartPageHeader.getText();
		System.out.println(cartHeaderText);
		
	}

}
