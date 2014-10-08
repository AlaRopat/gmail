package com.epam.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.utils.Utils;

public class MainPage extends AbstractPage {
	private final String BASE_URL = "https://mail.google.com/";

	@FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
	private WebElement buttonWrite;
	@FindBy(xpath = "//td[@class='oZ-x3 xY']")
	private WebElement checkbox;
	@FindBy(xpath = "//div[@class='T-I J-J5-Ji nN T-I-ax7 T-I-Js-Gs T-I-Js-IF ar7']")
	private WebElement buttonMarkSpam;
	@FindBy(xpath = "//input[@name='q']")
	private WebElement inputSpam;
	@FindBy(xpath="//button[@class='gbqfb']")
	private WebElement buttonFind;
	

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

	public void clickCheckbox() {
		checkbox.click();
	}

	public void clickMarkSpam()  {
		buttonMarkSpam.click();
	
	}

	public void goToSpam() {
		inputSpam.sendKeys("in:spam");
		buttonFind.click();
	}

	
}
