package com.omrbranch.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.utility.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement TxtEmail;

	@FindBy(id = "pass")
	private WebElement TxtPass;

	@FindBy(xpath = "//button[@value='login']")
	private WebElement BtnLogin;

	@FindBy(id = "errorMessage")
	private WebElement GetLoginErrorMsgTxt;
	
	@FindBy(xpath="//h3[text()='Hotel Booking']")
	private WebElement BtnHotelBooking;
	

	public WebElement getBtnHotelBooking() {
		return BtnHotelBooking;
	}

	public WebElement getGetLoginErrorMsgTxt() {
		return GetLoginErrorMsgTxt;

	}

	public WebElement getTxtEmail() {
		return TxtEmail;
	}

	public WebElement getTxtPass() {
		return TxtPass;
	}

	public WebElement getBtnLogin() {
		return BtnLogin;
	}

	public void login(String emailId, String password) {

		sendKeysElement(TxtEmail, emailId);
		sendKeysElement(TxtPass, password);
	}

	public void loginEnterKey(String emailId, String password) {

		sendKeysElement(TxtEmail, emailId);
		sendKeysElementEnter(TxtPass, password);
	}

	public String getLoginErrorMessageText() {
		return getTextElement(GetLoginErrorMsgTxt);
	}

	public void clickLoginBtn() {
		clickElement(BtnLogin);
	}
	
	public void clickHotelBooking()
	{
		clickElement(BtnHotelBooking);
	}
}
