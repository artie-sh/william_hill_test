package com.art.sh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

//the starting page for the test
public class SportsPage extends BasePage {

	public SportsPage(WebDriver driver) {
			super(driver);
	}
	
	public SportsPage navigateTo() {
		
		driver.get("http://sports.williamhill.com/");
		//if set time zone pop up shows up, click ok button to let it go
		if (isElementPresent(By.id("yesBtn"))) {
			driver.findElement(By.id("yesBtn")).click();
			}
		//make sure we're on the proper page
		Assert.assertEquals("Online Betting from William Hill - The Home of Betting", driver.getTitle());
		return new SportsPage(driver);
	}
}
