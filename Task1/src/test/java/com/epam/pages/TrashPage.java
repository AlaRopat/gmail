package com.epam.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrashPage extends AbstractPage {
	@FindBy(xpath = "//div[@class='ae4 UI UJ']//div[@class='pG']")
	private WebElement importantLabel;
	@FindBy(xpath = "//img[@class='yE']")
	private WebElement attachmentLabel;
	@FindBy(xpath = "//div[@class='ae4 UI UJ']//div[@class='yW']//span[@class='zF']")
	private WebElement labelEmail;
	@FindBy(xpath = "//div[@class='ae4 UI UJ']//tr[@class='zA zE']")
	private List<WebElement> unreadLetters;
	@FindBy(xpath = "//div[text()='Delete forever' and @role='button']")
	private WebElement buttonDeleteForever;
	@FindBy(xpath = "//span[@class='T-Jo J-J5-Ji T-Jo-auq T-Jo-Jp' and @role='checkbox']")
	private WebElement checkboxSelect;
	@FindBy(xpath = "//div[@class='ae4 UI UJ']//tr[@class='zA zE']")
	private WebElement unreadLetter;

	public TrashPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {

	}

	public String getEmail() {
		return labelEmail.getAttribute("email");
	}

	public String getLabelImportantValue() {
		return importantLabel.getAttribute("aria-label");

	}

	public String getAttachValue() {
		return attachmentLabel.getAttribute("alt");

	}

	public boolean isLetterInTrash() {
		return unreadLetters.size() > 0;
	}

	public void deleteLetter() {
		checkboxSelect.click();
		buttonDeleteForever.click();
	}

	public void waitUnreadLetter() {
		(new WebDriverWait(driver, 70)).until(ExpectedConditions
				.visibilityOf(unreadLetter));
	}
}
