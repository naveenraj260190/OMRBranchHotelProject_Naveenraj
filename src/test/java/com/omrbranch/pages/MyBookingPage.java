package com.omrbranch.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.omrbranch.utility.BaseClass;

public class MyBookingPage extends BaseClass {

	public MyBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='My Booking']")
	private WebElement btnMyBookingPage;

	public WebElement getBtnMyBookingPage() {
		return btnMyBookingPage;
	}

	public void clickBtnMyBookingPage() {
		clickElement(btnMyBookingPage);
	}

	@FindBy(xpath = "//div[@class='col-md-5']//h4")
	private WebElement txtBookings;

	public WebElement getTxtBookings() {
		return txtBookings;
	}

	public String getTextBooking() {
		String bookings = getTextElement(txtBookings);
		return bookings;
	}

	@FindBy(xpath = "//input[@name='search']")
	private WebElement txtBoxSearchByBooking;

	public WebElement getTxtBoxSearchByBooking() {
		return txtBoxSearchByBooking;
	}

	public void sendOrderIdInBookingsSearch(String OrderID) {
		sendKeysElement(txtBoxSearchByBooking, OrderID);

	}

	@FindBy(xpath = "//div[@class='room-code']//span")
	private List<WebElement> orderIDS;

	public List<WebElement> getOrderIDS() {
		return orderIDS;
	}

	public boolean validateOrderID(String expectedOrderID) {

		for (WebElement element : getOrderIDS()) {
			if (element.getText().replace("#", "").trim().equals(expectedOrderID)) {
				return true;
			}
		}

		return false;
	}

	public List<WebElement> getHotelNames() {
		return HotelNames;
	}

	@FindBy(xpath = "//h5")
	private List<WebElement> HotelNames;

	public boolean validateHotelName(String hotelName) {

		for (WebElement element : getHotelNames()) {
			if (element.getText().equalsIgnoreCase(hotelName)) {
				return true;
			}
		}
		return false;

	}

	@FindBy(xpath = "//strong[@class='total-prize']")
	private WebElement TotalPrice;

	public WebElement getTotalPrice() {
		return TotalPrice;
	}

	public String validatePrice() {
		String Price = getTextElement(TotalPrice).replaceAll("[^0-9]", "");
		return Price;

	}

	@FindBy(xpath = "//button[text()='Edit']")
	private WebElement btnEdit;

	public WebElement getBtnEdit() {
		return btnEdit;
	}

	public void clickBtnEdit() {
		clickElement(btnEdit);
	}

	@FindBy(xpath = "//input[@name='check_in']")
	private WebElement btnCheckIn;

	public WebElement getBtnCheckIn() {
		return btnCheckIn;
	}

	public void checkIn(String checkIn) throws InterruptedException {
		Thread.sleep(2000);
		sendKeysElementJS(btnCheckIn, checkIn);
	}

	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement btnConfirm;

	public WebElement getBtnConfirm() {
		return btnConfirm;
	}

	public void clickBtnConfirm() {
		clickElement(btnConfirm);
	}

	@FindBy(xpath = "//li[contains(text(),'Booking updated successfully')]")
	private WebElement msgBookingUpdatedSuccess;

	public WebElement getMsgBookingUpdatedSuccess() {
		return msgBookingUpdatedSuccess;
	}

	public String validateBookingSuccess() {
		String msgBookingSuccess = getTextElement(msgBookingUpdatedSuccess);
		return msgBookingSuccess;
	}

	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	private WebElement btnCancel;

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public void clickBtnCancel() {
		clickElement(btnCancel);
	}

	@FindBy(xpath = "//li[contains(text(),'Your booking cancelled successfully')]")
	private WebElement msgBookingCancelledSuccess;

	public WebElement getMsgBookingCancelledSuccess() {
		return msgBookingCancelledSuccess;
	}

	public String validateBookingCancel() {
		String msgBookingSuccess = getTextElement(msgBookingCancelledSuccess).trim();
		return msgBookingSuccess;
	}

}
