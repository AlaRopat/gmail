package com.epam.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.object.User;
import com.epam.steps.Step;

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
	@FindBy(xpath="//td[@class='qX r5']/input")
	private WebElement checkboxSelect;
	@FindBy(xpath="//button[text()='Delete']")
	private WebElement buttonDelete;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement buttonOk;
	private final Logger logger = Logger.getLogger(FiltersPage.class);
	public FiltersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void createNewFilter(User user) {
		linkCreateNewFilter.click();
		inputFrom.sendKeys(user.getUsername());
		checkboxHasAttachment.click();
		linkCreateFilterWithThisSearch.click();		
		checkboxDeleteIt.click();
		checkboxAlwaysMarkItAsImportant.click();
		buttonCreateFilter.click();
		logger.info("Created a new filter");
	}
	public void deleteFilter(){
		checkboxSelect.click();
		buttonDelete.click();
		buttonOk.click();
		
	}

	@Override
	public void openPage() {

	}

}
