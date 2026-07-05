package com.omrbranch.stepdefinition;

import org.junit.Assert;

import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC001_LoginStep {

	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the OMR Branch hotel page")
	public void userIsOnTheOMRBranchHotelPage() {

	}

	@When("User enters {string} and {string}")
	public void userEntersAnd(String username, String password) {
		pom.getLoginPage().login(username, password);
		pom.getLoginPage().clickLoginBtn();

	}

	@Then("User should verify success message after login {string}")
	public void userShouldVerifySuccessMessageAfterLogin(String expectedLoginWelcomeMessage)
			throws InterruptedException {
		String ActWelcomeMessage = pom.getExploreHotelPage().getWelcomeMsg();
		Assert.assertEquals("Verify after success login message", expectedLoginWelcomeMessage, ActWelcomeMessage);
		Thread.sleep(2000);

	}

	@When("User enters {string} and {string} with enter key")
	public void userEntersAndWithEnterKey(String username, String password) {
		pom.getLoginPage().loginEnterKey(username, password);

	}

	@Then("User should verify error message after login {string}")
	public void userShouldVerifyErrorMessageAfterLogin(String expectedLoginFailureMessage) {
		String LoginErrorMsg = pom.getLoginPage().getLoginErrorMessageText();
		boolean actualLoginFailureMessage = LoginErrorMsg.contains(expectedLoginFailureMessage);
		Assert.assertTrue("Verify after login with error message", actualLoginFailureMessage);

	}

}
