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
	private WebElement forwardingTab;
	@FindBy(xpath = "//a[text()='Filters']")
	private WebElement filtersTab;
	@FindBy(xpath = "//a[text()='General']")
	private WebElement generalTab;
	@FindBy(xpath = "//a[text()='Themes']")
	private WebElement themesTab;

	public SettingsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {

	}

	public void chooseForwardingTab() {
		(new WebDriverWait(driver, 20)).until(ExpectedConditions
				.elementToBeClickable(forwardingTab));
		forwardingTab.click();
	}

	public void chooseFiltersTab() {
		filtersTab.click();
	}

	public void chooseGeneralTab() {
		generalTab.click();
	}

	public void chooseThemesTab() {
		themesTab.click();
	}
}
