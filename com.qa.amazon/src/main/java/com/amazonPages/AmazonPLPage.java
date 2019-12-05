package com.amazonPages;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.amazonTestBase.AmazonBase;

public class AmazonPLPage extends AmazonBase {

	@FindBy(id = "s-result-sort-select")
	WebElement sortBy;

	@FindBy(xpath = "(//div[@class='a-section a-spacing-small a-spacing-top-small']/span)[1]")
	WebElement searchResultText;

	@FindBy(xpath = "(//span[@data-component-type='s-product-image']//following-sibling::img)[3]")
	WebElement device;

	public AmazonPLPage() {
		PageFactory.initElements(driver, this);
	}

	public void searchResultText() {
		String text = searchResultText.getText();
		System.out.println(text);
	}

	public void sortBy() {
		Select select = new Select(sortBy);
		select.selectByValue("price-asc-rank");
	}

	public AmazonPDPage selectDevice() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(device));
		if (device.isDisplayed()) {
			System.out.println("device is displayed");
			device.click();
			Thread.sleep(9000);
			System.out.println("clicked on the device");
		} else {
			System.out.println("device is not dispalyed");
		}
		
		ArrayList<String> windows = new ArrayList<String> (driver.getWindowHandles());
		System.out.println("number of windows are " +windows );
		driver.switchTo().window(windows.get(1));
				
		return new AmazonPDPage();
		
	}

}
