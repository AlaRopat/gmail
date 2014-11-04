package com.epam.steps;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.object.Email;
import com.epam.object.User;
import com.epam.pages.EmailPage;
import com.epam.pages.FiltersPage;
import com.epam.pages.ForwardingPage;
import com.epam.pages.LetterPage;
import com.epam.pages.LoginPage;
import com.epam.pages.MainPage;
import com.epam.pages.SettingsPage;
import com.epam.pages.SpamPage;
import com.epam.pages.ThemesPage;
import com.epam.pages.TrashPage;

public class Step {
	private WebDriver driver;
	private final Logger logger = Logger.getLogger(Step.class);

	public void initBrowser() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		logger.info("Browser started");
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
		mainPage.clickOnButtonWrite();
		emailPage.fillAddress(email, user);
		emailPage.fillsubject(email, length);
		emailPage.writeTextOfMessage(email, length);
		emailPage.clickOnSendMessage();
		emailPage.waitMessage();
		

	}

	public void sendLetterWithAttach(User user, int length, int size) {
		Email email = new Email();
		MainPage mainPage = new MainPage(driver);
		EmailPage emailPage = new EmailPage(driver);
		mainPage.clickOnButtonWrite();
		emailPage.fillAddress(email, user);
		emailPage.fillsubject(email, length);
		emailPage.writeTextOfMessage(email, length);
		try {
			emailPage.attachFile(size);
		} catch (AWTException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		emailPage.waitLoadedFile();
		emailPage.clickOnSendMessage();
		emailPage.waitMessage();
		

	}

	public void markLetterFromUser1AsSpam() {
		MainPage mainPage = new MainPage(driver);
		LetterPage letterPage = new LetterPage(driver);
		mainPage.waitNewLetter();
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

		mainPage.clickButtonSettings();
		mainPage.clickMenuitemSettings();
		

	}

	public void deleteLetterInInbox() {
		MainPage mainPage = new MainPage(driver);
		mainPage.deleteLetter();

	}

	public void deleteLetterInTrash() {
		TrashPage trashPage = new TrashPage(driver);
		trashPage.deleteLetter();
	}

	public void setForwardToUser(User user) {
		ForwardingPage forwardingPage = new ForwardingPage(driver);
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.chooseForwardingTab();
		forwardingPage.addForwardingAddress(user);
		

	}

	public void confirmForwardFromUser() {
		MainPage mainPage = new MainPage(driver);
		LetterPage letterPage = new LetterPage(driver);
		mainPage.openLetter();
		letterPage.goToLink();
		

	}

	public boolean isLoggedIn(User user) {
		MainPage mainPage = new MainPage(driver);
		return user.getUsername().equalsIgnoreCase(mainPage.getUsername());
	}

	public void createNewFilter(User user) {
		SettingsPage settingsPage = new SettingsPage(driver);
		FiltersPage filtersPage = new FiltersPage(driver);
		settingsPage.chooseFiltersTab();
		filtersPage.createNewFilter(user);
		

	}

	public void goToFolderTrash() {
		MainPage mainPage = new MainPage(driver);
		mainPage.goToTrash();
		TrashPage trashPage = new TrashPage(driver);
		trashPage.waitUnreadLetter();
		

	}

	public boolean isLetterFromUser1WithAttachInTrashAndMarkAsImportant(
			User user) {
		TrashPage trashPage = new TrashPage(driver);
		return (("Attachment").equalsIgnoreCase(trashPage.getAttachValue())
				& user.getUsername().equalsIgnoreCase(trashPage.getEmail())
				& trashPage.isLetterInTrash() & ("Important because it matched one of your importance filters.")
					.equalsIgnoreCase(trashPage.getLabelImportantValue()));

	}

	public void goToFolderInbox() {
		MainPage mainPage = new MainPage(driver);
		mainPage.goToInbox();
		mainPage.waitNewLetter();
		
	}

	public void configureForwardingCopyOfIncomingMail() {
		ForwardingPage forwardingPage = new ForwardingPage(driver);
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.chooseForwardingTab();
		forwardingPage.chooseRadiobuttonForwardCopy();
		forwardingPage.saveChange();
		

	}

	public void removeUserFromForward() {
		ForwardingPage forwardingPage = new ForwardingPage(driver);
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.chooseForwardingTab();
		forwardingPage.removeUser();

	}

	public void deleteFilter() {
		FiltersPage filtersPage = new FiltersPage(driver);
		filtersPage.deleteFilter();
	}

	public boolean isLetterFromUser1WithoutAttachInInboxAndNotMarkAsImportant(
			User user) {
		MainPage mainPage = new MainPage(driver);

		return (user.getUsername().equalsIgnoreCase(mainPage.getEmail())
				& mainPage.isLetterInInbox()
				& ("Not important").equalsIgnoreCase(mainPage
						.getLabelImportantValue()) & mainPage
					.isLetterWithoutAttach());

	}

	public void waitNewLetterInInbox() {
		MainPage mainPage = new MainPage(driver);
		mainPage.waitNewLetter();
	}

	public boolean isLetterFromUser1WithoutAttachInInbox(User user) {
		MainPage mainPage = new MainPage(driver);
		return (user.getUsername().equalsIgnoreCase(mainPage.getEmail())
				& mainPage.isLetterInInbox() & mainPage.isLetterWithoutAttach());

	}

	public void sendLetterWithEmoticon(User user, int length) {
		EmailPage emailPage = new EmailPage(driver);
		Email email = new Email();
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnButtonWrite();
		emailPage.fillAddress(email, user);
		emailPage.fillsubject(email, length);
		emailPage.writeTextOfMessage(email, length);
		emailPage.insertEmoticon();
		emailPage.clickOnSendMessage();
		emailPage.waitMessage();
	}
	public void changeTheme(){
		SettingsPage settingsPage=new SettingsPage(driver);
		settingsPage.chooseThemesTab();
		ThemesPage themesPage=new ThemesPage(driver);
		themesPage.chooseThemeBeach();
		themesPage.waitMessage();
	}
	public boolean themeWasChanged(){
		ThemesPage themesPage=new ThemesPage(driver);
		return themesPage.isImagePresent();		
	}
	public boolean areEmoticonsAtTheMailTextArea(){
		MainPage mainPage = new MainPage(driver);
		LetterPage letterPage=new LetterPage(driver);		
		mainPage.openLetter();		
		return letterPage.areEmoticonsAtTheMailTextarea();
		
	}
}
