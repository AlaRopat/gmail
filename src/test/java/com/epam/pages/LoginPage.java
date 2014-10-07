package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.object.User;

public class LoginPage extends AbstractPage {

	private final String BASE_URL = "http://www.gmail.com";
	@FindBy(id = "Email")
	private WebElement inputLogin;
	@FindBy(id = "Passwd")
	private WebElement inputPassword;
	@FindBy(id = "signIn")
	private WebElement buttonSubmit;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);

	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);

	}

	public void login(User user) {
				inputLogin.sendKeys(user.getUsername());		
		inputPassword.sendKeys(user.getPassword());
		buttonSubmit.click();

	}

}
