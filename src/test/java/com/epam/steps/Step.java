package com.epam.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.object.Email;
import com.epam.object.User;
import com.epam.pages.EmailPage;
import com.epam.pages.LetterPage;
import com.epam.pages.LoginPage;
import com.epam.pages.MainPage;
import com.epam.pages.SpamPage;

public class Step {
	private WebDriver driver;

	public void initBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
		driver = new ChromeDriver();
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

	}

	public void markLetterFromUser1AsSpam() {
		MainPage mainPage = new MainPage(driver);
		LetterPage letterPage = new LetterPage(driver);
		(new WebDriverWait(driver, 35)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//tr[@class='zA zE']")));
		mainPage.openLetter();
		letterPage.markAsSpam();
		(new WebDriverWait(driver, 15)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='UI']")));

	}

	public void goToFolderSpam() {
		MainPage mainPage = new MainPage(driver);
		mainPage.goToSpam();
		(new WebDriverWait(driver, 35)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//tr[@class='zA zE']")));

	}

	public boolean letterInSpam() {
		SpamPage spamPage = new SpamPage(driver);
		boolean flag = false;
		if (spamPage.getNumberofLetter() == 2) {
			flag = true;
		}
		return flag;
	}

	public void goToSettings() {
		MainPage mainPage = new MainPage(driver);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(By
						.xpath("//div[@class='T-I J-J5-Ji ash T-I-ax7 L3']")));
		mainPage.clickButtonSettings();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='J-N aMS']")));
		mainPage.clickMenuitemSettings();

	}

}
