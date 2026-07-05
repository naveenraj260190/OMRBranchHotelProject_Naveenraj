package com.omrbranch.stepdefinition;

import org.junit.Assert;

import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC004_BookHotelStep {

	PageObjectManager pom = new PageObjectManager();
	static String OrderID;

	@Then("User should validate after search hotel success message {string}")
	public void userShouldValidateAfterSearchHotelSuccessMessage(String HotelSuccessMsg) {

		String ActualMessage = pom.getSelectHotelPage().selectHotelMsg();
		System.out.println(ActualMessage);
		Assert.assertEquals("Validate Welcome Hotel Msg", HotelSuccessMsg, ActualMessage);

	}

	@When("User add Guest Details {string}, {string}, {string}, {string} and {string}")
	public void userAddGuestDetailsAnd(String salutation, String firstName, String lastName, String MobileNo,
			String Email) {
		pom.getBookHotelPage().enteringUserGuestDetails(salutation, firstName, lastName, MobileNo, Email);
	}

	@When("User add GST Details {string}, {string} and {string}")
	public void userAddGSTDetailsAnd(String registrationNo, String companyName, String companyAddress) {

		pom.getBookHotelPage().enteringGSTDetails(registrationNo, companyName, companyAddress);
		pom.getBookHotelPage().BtnNextOne();
		pom.getBookHotelPage().btnAtSpecialRequestPage();
	}

	@When("User add GST Details {string}, {string} and {string} and User add Special Request {string}")
	public void userAddGSTDetailsAndAndUserAddSpecialRequest(String registrationNo, String companyName,
			String companyAddress, String specialRequest) {
		pom.getBookHotelPage().enteringGSTDetails(registrationNo, companyName, companyAddress);
		pom.getBookHotelPage().BtnNextOne();
		pom.getBookHotelPage().enteringUserSpecialRequest(specialRequest);
		pom.getBookHotelPage().btnAtSpecialRequestPage();
	}

	@When("User enter payment details, proceed with Card Type {string}")
	public void userEnterPaymentDetailsProceedWithCardType(String paymentType, DataTable dataTable) {

		pom.getBookHotelPage().clickPaymentTypeAsCard();
		pom.getBookHotelPage().optingCardType(paymentType);
		pom.getBookHotelPage().userEnterPaymentDetailsProceedWithCardType(dataTable);
		pom.getBookHotelPage().BtnAtPaymentDetailsPage();

	}

	@When("User enter upi details {string} and click submit")
	public void userEnterUpiDetailsAndClickSubmit(String upiID) {

		pom.getBookHotelPage().clickUPIID();
		pom.getBookHotelPage().sendUPIID(upiID);
		pom.getBookHotelPage().BtnAtPaymentDetailsPage();
	}

	@When("User should verify after hotel booking success message {string} and save the order ID")
	public void userShouldVerifyAfterHotelBookingSuccessMessageAndSaveTheOrderID(String bookingConfirmation) {

		OrderID = pom.getBookingConfirmationPage().SavingTheOrderID();
		System.out.println("bookingConfirmation" + bookingConfirmation);
		String bookingConfirmationMsg = pom.getBookingConfirmationPage().bookingConfirmationMsg();
		System.out.println("bookingConfirmationMsg: " + bookingConfirmationMsg);
		boolean contains = pom.getBookingConfirmationPage().bookingConfirmationMsg().contains(bookingConfirmation);
		System.out.println(contains);
		Assert.assertTrue(contains);
	}

	@Then("User should verify same selected Hotel is booked or not")
	public void userShouldVerifySameSelectedHotelIsBookedOrNot() {

		boolean contains2 = TC003_SelectHotelStep.lastHotelName
				.contains(pom.getBookingConfirmationPage().getHotelName());
		System.out.println(contains2);
		Assert.assertTrue(
				TC003_SelectHotelStep.lastHotelName.contains(pom.getBookingConfirmationPage().getHotelName()));
	}

	@When("User Skipping Special Request")
	public void userSkippingSpecialRequest() {

		pom.getBookHotelPage().btnAtSpecialRequestPage();
	}

	@When("User skipping GST Details and User add Special Request {string}")
	public void userSkippingGSTDetailsAndUserAddSpecialRequest(String Request) {

		pom.getBookHotelPage().BtnNextOne();
		pom.getBookHotelPage().enteringUserSpecialRequest(Request);
		pom.getBookHotelPage().btnAtSpecialRequestPage();

	}

	@When("User skipping GST Details and Special Request")
	public void userSkippingGSTDetailsAndUserAndSpecialRequest() {
		pom.getBookHotelPage().BtnNextOne();
		pom.getBookHotelPage().btnAtSpecialRequestPage();
	}

	@When("User click credit card")
	public void userClickCreditCard() {
		pom.getBookHotelPage().clickPaymentTypeAsCard();

	}

	@When("User click submit without entering payment details")
	public void userClickSubmitWithoutEnteringPaymentDetails() {
		pom.getBookHotelPage().BtnAtPaymentDetailsPage();
	}

	@Then("User should verify after payment details error message {string}, {string}, {string}, {string}, {string} and {string}")
	public void userShouldVerifyAfterPaymentDetailsErrorMessageAnd(String expCardPaymentType, String card,
			String cardNo, String cardName, String cardExpiry, String cardCVV) {

		String actualCardPaymentTypeErrorMsg = pom.getBookHotelPage().getCardPaymentTypeErrorMsg();
		System.out.println(actualCardPaymentTypeErrorMsg);
		Assert.assertEquals("Validate Card Month error Msg", pom.getBookHotelPage().getCardMonthErrorMsg(), cardExpiry);

		Assert.assertEquals("Validate Card Vendor Error Msg", pom.getBookHotelPage().getCardType(), card);
		Assert.assertEquals("Validate Card Payment Type Error Msg", actualCardPaymentTypeErrorMsg, expCardPaymentType);
		Assert.assertEquals("Validate Card CVV Type Error Msg", pom.getBookHotelPage().getCardCvv(), cardCVV);
		Assert.assertEquals("Validate Card Number Error Msg", pom.getBookHotelPage().getCardNo(), cardNo);
		Assert.assertEquals("Validate Card Name Error Msg", pom.getBookHotelPage().getCardNameErrorMsg(), cardName);

	}

	@When("User click upi")
	public void userClickUpi() {

		pom.getBookHotelPage().clickUPIID();

	}

	@Then("User should verify after payment details error message {string}")
	public void userShouldVerifyAfterPaymentDetailsErrorMessage(String upixpectedMessage) {

		Assert.assertEquals("Validate UPI Message", upixpectedMessage, pom.getBookHotelPage().getInvalidUpiMsg());

	}

	@When("User add Special Request {string}")
	public void userAddSpecialRequest(String SpecialRequest) {

		pom.getBookHotelPage().enteringUserSpecialRequest(SpecialRequest);
		pom.getBookHotelPage().btnAtSpecialRequestPage();

	}

}
