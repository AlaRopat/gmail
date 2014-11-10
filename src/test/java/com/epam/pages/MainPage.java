package com.epam.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.steps.Step;

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
	@FindBy(xpath = "//td[@class='apU xY']")
	private WebElement labelStar;
	@FindBy(xpath = "//a[@href='https://mail.google.com/mail/#starred']")
	private WebElement linkStarred;
	@FindBy(xpath = "//div[@class='ae4 UI UJ']//tr[@class='zA zE']")
	private List<WebElement> markedLetters;
	private final Logger logger = Logger.getLogger(MainPage.class);

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
		logger.info("went to settings");

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
		logger.info("Went to trash");
	}

	public void goToInbox() {
		linkInbox.click();
		logger.info("Went to inbox");
	}

	public void goToStarred() {
		linkStarred.click();
		logger.info("Went to folder starred");
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
		(new WebDriverWait(driver, 120)).until(ExpectedConditions
				.visibilityOf(unreadLetter));
	}

	public void clickOnLabelStar() {
		labelStar.click();
	}

	public String getLabelStarValue() {

		return labelStar.findElement(By.xpath("//span[@aria-label='Starred']"))
				.getAttribute("title");
	}

	public boolean isLetterInFolderStarred() {
		return markedLetters.size() > 0;
	}
}
