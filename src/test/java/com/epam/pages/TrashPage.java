package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TrashPage extends AbstractPage {

	public TrashPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {

	}

	public String getUsername() {
		return driver.findElement(By.xpath("//span[@class='zF']"))
				.getAttribute("email");
	}
}
