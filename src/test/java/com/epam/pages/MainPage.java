package com.epam.pages;

import java.util.List;

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
	@FindBy(xpath = "//div[@class='UI']//tr[@class='zA zE']")
	private WebElement unreadLetter;
	@FindBy(xpath = "//input[@name='q']")
	private WebElement inputFind;
	@FindBy(xpath = "//button[@class='gbqfb']")
	private WebElement buttonFind;
	@FindBy(xpath = "//div[@class='T-I J-J5-Ji ash T-I-ax7 L3']")
	private WebElement buttonSetting;
	@FindBy(xpath = "//div[@class='J-N aMS']")
	private WebElement menuitemSettings;
	@FindBy(xpath = "//div[@class='oZ-jc T-Jo J-J5-Ji T-Jo-Jp']")
	private WebElement checkbox;
	@FindBy(xpath = "//div[@class='T-I J-J5-Ji nX T-I-ax7 T-I-Js-Gs  ar7']")
	private WebElement buttonDelete;
	@FindBy(xpath = "//a[@class='gb_A gb_8 gb_f gb_2']")
	private WebElement username;
	@FindBy(xpath = "//div[@class='UI']//div[@class='pG']")
	private WebElement importantLabel;
	@FindBy(xpath = "//img[@class='yE']")
	private WebElement attachmentLabel;
	@FindBy(xpath = "//div[@class='UI']//div[@class='yW']//span[@class='zF']")
	private WebElement labelEmail;
	@FindBy(xpath = "//div[@class='UI']//tr[@class='zA zE']")
	private List<WebElement> unreadLetters;
	@FindBy(xpath = "//span[@class='T-Jo J-J5-Ji T-Jo-auq T-Jo-Jp' and @role='checkbox']")
	private WebElement checkboxSelect;
	@FindBy(xpath = "//a[@href='https://mail.google.com/mail/#inbox']")
	private WebElement linkInbox;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {

		driver.navigate().to(BASE_URL);
	}

	public void clickOnButtonWrite() {
		buttonWrite.click();
	}

	public void openLetter() {		
		unreadLetter.click();
	}

	public void goToSpam() {
		inputFind.sendKeys("in:spam");
		buttonFind.click();
	}

	public void clickButtonSettings() {
		buttonSetting.click();
	}

	public void clickMenuitemSettings() {
		menuitemSettings.click();
	}

	public void deleteLetter() {
		checkboxSelect.click();
		buttonDelete.click();
	}

	public String getUsername() {

		return username.getText();
	}

	public void goToTrash() {
		inputFind.sendKeys("in:trash");
		buttonFind.click();

	}

	public void goToInbox() {
		linkInbox.click();

	}

	public String getLabelImportantValue() {
		return importantLabel.getAttribute("aria-label");

	}

	public String getAttachValue() {
		return attachmentLabel.getAttribute("alt");

	}

	public String getEmail() {
		return labelEmail.getAttribute("email");

	}

	public boolean isLetterInInbox() {
		return unreadLetters.size() > 0;
	}

	public boolean isLetterWithoutAttach() {
		return driver.findElements(By.xpath("//img[@class='yE']")).size() == 0;

	}

	public void waitNewLetter() {
		(new WebDriverWait(driver, 75)).until(ExpectedConditions
				.visibilityOf(unreadLetter));
	}
}
