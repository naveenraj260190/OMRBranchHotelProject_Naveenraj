package com.omrbranch.stepdefinition;

import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TC006_CancelBookingStep {

	PageObjectManager pom = new PageObjectManager();

	@When("User should Cancel the new order ID")
	public void userShouldCancelTheNewOrderID() {

		pom.getMyBookingPage().clickBtnCancel();
		pom.getMyBookingPage().acceptAlert();

	}

	@Then("User should verify after cancel booking success message {string}")
	public void userShouldVerifyAfterCancelBookingSuccessMessage(String expectedCancelMsg) {

		Assert.assertTrue("Validate Cancel Msg",
				expectedCancelMsg.equalsIgnoreCase(pom.getMyBookingPage().getMsgBookingCancelledSuccess().getText()));
	}

}
