package com.omrbranch.hooks;

import java.io.IOException;

import com.omrbranch.utility.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {

	@Before
	public void beforeScenario() throws IOException {

		// Browser Launch
		browserLaunch(getPropertyFileValue("browser"));

		// Maximize Window
		maximizeWindow();
		
		// Enter Application URL
		enterApplicationUrl(getPropertyFileValue("url"));


		// Implicit Wait
		implicitWait();
	}

	@After
	public void afterScenario() {

		// Close Browser
		closeAllWindows();
	}

	@BeforeStep
	public void beforeEachStep(Scenario scenario) {
		scenario.attach(screenshot(), "image/png", "Before Step Screenshot");
	}

	@AfterStep
	public void afterEachStep(Scenario scenario) {
		scenario.attach(screenshot(), "image/png", "After Step Screenshot");
	}

}

