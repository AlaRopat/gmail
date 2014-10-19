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
	@FindBy(xpath = "//input[@value=1 and @name='sx_em']")
	private WebElement radiobuttonForwardCopy;
	@FindBy(xpath = "//span[@class='e']")
	private WebElement linkCreateFilter;
	@FindBy(xpath = "//input[@class='ZH nr aQa']")
	private WebElement inputFrom;
	@FindBy(xpath = "//label[text()='Has attachment']/../input")
	private WebElement checkboxHasAttachment;
	@FindBy(xpath = "//div[@class='acM']")
	private WebElement linkCreateFilterWithThisSearch;
	@FindBy(xpath = "//label[text()='Delete it']/../input")
	private WebElement checkboxDeleteIt;
	@FindBy(xpath = "//label[text()='Always mark it as important']/../input")
	private WebElement checkboxAlwaysMarkItAsImportant;
	@FindBy(xpath = "//div[@class='T-I J-J5-Ji Zx acL T-I-atl L3']")
	private WebElement buttonCreateFilter;
	@FindBy(xpath = "//button[@class='J-at1-auR J-at1-atl']")
	private WebElement buttonSave;

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

	public void creatFilter(User user) {
		linkCreateFilter.click();
		inputFrom.sendKeys(user.getUsername());
		checkboxHasAttachment.click();		
		linkCreateFilterWithThisSearch.click();
		buttonSave.click();
		checkboxDeleteIt.click();
		checkboxAlwaysMarkItAsImportant.click();
		buttonCreateFilter.click();
	}

	@Override
	public void openPage() {

	}

}
