package com.epam.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.object.User;
import com.epam.pages.EmailPage;
import com.epam.steps.Step;

public class GmailAutomationTest {
	private Step steps;
	private User user1 = User.USER1;
	private User user2 = User.USER2;
	private User user3 = User.USER3;
	private WebDriver driver;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Step();
		steps.initBrowser();

	}

	@Test(description = "Spam")
	public void spam() {
		steps.loginGmail(user1);
		steps.sendLetter(user2, 25);
		steps.closeDriver();
		steps.initBrowser();
		steps.loginGmail(user2);
		steps.markLetterFromUser1AsSpam();
		steps.goToFolderSpam();
		steps.closeDriver();
		steps.initBrowser();
		steps.loginGmail(user1);
		steps.sendLetter(user2, 25);
		steps.closeDriver();
		steps.initBrowser();
		steps.loginGmail(user2);
		steps.goToFolderSpam();
		Assert.assertTrue(steps.letterInSpam());
	}

	@Test(description = "Forward")
	public void forward() {
		steps.loginGmail(user2);
		steps.goToSettings();
		steps.setForwardToUser(user3);
		steps.closeDriver();
		steps.initBrowser();
		steps.loginGmail(user3);
		steps.confirmForwardFromUser();
		steps.closeDriver();
		steps.initBrowser();
		steps.loginGmail(user2);
		steps.goToSettings();
		steps.configureForwardingCopyOfIncomingMail();
		steps.goToSettings();
		steps.createNewFilter(user1);
		steps.closeDriver();
		steps.initBrowser();
		steps.loginGmail(user1);
		steps.sendLetterWithAttach(user2, 25, 1);
		steps.sendLetter(user2, 25);
		steps.closeDriver();
		steps.initBrowser();
		steps.loginGmail(user2);
		steps.waitNewLetterInInbox();
		boolean results = steps
				.isLetterFromUser1WithoutAttachInInboxAndNotMarkAsImportant(user1);
		steps.goToFolderTrash();
		steps.waitNewLetterInTrash();
		results &= steps
				.isLetterFromUser1WithAttachInTrashAndMarkAsImportant(user1);
		steps.closeDriver();
		steps.initBrowser();
		steps.loginGmail(user3);
		results &= steps.isLetterFromUser1WithoutAttachInInbox(user1);
		Assert.assertTrue(results);

	}

	@Test(description = "Change User Theme")
	public void changeUserTheme() {
		steps.loginGmail(user2);
		steps.goToSettings();
		steps.changeTheme();
		Assert.assertTrue(steps.themeWasChanged());
	}

	@Test(description = "Send letter with Emoticons")
	public void sendLetterWithAttachement() {
		steps.loginGmail(user2);
		steps.sendLetterWithEmoticon(user1, 25);
		steps.closeDriver();
		steps.initBrowser();
		steps.loginGmail(user1);
		steps.waitNewLetterInInbox();
		Assert.assertTrue(steps.areEmoticonsAtTheMailTextArea());
	}

	@Test
	public void tryToAttachFileBiggerThen25mb() {
		steps.loginGmail(user2);
		steps.tryToAttachFile(user1, 25, 25);
		Assert.assertTrue(steps.isFileBiggerThen25mb());

	}

	@Test(description = "Check star selection")
	public void checkStarSelection() {
		steps.loginGmail(user2);
		steps.sendLetter(user3, 25);
		steps.closeDriver();
		steps.initBrowser();
		steps.loginGmail(user3);
		steps.waitNewLetterInInbox();
		steps.clickOnLabelStar();
		boolean results = steps.isStarLabelSelected();
		steps.goToFolderStarred();
		results &= steps.isLetterInFolderStarred();
		Assert.assertTrue(results);
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();

	}

}
