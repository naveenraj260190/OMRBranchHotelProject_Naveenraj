package com.omrbranch.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.utility.BaseClass;

public class BookingConfirmationPage extends BaseClass {

	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "booking-code")
	private WebElement TxtConfimedBookingID;

	@FindBy(xpath = "//p//strong")
	private WebElement txtHotelName;

	public WebElement getTxtHotelName() {
		return txtHotelName;
	}

	public WebElement getTxtConfimedBookingID() {
		return TxtConfimedBookingID;
	}

	public String SavingTheOrderID() {

		String bookingConfirmation = getTextElement(TxtConfimedBookingID).replace("#", "")
				.replace(" Booking is Confirmed", "").trim();
		return bookingConfirmation;
	}

	public String bookingConfirmationMsg() {

		String bookingConfirmationMsg = getTextElement(TxtConfimedBookingID);
		return bookingConfirmationMsg;
	}

	public String getHotelName() {
		String hotelName = getTextElement(txtHotelName);
		return hotelName;
	}
}
