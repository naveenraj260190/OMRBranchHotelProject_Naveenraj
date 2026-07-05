package com.omrbranch.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.utility.BaseClass;

public class BookHotelPage extends BaseClass {

	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[@class='px-3 py-2']")
	private WebElement BookHotelTxt;

	@FindBy(xpath = "//input[@id='own']")
	private WebElement bookingForMyself;

	@FindBy(xpath = "//select[@name='title']")
	private WebElement drpDwnSalulation;

	@FindBy(xpath = "//input[@id='first_name']")
	private WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='last_name']")
	private WebElement txtLastName;

	@FindBy(id = "user_phone")
	private WebElement txtMobile;

	@FindBy(id = "user_email")
	private WebElement txtEmail;

	@FindBy(id = "gst")
	private WebElement checkBoxGST;

	@FindBy(id = "gst_registration")
	private WebElement txtGSTRegistrationNumber;

	@FindBy(id = "company_name")
	private WebElement txtCompanyName;

	@FindBy(id = "company_address")
	private WebElement txtCompanyAddress;

	@FindBy(id = "step1next")
	private WebElement BtnNextOne;

	@FindBy(id = "early")
	private WebElement chkBoxEarlyCheckIn;

	@FindBy(id = "other_request")
	private WebElement otherRequestTxtBox;

	@FindBy(id = "step2next")
	private WebElement BtnNextTwo;

	@FindBy(xpath = "//h5[text()='Credit/Debit/ATM Card']")
	private WebElement paymentTypeCard;

	@FindBy(name = "payment_type")
	private WebElement DebitOrCreditCard;

	@FindBy(name = "card_type")
	private WebElement cardVendorType;

	public WebElement getDebitOrCreditCard() {
		return DebitOrCreditCard;
	}

	public WebElement getCardVendorType() {
		return cardVendorType;
	}

	@FindBy(id = "card_no")
	private WebElement TxtCardNumber;

	@FindBy(id = "card_name")
	private WebElement TxtCardNme;

	@FindBy(id = "card_month")
	private WebElement drpDwnCardMnth;

	@FindBy(id = "card_year")
	private WebElement drpDwnCardYear;

	@FindBy(id = "cvv")
	private WebElement TxtCvv;

	@FindBy(id = "submitBtn")
	private WebElement BtnSubmit;

	@FindBy(id = "invalid-payment_type")
	private WebElement invalidPaymentType;

	@FindBy(id = "invalid-card_type")
	private WebElement invalidCardType;

	@FindBy(id = "card_no")
	private WebElement invalidCardNo;

	@FindBy(id = "invalid-card_name")
	private WebElement invalidCardName;

	public WebElement getUpiPayment() {
		return upiPayment;
	}

	@FindBy(id = "invalid-card_month")
	private WebElement invalidCardMonth;

	@FindBy(id = "invalid-cvv")
	private WebElement invalidCvv;

	@FindBy(xpath = "//div[@class='upi pm']//h5")
	private WebElement upiPayment;

	@FindBy(id = "upi_id")
	private WebElement txtUpiID;

	@FindBy(id = "invalid-upi")
	private WebElement txtInvalidUpiMsg;

	public WebElement getTxtInvalidUpiMsg() {
		return txtInvalidUpiMsg;
	}

	public WebElement getTxtUpiID() {
		return txtUpiID;
	}

	public WebElement getInvalidPaymentType() {
		return invalidPaymentType;
	}

	public WebElement getInvalidCardType() {
		return invalidCardType;
	}

	public WebElement getInvalidCardNo() {
		return invalidCardNo;
	}

	public WebElement getInvalidCardName() {
		return invalidCardName;
	}

	public WebElement getInvalidCardMonth() {
		return invalidCardMonth;
	}

	public WebElement getInvalidCvv() {
		return invalidCvv;
	}

	public WebElement getBookingForMyself() {
		return bookingForMyself;
	}

	public WebElement getDrpDwnSalulation() {
		return drpDwnSalulation;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtMobile() {
		return txtMobile;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getCheckBoxGST() {
		return checkBoxGST;
	}

	public WebElement getTxtGSTRegistrationNumber() {
		return txtGSTRegistrationNumber;
	}

	public WebElement getTxtCompanyName() {
		return txtCompanyName;
	}

	public WebElement getTxtCompanyAddress() {
		return txtCompanyAddress;
	}

	public WebElement getBtnNextOne() {
		return BtnNextOne;
	}

	public WebElement getChkBoxEarlyCheckIn() {
		return chkBoxEarlyCheckIn;
	}

	public WebElement getOtherRequestTxtBox() {
		return otherRequestTxtBox;
	}

	public WebElement getBtnNextTwo() {
		return BtnNextTwo;
	}

	public WebElement getPaymentTypeCard() {
		return paymentTypeCard;
	}

	public WebElement getTxtCardNumber() {
		return TxtCardNumber;
	}

	public WebElement getTxtCardNme() {
		return TxtCardNme;
	}

	public WebElement getDrpDwnCardMnth() {
		return drpDwnCardMnth;
	}

	public WebElement getDrpDwnCardYear() {
		return drpDwnCardYear;
	}

	public WebElement getTxtCvv() {
		return TxtCvv;
	}

	public WebElement getBtnSubmit() {
		return BtnSubmit;
	}

	public WebElement getBookHotelTxt() {
		return BookHotelTxt;
	}

	public String getBookedHotelName() {
		String text = BookHotelTxt.getText();
		return text;
	}

	public void enteringUserGuestDetails(String salutation, String firstName, String lastName, String MobileNo,
			String Email) {
		clickElement(bookingForMyself);
		selectOptionByValue(drpDwnSalulation, salutation);
		sendKeysElement(txtFirstName, firstName);
		sendKeysElement(txtLastName, lastName);
		sendKeysElement(txtMobile, MobileNo);
		sendKeysElement(txtEmail, Email);

	}

	public void enteringGSTDetails(String registrationNo, String companyName, String companyAddress) {

		clickElement(checkBoxGST);
		sendKeysElement(txtGSTRegistrationNumber, registrationNo);
		sendKeysElement(txtCompanyName, companyName);
		sendKeysElement(txtCompanyAddress, companyAddress);

	}

	public void enteringUserSpecialRequest(String specialRequest) {

		sendKeysElement(otherRequestTxtBox, specialRequest);

	}

	public void btnAtSpecialRequestPage() {
		clickElement(BtnNextTwo);
	}

	public void clickPaymentTypeAsCard() {
		clickElement(paymentTypeCard);
	}

	public void BtnNextOne() {
		clickElement(BtnNextOne);
	}

	public void userEnterPaymentDetailsProceedWithCardType(io.cucumber.datatable.DataTable dataTable) {

		// selectOptionByValue(DebitOrCreditCard, paymentType);

		List<Map<String, String>> asMaps = dataTable.asMaps(String.class, String.class);
		String Select_Card = asMaps.get(0).get("Select Card");
		String Card_No = asMaps.get(0).get("Card No");
		String Card_Name = asMaps.get(0).get("Card Name");
		String Card_Month = asMaps.get(0).get("Month");
		String Year = asMaps.get(0).get("Year");
		String CVV = asMaps.get(0).get("CVV");

		selectOptionByText(cardVendorType, Select_Card);
		sendKeysElement(TxtCardNumber, Card_No);
		sendKeysElement(TxtCardNme, Card_Name);
		selectOptionByText(drpDwnCardMnth, Card_Month);
		selectOptionByValue(drpDwnCardYear, Year);
		sendKeysElement(TxtCvv, CVV);

	}

	public void optingCardType(String Type) {
		selectOptionByValue(DebitOrCreditCard, Type);
	}

	public void userEnterPaymentDetailsProceedWithCardType01(String paymentType, String selectCard, String cardNo,
			String cardName, String month, String year, String cvv) {

		// clickElement(paymentTypeCard);
		selectOptionByValue(DebitOrCreditCard, paymentType);

		selectOptionByText(cardVendorType, selectCard);
		sendKeysElement(TxtCardNumber, cardNo);
		sendKeysElement(TxtCardNme, cardName);
		selectOptionByText(drpDwnCardMnth, month);
		selectOptionByValue(drpDwnCardYear, year);
		sendKeysElement(TxtCvv, cvv);
	}

	public void BtnAtPaymentDetailsPage() {

		clickElement(BtnSubmit);

	}

	public String getCardPaymentTypeErrorMsg() {
		String CardTypeErrMsg = getTextElement(invalidPaymentType);
		return CardTypeErrMsg;
	}

	public String getCardMonthErrorMsg() {
		String CardMonth = getTextElement(invalidCardMonth);
		return CardMonth;
	}

	public String getCardNameErrorMsg() {
		String CardName = getTextElement(invalidCardName);
		return CardName;
	}

	public String getCardNo() {
		String CardNo = getTextElement(invalidCardNo);
		return CardNo;
	}

	public String getCardType() {
		String CardType = getTextElement(invalidCardType);
		return CardType;
	}

	public String getCardCvv() {
		String CardCvv = getTextElement(invalidCvv);
		return CardCvv;
	}

	public void clickUPIID() {
		clickElement(upiPayment);
	}

	public void sendUPIID(String upiID) {
		sendKeysElement(txtUpiID, upiID);
	}

	public String getInvalidUpiMsg() {
		String InvalidUpiMsg = getTextElement(txtInvalidUpiMsg);
		return InvalidUpiMsg;
	}
}
