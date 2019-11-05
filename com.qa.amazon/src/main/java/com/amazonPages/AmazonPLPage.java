package com.amazonPages;

import org.openqa.selenium.WebElement;
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
	
	@FindBy(xpath= "//div[@class='s-result-list s-search-results sg-row']/div[@data-cel-widget='search_result_1']")
	WebElement device2;

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
		wait.until(ExpectedConditions.visibilityOf(device2));
		device2.click();
	}

}
