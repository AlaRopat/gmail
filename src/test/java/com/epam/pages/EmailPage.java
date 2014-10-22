package com.epam.pages;

import java.io.File;
import java.io.IOException;

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

	public void attachFile(int size) {
		File file = Utils.creatNewFile(size);
		attachFile.click();
		try {
			Runtime.getRuntime().exec(
					"D:/лекции/javatraining/Task1/src/attach.exe");
		} catch (IOException e) {

			e.printStackTrace();
		}
		(new WebDriverWait(driver, 35)).until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("//div[@class='a1 aaA aMZ aF2']")));
		
		file.delete();
	}

	@Override
	public void openPage() {

	}

}
