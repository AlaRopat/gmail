package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	@FindBy(xpath = "descendant::table[@class='cf ntxFbe'][34]")
	private WebElement radiobuttonForwardCopy;
	@FindBy(xpath = "//span[@class='e']")
	private WebElement linkCreateFilter;

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

	public void creatFilter() {
		linkCreateFilter.click();
	}

	@Override
	public void openPage() {

	}

}
