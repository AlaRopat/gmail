package com.epam.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.object.User;
import com.epam.steps.Step;

public class Forward {
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
	public void loginUser3() {
		steps.loginGmail(user2);
		steps.goToSettings();
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}
