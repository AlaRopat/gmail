package com.epam.pages;

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
	@FindBy(xpath = "//div[@class='yW']/span[@class='zF']")
	private WebElement username;

	public SpamPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {

	}

	public String getUsername() {
		(new WebDriverWait(driver, 30)).until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("//div[@class='ae4 UI UJ']")));
		return username.getAttribute("email");
	}
}
