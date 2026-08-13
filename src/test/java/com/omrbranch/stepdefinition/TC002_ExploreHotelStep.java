package com.omrbranch.stepdefinition;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC002_ExploreHotelStep {

	PageObjectManager pom = new PageObjectManager();

	@When("User search hotel {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void userSearchHotelAnd(String State, String City, String RoomType, String CheckInDate, String CheckOutDate,
			String noOfRoom, String noOfAdults, String NoOfChilds) throws InterruptedException {

		pom.getLoginPage().clickHotelBooking();
		pom.getExploreHotelPage().userSearchHotelWithAllDetails(State, City, RoomType, CheckInDate, CheckOutDate,
				noOfRoom, noOfAdults, NoOfChilds);
		pom.getExploreHotelPage().ClickSearchButton();
		Thread.sleep(1000);

	}

	@When("User search hotel {string}, {string}, {string}, {string}, {string} and {string}")
	public void userSearchHotelAnd(String State, String City, String CheckInDate, String CheckOutDate, String NoOfRoom,
			String NoOfAdults) throws InterruptedException {
		pom.getLoginPage().clickHotelBooking();
		pom.getExploreHotelPage().userSearchHotelMandateFields(State, City, CheckInDate, CheckOutDate, NoOfRoom,
				NoOfAdults);
		pom.getExploreHotelPage().ClickSearchButton();
		Thread.sleep(2000);
		pom.getSelectHotelPage().selectHotelMsg();
		Thread.sleep(1000);

	}

	@When("User click sort from low to high")
	public void userClickSortFromLowToHigh() throws InterruptedException {
		pom.getSelectHotelPage().SelectSortPriceLowToHigh();
		Thread.sleep(1000);

	}

	@When("User click sort from descending order")
	public void userClickSortFromDescendingOrder() throws InterruptedException {

		pom.getSelectHotelPage().SortByAlphabeticalDesc();
		Thread.sleep(1000);

	}

	@Then("User should verify after sorting that names are listed in descending order")
	public void userShouldVerifyAfterSortingThatNamesAreListedInDescendingOrder() throws InterruptedException {

		Thread.sleep(1000);

		boolean sortHotelNameDesc = pom.getSelectHotelPage().sortHotelNameDesc();
		System.out.println(sortHotelNameDesc);
		Assert.assertTrue(sortHotelNameDesc);

	}

	@When("User click Suite room type")
	public void userClickSuiteRoomType() throws InterruptedException {
		Thread.sleep(1000);
		pom.getSelectHotelPage().Roomtype();

	}

	@Then("User should verify after filtering that Suite room type is listed")
	public void userShouldVerifyAfterFilteringThatSuiteRoomTypeIsListed() {

		String selectedRoomType = pom.getSelectHotelPage().getSelectedRoomType();
		boolean contains = selectedRoomType.contains("Suite");
		Assert.assertTrue(contains);
	}

	@Then("User should verify search hotel success message {string}")
	public void userShouldVerifyAfterSearchHotelSuccessMessage(String SearchSuccessMsg) {
		String ActualMessage = pom.getSelectHotelPage().selectHotelMsg();
		Assert.assertEquals("Validate Welcome Hotel Msg", SearchSuccessMsg, ActualMessage);

	}

	@Then("User should verify the header contains {string}")
	public void userShouldVerifyTheHeaderContains(String string) {

		// rework
		String selectedRoomType = pom.getSelectHotelPage().getSelectedRoomType();
		boolean contains = selectedRoomType.contains("Suite");
		Assert.assertTrue(contains);
	}

	@Then("User click Search button")
	public void userClickSearchButton() {
		pom.getExploreHotelPage().ClickSearchButton();

	}

	@Then("User should verify after search hotel error message {string}, {string}, {string}, {string}, {string} and {string}")
	public void userShouldVerifyAfterSearchHotelErrorMessageAnd(String ExpectedStateErrorMsg,
			String ExpectedCityErrorMsg, String ExpectedCheckInDateErrorMsg, String ExpectedcheckOutDateErrorMsg,
			String ExpectednoOfRoomsErrorMsg, String ExpnoOfAdultserrorMsg) {

		Map<String, String> ActualErrors = pom.getExploreHotelPage().searchHotelWithoutEnteringAnyFields();

		Assert.assertEquals("Verify InvalidStateMsg", ActualErrors.get("InvalidStateMsg"), ExpectedStateErrorMsg);
		Assert.assertEquals("Verify InvalidCityMsg", ActualErrors.get("InvalidCityMsg"), ExpectedCityErrorMsg);
		Assert.assertEquals("Verify InvalidcheckInMsg", ActualErrors.get("InvalidCheckInMsg"),
				ExpectedCheckInDateErrorMsg);
		Assert.assertEquals("Verify InvalidCheckOutMsg", ActualErrors.get("InvalidCheckOutMsg"),
				ExpectedcheckOutDateErrorMsg);
		Assert.assertEquals("Verify InvalidNoOfAdults", ActualErrors.get("InvalidNoOfRooms"), ExpnoOfAdultserrorMsg);
		Assert.assertEquals("Verify InvalidNoOfRooms", ActualErrors.get("InvalidNoOfAdults"), ExpnoOfAdultserrorMsg);

		Map<WebElement, String> ActualErrors01 = pom.getExploreHotelPage().searchHotelWithoutEnteringAnyFields01();

		Assert.assertEquals("Verify InvalidStateMsg",
				ActualErrors01.get(pom.getExploreHotelPage().getInvalidStateMsg()), ExpectedStateErrorMsg);
		Assert.assertEquals("Verify InvalidCityMsg", ActualErrors01.get(pom.getExploreHotelPage().getInvalidCityMsg()),
				ExpectedCityErrorMsg);
		Assert.assertEquals("Verify InvalidCheckInMsg",
				ActualErrors01.get(pom.getExploreHotelPage().getInvalidCheckInMsg()), ExpectedCheckInDateErrorMsg);
		Assert.assertEquals("Verify InvalidCheckOutMsg",
				ActualErrors01.get(pom.getExploreHotelPage().getInvalidCheckOutMsg()), ExpectedcheckOutDateErrorMsg);
		Assert.assertEquals("Verify InvalidNoOfAdults",
				ActualErrors01.get(pom.getExploreHotelPage().getInvalidNoOfAdults()), ExpnoOfAdultserrorMsg);
		Assert.assertEquals("Verify InvalidNoOfRooms",
				ActualErrors01.get(pom.getExploreHotelPage().getInvalidNoOfRooms()), ExpectednoOfRoomsErrorMsg);

		// Scenario 1 - first i tried

		Assert.assertEquals("Verify InvalidStateMsg", ExpectedStateErrorMsg,
				pom.getExploreHotelPage().SelectStateErrorMsg());
		Assert.assertEquals("Verify InvalidCityMsg", ExpectedCityErrorMsg,
				pom.getExploreHotelPage().SelectCityErrorMsg());
		Assert.assertEquals("Verify InvalidCheckInMsg", ExpectedCheckInDateErrorMsg,
				pom.getExploreHotelPage().SelectCheckInErrorMsg());
		Assert.assertEquals("Verify InvalidCheckOutMsg", ExpectedcheckOutDateErrorMsg,
				pom.getExploreHotelPage().SelectCheckInErrorMsg());
		Assert.assertEquals("Verify InvalidNoOAdults", ExpectednoOfRoomsErrorMsg,
				pom.getExploreHotelPage().getInvalidNoOfAdults());
		Assert.assertEquals("Verify InvalidNoOfRooms", ExpectednoOfRoomsErrorMsg,
				pom.getExploreHotelPage().SelectCheckInErrorMsg());

	}

	@Then("User should verify after sorting that prices are listed from low to high")
	public void userShouldVerifyAfterSortingThatPricesAreListedFromLowToHigh() throws InterruptedException {

		boolean sortFinalPrices = pom.getSelectHotelPage().SortFinalPrices();
		// System.out.println(sortFinalPrices);
		Assert.assertTrue(sortFinalPrices);
		Thread.sleep(2000);

	}

}
