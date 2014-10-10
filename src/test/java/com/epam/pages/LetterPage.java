package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LetterPage extends AbstractPage {
	@FindBy(xpath = "//div[@class='J-N-Jz']//div[@act='9']")
	private WebElement buttonReportSpam;
	@FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-Js-Gs aap T-I-awG T-I-ax7 L3']")
	private WebElement buttonMore;
	@FindBy(xpath = "//div[@class='b7 J-M']")
	private WebElement menu;

	public void markAsSpam() {
		(new WebDriverWait(driver, 5)).until(ExpectedConditions
				.visibilityOf(buttonMore));
		buttonMore.click();
		(new WebDriverWait(driver, 5)).until(ExpectedConditions
				.visibilityOf(menu));
		buttonReportSpam.click();
	}

	public LetterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {

	}

}
