package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage extends AbstractPage {
	@FindBy(xpath = "//a[text()='Forwarding and POP/IMAP']")
	private WebElement linkForwarding;

	public SettingsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {

	}

	public void clickLinkForwarding() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(linkForwarding));
		linkForwarding.click();
	}

}
