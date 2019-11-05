package com.amazonPages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.amazonTestBase.AmazonBase;

public class AmazonLoginPage extends AmazonBase {

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

	public AmazonLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void loginPageTitle() {
		String LoginPageTitle = driver.getTitle();
		Assert.assertEquals(LoginPageTitle, "Amazon Sign In");
	}

	public AmazonHomePage login(String UserName, String Password) {
		//navLink.click();
		wait.until(ExpectedConditions.visibilityOf(emailId));
		emailId.sendKeys(UserName);
		continueBtn.click();
		password.sendKeys(Password);
		signInBtn.click();
		
		WebElement captchaImage = driver.findElement(By.id("image-captcha-section"));
						
		if(captchaImage.isDisplayed()) {
			System.out.println("Login Successfull");
		} else
			System.out.println("Login not successfull");		
		
		return new AmazonHomePage();
	}

}
