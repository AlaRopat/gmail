package com.epam.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
	@FindBy(xpath = "//div[@class='a3s']/a[4]")
	private WebElement linrBelowToConfirmTheRequest;
	@FindBy(xpath = "//img[@class='CToWUd']")
	private List<WebElement> emoticons;

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
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String parent = it.next();
			String newwin = it.next();
			driver.switchTo().window(newwin);
			driver.close();
			driver.switchTo().window(parent);
		}

	}

	public boolean areEmoticonsAtTheMailTextarea() {
		return emoticons.size() == 2;

	}

}
