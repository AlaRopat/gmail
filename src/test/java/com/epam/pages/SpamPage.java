package com.epam.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.object.User;

public class SpamPage extends AbstractPage {
	private final String BASE_URL = "https://mail.google.com/mail/spam";
	@FindBy(xpath = "//tr[@class='zA zE']")
	private WebElement unreadLetter;
	@FindBy(xpath = "//div[@class='xS']")
	private List<WebElement> letters;

	public SpamPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {

	}

	
	public int getNumberofLetter() {
		(new WebDriverWait(driver, 35)).until(ExpectedConditions.visibilityOf(unreadLetter));
		return letters.size();
		
	}

	
}
