package com.art.sh.selenium_cucumber;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;

//cucumber startpoint class
@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources",
//html report is saved to /target folder
		plugin = {"html:target/PlaceBetReport.html"}
		)


public class PlaceBet {

}
