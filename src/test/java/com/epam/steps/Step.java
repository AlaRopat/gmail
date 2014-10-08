package com.epam.steps;

import java.io.File;
import java.io.IOException;
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

	public void sendLetter(User user, int length, String sub) {
		Email email = new Email();
		MainPage mainPage = new MainPage(driver);
		EmailPage emailPage = new EmailPage(driver);
		mainPage.clickOnWriteNewMessage();
		emailPage.fillAddress(email, user);
		emailPage.fillsubject(email, length);
		emailPage.writeTextOfMessage(email, sub);
		emailPage.clickOnSendMessage();

	}

	public void markLetterFromUser1AsSpam() {
		MainPage mainPage = new MainPage(driver);
		(new WebDriverWait(driver, 30)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//td[@class='oZ-x3 xY']")));
		mainPage.clickCheckbox();
		(new WebDriverWait(driver, 20))
				.until(ExpectedConditions.elementToBeClickable(By
						.xpath("//div[@class='T-I J-J5-Ji nN T-I-ax7 T-I-Js-Gs T-I-Js-IF ar7']")));
		mainPage.clickMarkSpam();
		
		driver.navigate().refresh();
	}

	public void goToFolderSpam() {
		MainPage mainPage = new MainPage(driver);

		mainPage.goToSpam();

	}

	public boolean letterInSpam() {
		SpamPage spamPage = new SpamPage(driver);	
		boolean flag=false;
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions
				.textToBePresentInElementLocated(By.xpath("//span[@class='y2']"),"two"));
		if(spamPage.getNumberOfLetter()==2){
			flag=true;
		}
		return flag;
	}
}
