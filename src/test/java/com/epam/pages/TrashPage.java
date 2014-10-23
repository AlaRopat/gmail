package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrashPage extends AbstractPage {
	@FindBy(xpath = "//div[@class='ae4 UI UJ']//div[@class='pG']")
	private WebElement importantLabel;
	@FindBy(xpath = "//img[@class='yE']")
	private WebElement attachmentLabel;

	public TrashPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {

	}

	public String getUsername() {
		return driver.findElement(By.xpath("//span[@class='zF']"))
				.getAttribute("email");
	}

	public String getLabelImportantValue() {
		return importantLabel.getAttribute("aria-label");

	}

	public String getAttachValue() {
		return attachmentLabel.getAttribute("alt");

	}
}
