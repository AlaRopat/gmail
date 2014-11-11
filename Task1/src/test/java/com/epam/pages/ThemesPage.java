package com.epam.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThemesPage extends AbstractPage {
	@FindBy(xpath = "//span[text()='Beach']")
	private WebElement themeBeach;
	@FindBy(xpath = "//div[@class='vh']")
	private WebElement message;
	@FindBy(xpath = "//img[@class='ao0']")
	private List<WebElement> images;
	private final Logger logger = Logger.getLogger(ThemesPage.class);

	public ThemesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void chooseThemeBeach() {
		themeBeach.click();
		logger.info("Theme was changed");
	}

	public void waitMessage() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.visibilityOf(message));
	}

	public boolean isImagePresent() {
		return images.size() > 0;

	}

	@Override
	public void openPage() {

	}

}
