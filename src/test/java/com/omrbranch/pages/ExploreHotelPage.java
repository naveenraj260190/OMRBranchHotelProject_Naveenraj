package com.omrbranch.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.utility.BaseClass;

public class ExploreHotelPage extends BaseClass {

	public ExploreHotelPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(text(),'Welcome')]")
	private WebElement welcomeMsg;

	@FindBy(id = "state")
	private WebElement selectState;

	@FindBy(xpath = "//span[@title='Select City *']")
	private WebElement clickselectCity;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchCityTxtBox;

	@FindBy(xpath = "//textarea[@class='select2-search__field']")
	private WebElement selectRoomType;

	@FindBy(name = "check_in")
	private WebElement check_In_Date;

	@FindBy(name = "check_out")
	private WebElement check_Out_Date;

	@FindBy(name = "no_rooms")
	private WebElement noOfRoom;

	@FindBy(name = "no_adults")
	private WebElement noOfAdults;

	@FindBy(id = "no_child")
	private WebElement noOfChild;

	@FindBy(id = "hotelsearch_iframe")
	private WebElement frameHotelSearchAndReset;

	@FindBy(xpath = "//button[text()='Search']")
	private WebElement BtnSearch;

	@FindBy(id = "invalid-state")
	private WebElement InvalidStateMsg;

	@FindBy(id = "invalid-city")
	private WebElement InvalidCityMsg;

	@FindBy(id = "invalid-check_in")
	private WebElement InvalidCheckInMsg;

	@FindBy(id = "invalid-check_out")
	private WebElement InvalidCheckOutMsg;

	@FindBy(id = "invalid-no_rooms")
	private WebElement InvalidNoOfRooms;

	@FindBy(id = "invalid-no_adults")
	private WebElement InvalidNoOfAdults;

	public WebElement getInvalidStateMsg() {
		return InvalidStateMsg;
	}

	public WebElement getInvalidCityMsg() {
		return InvalidCityMsg;
	}

	public WebElement getInvalidCheckInMsg() {
		return InvalidCheckInMsg;
	}

	public WebElement getInvalidCheckOutMsg() {
		return InvalidCheckOutMsg;
	}

	public WebElement getInvalidNoOfRooms() {
		return InvalidNoOfRooms;
	}

	public WebElement getInvalidNoOfAdults() {
		return InvalidNoOfAdults;
	}

	public WebElement getSelectState() {
		return selectState;
	}

	public WebElement getClickselectCity() {
		return clickselectCity;
	}

	public WebElement getSearchCityTxtBox() {
		return searchCityTxtBox;
	}

	public WebElement getSelectRoomType() {
		return selectRoomType;
	}

	public WebElement getCheck_In_Date() {
		return check_In_Date;
	}

	public WebElement getCheck_Out_Date() {
		return check_Out_Date;
	}

	public WebElement getNoOfRoom() {
		return noOfRoom;
	}

	public WebElement getNoOfAdults() {
		return noOfAdults;
	}

	public WebElement getNoOfChild() {
		return noOfChild;
	}

	public WebElement getFrameHotelSearchAndReset() {
		return frameHotelSearchAndReset;
	}

	public WebElement getBtnSearch() {
		return BtnSearch;
	}

	public String getWelcomeMsg() {
		String WelcomeMessage = getTextElement(welcomeMsg);
		return WelcomeMessage;
	}

	public void userSearchHotelWithAllDetails(String State, String City, String RoomType, String CheckInDate,
			String CheckOutDate, String Room, String Adults, String Child) {

		selectOptionByText(selectState, State);
		clickElement(clickselectCity);
		sendKeysElementEnter(searchCityTxtBox, City);
		sendKeysElementEnter(selectRoomType, RoomType);
		sendKeysElementJS(check_In_Date, CheckInDate);
		sendKeysElementJS(check_Out_Date, CheckOutDate);
		selectOptionByText(noOfRoom, Room);
		selectOptionByText(noOfAdults, Adults);
		sendKeysElementEnter(noOfChild, Child);

	}

	public void userSearchHotelMandateFields(String State, String City, String CheckInDate, String CheckOutDate,
			String Room, String Adults) {

		selectOptionByText(selectState, State);
		clickElement(clickselectCity);
		sendKeysElementEnter(searchCityTxtBox, City);
		sendKeysElementJS(check_In_Date, CheckInDate);
		sendKeysElementJS(check_Out_Date, CheckOutDate);
		selectOptionByText(noOfRoom, Room);
		selectOptionByText(noOfAdults, Adults);

	}

	public void ClickSearchButton() {

		driver.switchTo().frame(frameHotelSearchAndReset);
		clickElement(BtnSearch);
		driver.switchTo().defaultContent();

	}

	public String SelectStateErrorMsg() {
		String StateErrMsg = getTextElement(InvalidStateMsg);
		return StateErrMsg;
	}

	public String SelectCityErrorMsg() {
		String CityErrMsg = getTextElement(InvalidCityMsg);
		return CityErrMsg;
	}

	public String SelectCheckInErrorMsg() {
		String CheckInErrorMsg = getTextElement(InvalidCheckInMsg);
		return CheckInErrorMsg;
	}

	public String SelectCheckOutErrorMsg() {
		String CheckOutErrorMsg = getTextElement(InvalidCheckOutMsg);
		return CheckOutErrorMsg;
	}

	public String SelectInvalidNoAdultsMsg() {
		String InvalidNoOFAdults = getTextElement(InvalidNoOfAdults);
		return InvalidNoOFAdults;
	}

	public String SelectInvalidNoOfRoomsMsg() {
		String InvalidNoOfRoomsMsg = getTextElement(InvalidNoOfRooms);
		return InvalidNoOfRoomsMsg;
	}

	public Map<String, String> searchHotelWithoutEnteringAnyFields() {

		Map<String, String> Expectederrors = new HashMap<>();
		Expectederrors.put("InvalidStateMsg", InvalidStateMsg.getText());
		Expectederrors.put("InvalidCityMsg", InvalidCityMsg.getText());
		Expectederrors.put("InvalidCheckInMsg", InvalidCheckInMsg.getText());
		Expectederrors.put("InvalidCheckOutMsg", InvalidCheckOutMsg.getText());
		Expectederrors.put("InvalidNoOfRooms", InvalidNoOfRooms.getText());
		Expectederrors.put("InvalidNoOfAdults", InvalidNoOfAdults.getText());
		return Expectederrors;
	}

	public Map<WebElement, String> searchHotelWithoutEnteringAnyFields01() {

		Map<WebElement, String> Expectederrors = new HashMap<>();
		Expectederrors.put(getInvalidStateMsg(), getTextElement(InvalidStateMsg));
		Expectederrors.put(getInvalidCityMsg(), getTextElement(InvalidCityMsg));
		Expectederrors.put(getInvalidCheckInMsg(), getTextElement(InvalidCheckInMsg));
		Expectederrors.put(getInvalidCheckOutMsg(), getTextElement(InvalidCheckOutMsg));
		Expectederrors.put(getInvalidNoOfRooms(), getTextElement(InvalidNoOfRooms));
		Expectederrors.put(getInvalidNoOfAdults(), getTextElement(InvalidNoOfAdults));
		return Expectederrors;
	}
}
