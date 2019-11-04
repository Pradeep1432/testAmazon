package com.amazonPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazonTestBase.amazonBase;

public class amazonLoginPage extends amazonBase {

	@FindBy(id = "nav-link-accountList")
	WebElement navLink;

	@FindBy(id = "ap_email")
	WebElement emailId;

	@FindBy(id = "continue")
	WebElement continueBtn;

	@FindBy(id = "ap_password")
	WebElement password;

	@FindBy(id = "signInSubmit")
	WebElement signInBtn;

	public amazonLoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void login(String UserName, String Password) {
		navLink.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		emailId.sendKeys(UserName);
		continueBtn.click();
		password.sendKeys(Password);
		signInBtn.click();
	}

}
