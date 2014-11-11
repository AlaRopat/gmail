package com.epam.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.object.User;

public class ForwardingPage extends AbstractPage {
	@FindBy(xpath = "//input[@act='add']")
	private WebElement AddForwardingAddress;
	@FindBy(xpath = "//input[@size='48']")
	private WebElement inputAddress;
	@FindBy(xpath = "//iframe[@class='ds']")
	private WebElement frameConfirmforwardingAddress;
	@FindBy(xpath = "//button[@name='next']")
	private WebElement buttonNext;
	@FindBy(xpath = "//button[@class='J-at1-auR']")
	private WebElement buttonOk;
	@FindBy(xpath = "//input[@value='Proceed']")
	private WebElement buttonProceed;
	@FindBy(xpath = "//input[@value=1 and @name='sx_em']")
	private WebElement radiobuttonForwardCopy;
	@FindBy(xpath = "//button[ancestor::div[@class='nH Tv1JD']][text()='Save Changes']")
	private WebElement buttonSaveChanges;
	@FindBy(xpath = "//option[@value='2']/..")
	private WebElement userForwardWindow;
	@FindBy(xpath = "//option[text()='Remove user3fortestwebdriver@gmail.com']")
	private WebElement optionRemove;
	@FindBy(xpath = "//div[@class='Kj-JD']")
	private WebElement confirmWindow;
	@FindBy(xpath = "//div[@class='Kj-JD']//button[@name='ok']")
	private WebElement buttonConfirm;

	public ForwardingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void addForwardingAddress(User user) {
		AddForwardingAddress.click();
		inputAddress.sendKeys(user.getUsername());
		buttonNext.click();
		driver.switchTo().frame(frameConfirmforwardingAddress);
		buttonProceed.click();
		driver.switchTo().parentFrame();
		buttonOk.click();
	}

	public void chooseRadiobuttonForwardCopy() {
		radiobuttonForwardCopy.click();

	}

	public void saveChange() {
		buttonSaveChanges.click();
		(new WebDriverWait(driver,5)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='nH']//div[@class='ZY']")));

	}

	public void removeUser() {
		userForwardWindow.click();		
		optionRemove.click();
		
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
		buttonConfirm.click();
	}



	@Override
	public void openPage() {

	}

}
