package com.epam.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.object.User;
import com.epam.steps.Step;

public class Spam {
	private Step steps;
	private User user1 = User.USER1;
	private User user2 = User.USER2;
	private User user3 = User.USER3;


	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Step();
		steps.initBrowser();

	}

	@Test
	public void user1SendMessageToUser2() {
		steps.loginGmail(user1);
		steps.sendLetter(user2, 25, "one");
		steps.closeDriver();
		steps.initBrowser();
		steps.loginGmail(user2);
		steps.markLetterFromUser1AsSpam();
		steps.closeDriver();
		steps.initBrowser();
		steps.loginGmail(user1);
		steps.sendLetter(user2, 25, "two");
		steps.closeDriver();
		steps.initBrowser();
		steps.loginGmail(user2);
		steps.goToFolderSpam();
		Assert.assertTrue(steps.letterInSpam());
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}
