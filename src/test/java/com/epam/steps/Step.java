package com.epam.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.object.Email;
import com.epam.object.User;
import com.epam.pages.EmailPage;
import com.epam.pages.ForwardingPage;
import com.epam.pages.LetterPage;
import com.epam.pages.LoginPage;
import com.epam.pages.MainPage;
import com.epam.pages.SettingsPage;
import com.epam.pages.SpamPage;
import com.epam.pages.TrashPage;

public class Step {
	private WebDriver driver;

	public void initBrowser() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

	}

	public void closeDriver() {
		driver.quit();
	}

	public void loginGmail(User user) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(user);

	}

	public void sendLetter(User user, int length) {
		Email email = new Email();
		MainPage mainPage = new MainPage(driver);
		EmailPage emailPage = new EmailPage(driver);
		mainPage.clickOnWriteNewMessage();
		emailPage.fillAddress(email, user);
		emailPage.fillsubject(email, length);
		emailPage.writeTextOfMessage(email, length);
		emailPage.clickOnSendMessage();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='vh']")));

	}

	public void sendLetterWithAttach(User user, int length, int size) {
		Email email = new Email();
		MainPage mainPage = new MainPage(driver);
		EmailPage emailPage = new EmailPage(driver);
		mainPage.clickOnWriteNewMessage();
		emailPage.fillAddress(email, user);
		emailPage.fillsubject(email, length);
		emailPage.writeTextOfMessage(email, length);
		emailPage.attachFile(size);
		emailPage.clickOnSendMessage();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='vh']")));

	}

	public void markLetterFromUser1AsSpam() {
		MainPage mainPage = new MainPage(driver);
		LetterPage letterPage = new LetterPage(driver);
		mainPage.openLetter();
		letterPage.markAsSpam();

	}

	public void goToFolderSpam() {
		MainPage mainPage = new MainPage(driver);
		mainPage.goToSpam();

	}

	public boolean letterInSpam() {
		SpamPage spamPage = new SpamPage(driver);
		return (spamPage.getNumberofLetter() == 2);
	}

	public void goToSettings() {
		MainPage mainPage = new MainPage(driver);
		SettingsPage settingsPage = new SettingsPage(driver);
		mainPage.clickButtonSettings();
		mainPage.clickMenuitemSettings();
		settingsPage.clickLinkForwarding();

	}

	public void deleteLetter() {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickCheckbox();
		mainPage.clickButtonDelete();
	}

	public void setForwardToUser(User user) {
		ForwardingPage forwardingPage = new ForwardingPage(driver);
		forwardingPage.addForwardingAddress(user);
	}

	public void confirmForwardFromUser() {
		MainPage mainPage = new MainPage(driver);
		LetterPage letterPage = new LetterPage(driver);
		mainPage.openLetter();
		letterPage.goToLink();

	}

	public boolean isUserLogin(User user) {
		MainPage mainPage = new MainPage(driver);
		return mainPage.getUsername().equalsIgnoreCase(user.getUsername());
	}

	public void createNewFilter(User user) {
		ForwardingPage forwardingPage = new ForwardingPage(driver);
		forwardingPage.chooseRadiobuttonForwardCopy();

		forwardingPage.creatFilter(user);
	}

	public void goToFolderTrash() {
		MainPage mainPage = new MainPage(driver);
		mainPage.goToTrash();

	}

	public boolean isLetterFromUser(User user) {
		TrashPage trashPage = new TrashPage(driver);
		return user.getUsername().equalsIgnoreCase(trashPage.getUsername());

	}

}
