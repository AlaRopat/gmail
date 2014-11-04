package com.epam.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.object.Email;
import com.epam.object.User;
import com.epam.utils.Utils;

public class EmailPage extends AbstractPage {
	@FindBy(xpath = "//textarea[@class='vO']")
	private WebElement inputAdress;
	@FindBy(xpath = "//input[@class='aoT']")
	private WebElement inputSubject;
	@FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
	private WebElement inputText;
	@FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO T-I-atl L3']")
	private WebElement buttonSend;
	@FindBy(xpath = "//div[@command='Files']")
	private WebElement attachFile;
	@FindBy(xpath = "//div[@command='+emoticon']")
	private WebElement buttonInsertEmoticon;
	@FindBy(xpath = "//div[@goomoji='32B']")
	private WebElement emoticon;
	@FindBy(xpath = "//div[@class='vh']")
	private WebElement message;
	@FindBy(xpath = "//div[text()='Insert']")
	private WebElement buttonInsert;
	@FindBy(xpath = "//span[@class='dN']")
	private WebElement warningMessage;

	public EmailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);

	}

	public void fillAddress(Email email, User user) {
		email.setAdress(user.getUsername());
		inputAdress.sendKeys(email.getAdress());
	}

	public void fillsubject(Email email, int length) {
		email.setSubject(Utils.getRandomString(length));
		inputSubject.sendKeys(email.getSubject());
	}

	public void writeTextOfMessage(Email email, int length) {
		email.setMessage(Utils.getRandomString(length));
		inputText.sendKeys(email.getMessage());

	}

	public void clickOnSendMessage() {
		buttonSend.click();

	}

	public void attachFile(int size) throws AWTException, IOException {
		File file = Utils.getFile(size);
		attachFile.click();
		StringSelection fp = new StringSelection(file.getAbsolutePath());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fp, null);
		;
		Robot robot = new Robot();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);
		file.delete();
	}

	public void insertEmoticon() {
		buttonInsertEmoticon.click();
		(new WebDriverWait(driver, 5)).until(ExpectedConditions
				.visibilityOf(emoticon));

		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_SHIFT);
			emoticon.isSelected();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			emoticon.click();
			buttonInsert.click();
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	public void waitMessage() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.visibilityOf(message));
	}

	public void waitLoadedFile() {
		(new WebDriverWait(driver, 90)).until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='dQ']")));
	}

	public String getWarningMessage() {
		return warningMessage.getText();
	}

	@Override
	public void openPage() {

	}

}
