package com.art.sh.selenium_cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.art.sh.pages.*;

public class PlaceBetSteps {

	WebDriver driver = new ChromeDriver();

	
	@Given("^I am on the William Hill Sports webpage$")
	public void i_am_on_the_William_Hill_Sports_webpage() throws Throwable {
	    
		SportsPage sports = new SportsPage(driver);
	    sports.navigateTo();
	}

	@And("^I go to Euro 2016 & International page$")
	public void i_go_to_Euro_2016_International_page() throws Throwable {
		
		Euro2016Page euro = new Euro2016Page(driver);
		euro.navigateTo();
	}

	@And("^I go to \"([^\"]*)\" v \"([^\"]*)\" match bets page$")
	public void i_go_to_v_match_bets_page(String country1, String country2) throws Throwable {
	    
		MatchToBetPage match = new MatchToBetPage(driver);
		match.navigateTo(country1, country2);
	}

	@When("^I place a £\"([^\"]*)\" bet on \"([^\"]*)\"$")
	public void i_place_a_bet_on(String amountToBet, String countryToBet) throws Throwable {
		
		MatchToBetPage match = new MatchToBetPage(driver);
		match.placeBets(amountToBet, countryToBet);
	}

	@Then("^I see a £\"([^\"]*)\" estimated return$")
	public void i_see_an_estimated_return(String returnAmount) throws Throwable {
		
		MatchToBetPage match = new MatchToBetPage(driver);
		match.assertReturn(returnAmount);
	}
	

	 
	 @After
	 public void tearDown() {
	    driver.quit();
	 }
}
