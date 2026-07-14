package com.omrbranch.stepdefinition;

import org.junit.Assert;

import com.omrbranch.pagemanager.PageObjectManager;
import com.omrbranch.utility.BaseClass;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC003_SelectHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
	public static String lastHotelName;
	static public String lastHotelPrice;

	@When("User save the last hotel name and hotel price")
	public void userSaveTheLastHotelNameAndHotelPrice() {

		lastHotelName = pom.getSelectHotelPage().LastHotelName();
		lastHotelPrice = pom.getSelectHotelPage().LastHotelPrice().replaceAll("[^0-9]", "");
		System.out.println("Last Hotel Name is " + lastHotelName);
		System.out.println("Last Hotel Price is " + lastHotelPrice);

	}

	@When("User select the last hotel and accept the alert")
	public void userSelectTheLastHotelAndAcceptTheAlert() {

		pom.getSelectHotelPage().clickIndexBtnContinueFromlastBasedOnIndex(1);
		acceptAlert();
	}

	@Then("User should verify after select success message {string}")
	public void userShouldVerifyAfterSelectSuccessMessage(String BookHotel) throws InterruptedException {
		Thread.sleep(1000);

		Assert.assertTrue("Validate Book hotel Msg", pom.getBookHotelPage().getBookedHotelName().contains(BookHotel));
	}

	@When("User save the second from last hotel name and hotel price")
	public void userSaveTheSecondFromLastHotelNameAndHotelPrice() throws InterruptedException {

		Thread.sleep(1000);
		System.out.println("Last Hotel Name is " + pom.getSelectHotelPage().SecondLastHotelName());
		System.out.println("Last Hotel Name is " + pom.getSelectHotelPage().SecondLastHotelPrice());

	}
	
	@When("User select the second hotel and dismiss the alert")
	public void userSelectTheSecondHotelAndDismissTheAlert() {

		pom.getSelectHotelPage().clickIndexBtnContinueFromFirstBasedOnIndex(2);
		DismissAlert();

	}
	

	@When("User select the second from last hotel and accept the alert")
	public void userSelectTheSecondFromLastHotelAndAcceptTheAlert() throws InterruptedException {

		Thread.sleep(1000);
		pom.getSelectHotelPage().clickIndexBtnContinueFromlastBasedOnIndex(2);
		acceptAlert();

	}

	@When("User save the second hotel name and hotel price")
	public void userSaveTheSecondHotelNameAndHotelPrice() {

		pom.getSelectHotelPage().getHotelNamesfromFirstBasedOnIndex(2);
		pom.getSelectHotelPage().getHotelPriceFromFirstBasedOnIndex(2);

	}

}
