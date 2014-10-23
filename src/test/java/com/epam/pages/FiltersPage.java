package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.object.User;

public class FiltersPage extends AbstractPage {
	@FindBy(xpath = "//span[text()='Create a new filter']")
	private WebElement linkCreateNewFilter;
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

	public FiltersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void createNewFilter(User user) {
		linkCreateNewFilter.click();
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
