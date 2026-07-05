package com.omrbranch.stepdefinition;

import org.junit.Assert;

import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC005_ChangeBookingStep {
	
	
PageObjectManager pom = new PageObjectManager();	


	@When("User navigate to My Booking page")
	public void userNavigateToMyBookingPage() {
		
		pom.getMyBookingPage().clickBtnMyBookingPage();
	
	}
	@Then("User should verify after navigate to My Booking page success message as {string}")
	public void userShouldVerifyAfterNavigateToMyBookingPageSuccessMessageAs(String myBookingsMsg) {

		Assert.assertTrue("Validate Nookings Text", pom.getMyBookingPage().getTextBooking().contains(myBookingsMsg));
		
	}
	@When("User search the Order ID")
	public  void userSearchTheOrderID() {
		
		//TC004_BookHotelStep bookHotelStep = new TC004_BookHotelStep();
		//System.out.println("Order ID IS :"+bookHotelStep.OrderID);
		//pom.getMyBookingPage().sendOrderIdInBookingsSearch(bookHotelStep.OrderID);
		
		System.out.println("Order ID IS :"+TC004_BookHotelStep.OrderID);
		pom.getMyBookingPage().sendOrderIdInBookingsSearch(TC004_BookHotelStep.OrderID);
		
	
	}
	@Then("User should verify same booked Order ID is present or not")
	public void userShouldVerifySameBookedOrderIDIsPresentOrNot() throws InterruptedException {
		Thread.sleep(2000);
		boolean validateOrderID = pom.getMyBookingPage().validateOrderID(TC004_BookHotelStep.OrderID);
		System.out.println(validateOrderID);
		Assert.assertTrue("Validating Order ID", validateOrderID);
	
	}
	@Then("User should verify same booked Hotel Name is present or not")
	public void userShouldVerifySameBookedHotelNameIsPresentOrNot() {
		
		boolean validateHotelName = pom.getMyBookingPage().validateHotelName(TC003_SelectHotelStep.lastHotelName);
		System.out.println(validateHotelName);
		Assert.assertTrue("Validating Hotel Name", validateHotelName);
	
	}
	@Then("User should verify same booked Hotel Price is present or not")
	public void userShouldVerifySameBookedHotelPriceIsPresentOrNot() {
	
		String ActualPrice = pom.getMyBookingPage().validatePrice();
		System.out.println(ActualPrice);
		String lastHotelPrice = TC003_SelectHotelStep.lastHotelPrice;
		System.out.println(lastHotelPrice);
		Assert.assertEquals("Validating Hotel Price", ActualPrice,lastHotelPrice);
	}
	@When("User edit the Check-in Date {string}")
	public void userEditTheCheckInDate(String checkInDate) throws InterruptedException {
		
		pom.getMyBookingPage().clickBtnEdit();
		pom.getMyBookingPage().checkIn(checkInDate);
		pom.getMyBookingPage().clickBtnConfirm();
		
	
	}
	@Then("User should verify after modify check-in date success message {string}")
	public void userShouldVerifyAfterModifyCheckInDateSuccessMessage(String expectedBookingSuccess) {
		
		
		Assert.assertEquals("Validate Booking Success Msg", expectedBookingSuccess, pom.getMyBookingPage().validateBookingSuccess());
	
	}




}
