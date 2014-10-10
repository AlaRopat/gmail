package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {
	private final String BASE_URL = "https://mail.google.com/";

	@FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
	private WebElement buttonWrite;
	@FindBy(xpath = "//tr[@class='zA zE']")
	private WebElement newLetter;
	@FindBy(xpath = "//input[@name='q']")
	private WebElement inputSpam;
	@FindBy(xpath = "//button[@class='gbqfb']")
	private WebElement buttonFind;
	@FindBy(xpath = "//div[@class='T-I J-J5-Ji ash T-I-ax7 L3']")
	private WebElement buttonSetting;
	@FindBy(xpath = "//div[@class='J-N aMS']")
	private WebElement menuitemSettings;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {

		driver.navigate().to(BASE_URL);
	}

	public void clickOnWriteNewMessage() {
		buttonWrite.click();
	}

	public void openLetter() {
	
		newLetter.click();
	}

	public void goToSpam() {
		inputSpam.sendKeys("in:spam");
		buttonFind.click();
	}

	public void clickButtonSettings() {
		buttonSetting.click();
	}

	public void clickMenuitemSettings() {
		menuitemSettings.click();
	}

}
