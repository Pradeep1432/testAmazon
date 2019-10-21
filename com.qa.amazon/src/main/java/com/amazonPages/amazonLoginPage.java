package com.amazonPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazonTestBase.amazonTestBase;

public class amazonLoginPage extends amazonTestBase {

	@FindBy(id = "ap_email")
	WebElement appEmail;

	@FindBy(id = "continue")
	WebElement continueBtn;

	@FindBy(id = "ap_password")
	WebElement appPassword;

	@FindBy(id = "signInSubmit")
	WebElement signInBtn;

	public amazonLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public amazonHomePage login(String userName, String Password) {
		appEmail.sendKeys(userName);
		continueBtn.click();
		appPassword.sendKeys(Password);
		signInBtn.click();
		
		return new amazonHomePage();
	}

}
