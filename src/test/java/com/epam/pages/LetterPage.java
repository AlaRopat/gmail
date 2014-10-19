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
	@FindBy(xpath = "//div[@class='a3s']/child::a[position()=4]")
	private WebElement linrBelowToConfirmTheRequest;

	public LetterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {

	}

	public void markAsSpam() {
		(new WebDriverWait(driver, 5)).until(ExpectedConditions
				.visibilityOf(buttonMore));
		buttonMore.click();
		(new WebDriverWait(driver, 5)).until(ExpectedConditions
				.visibilityOf(menu));
		buttonReportSpam.click();
	}

	public void goToLink() {
		linrBelowToConfirmTheRequest.click();
		String windowHandel = driver.getWindowHandle();
//		(new WebDriverWait(driver, 5)).until(ExpectedConditions
//				.visibilityOfElementLocated(By
//						.xpath("//td[text()='Confirmation Success!']")));
		driver.switchTo().window(windowHandel);
		
		driver.close();

	}

}
