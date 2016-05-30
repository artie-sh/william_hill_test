package com.art.sh.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MatchToBetPage extends BasePage {
	
	public MatchToBetPage(WebDriver driver) {
		super(driver);
	}
	WebDriverWait wait = new WebDriverWait(driver, 10);

	public MatchToBetPage navigateTo(String country1, String country2) {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format("//span[contains(text(), '%s') and contains(text(), '%s')]", country1, country2))));		
		driver.findElement(By.xpath(String.format("//span[contains(text(), '%s') and contains(text(), '%s')]", country1, country2))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format("//h2[contains(text(), '%s') and contains(text(), '%s') and contains(text(), 'All Markets')]", country1, country2))));
//make sure we're on the proper page
		Assert.assertEquals(String.format("%s v %s betting odds | Euro 2016 International Football | William Hill", country1, country2), driver.getTitle());
		return new MatchToBetPage(driver);
	}	
	
	public MatchToBetPage placeBets(String amountToBet, String countryToBet) {
//make sure country to bet is available		
		Assert.assertTrue(driver.findElement(By.xpath(String.format("//div[contains(@class, 'eventselection') and contains(text(), '%s')]", countryToBet))).isDisplayed());
//make sure the bet return block is hidden initially		
		Assert.assertFalse(isElementPresent(By.xpath(String.format("//div[contains(@class, 'slipName')]/strong[contains(text(), '%s')]", countryToBet))));
		driver.findElement(By.xpath(String.format("//div[contains(@class, 'eventselection') and contains(text(), '%s')]", countryToBet))).click();
//make sure once a country is clicked on, the bet return block shows up		
		Assert.assertTrue(isElementPresent(By.xpath(String.format("//div[contains(@class, 'slipName')]/strong[contains(text(), '%s')]", countryToBet))));
		Assert.assertTrue(isElementPresent(By.xpath(String.format("//div[contains(@class, 'slipRight') and contains(text(), '0.00')]"))));
//placing bet		
		driver.findElement(By.xpath("//div[contains(@class, 'slipStake')]/input")).sendKeys(amountToBet);		
		return new MatchToBetPage(driver);	
	}	
	
	public MatchToBetPage assertReturn(String expectedReturn) {
//asserting estimated return		
		Assert.assertTrue(driver.findElement(By.xpath(String.format(String.format("//div[contains(@class, 'slipRight') and contains(text(), '%s')]", expectedReturn)))).isEnabled());
		return new MatchToBetPage(driver);	
	}
}
