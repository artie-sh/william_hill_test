package com.art.sh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class Euro2016Page extends BasePage {
	
	public Euro2016Page(WebDriver driver) {
		super(driver);
	}
	WebDriverWait wait = new WebDriverWait(driver, 10);

	public Euro2016Page navigateTo() {
		
		WebElement football_link = driver.findElement(By.xpath("//a[contains(@id, 'football')]"));	
		Assert.assertTrue(football_link.isDisplayed());
		football_link.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Euro 2016 & International')]")));
		driver.findElement(By.xpath("//span[contains(text(), 'Euro 2016 & International')]")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(), 'Coupons') and contains(text(), 'Euro 2016 & International')]")));
		
		return new Euro2016Page(driver);
		}
}
