package com.amazonPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazonTestBase.AmazonBase;

public class AmazonPLPage extends AmazonBase {

	@FindBy(id = "s-result-sort-select")
	WebElement sortBy;

	@FindBy(xpath = "(//div[@class='a-section a-spacing-small a-spacing-top-small']/span)[1]")
	WebElement searchResultText;

	@FindBy(xpath = "//div[@data-asin='B07XLS522R']/div[@class='sg-col-inner']")
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

	public void selectDevice() {
		Actions act = new Actions(driver);
		act.moveToElement(device).click().build().perform();
	}

}
