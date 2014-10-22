package com.epam.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.object.User;
import com.epam.steps.Step;

public class GmailAutomationTest {
	private Step steps;
	private User user1 = User.USER1;
	private User user2 = User.USER2;
	private User user3 = User.USER3;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Step();
		steps.initBrowser();

	}

	/*@Test
	public void markLetterFromUser1AsSpamGoToFolderSpam() {
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

	@Test()
	public void loginUser3() {

		steps.loginGmail(user2);
		steps.goToSettings();
		steps.setForwardToUser(user3);
		steps.closeDriver();
		steps.initBrowser();
		steps.loginGmail(user3);
		steps.confirmForwardFromUser();
		Assert.assertTrue(steps.isUserLogin(user3));

	}*/

	@Test

	public void letterFromUser1WithAttachIsInTrashAndMarkAsImportant() {
		steps.loginGmail(user2);
		steps.goToSettings();
		steps.createNewFilter(user1);
		steps.closeDriver();
		steps.initBrowser();
		steps.loginGmail(user1);
		steps.sendLetterWithAttach(user2, 25,1);
		steps.sendLetter(user2, 25);
		steps.closeDriver();
		steps.initBrowser();
		steps.loginGmail(user2);
		steps.goToFolderTrash();
		Assert.assertTrue(steps.isLetterFromUser(user1));
		
		

	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}
