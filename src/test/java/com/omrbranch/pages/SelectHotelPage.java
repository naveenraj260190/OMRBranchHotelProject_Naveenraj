package com.omrbranch.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.utility.BaseClass;

public class SelectHotelPage extends BaseClass {

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h5[text()='Select Hotel']")
	private WebElement SelectHotelConfirmMsg;

	@FindBy(xpath = "//label[@for='value_pltoh']")
	private WebElement RadioBtnSortLowToHigh;

	@FindBy(xpath = "//strong[@class='total-prize']")
	private List<WebElement> totalPrice;

	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	private List<WebElement> BtnContinue;

	public List<WebElement> getTotalPrice() {
		return totalPrice;
	}
	
	@FindBy(xpath = "//div[@class='col-md-5 hotel-suites']//h5")
	private List<WebElement> Hotelnames;

	public List<WebElement> getHotelnames() {
		return Hotelnames;
	}

	public List<WebElement> getBtnContinue() {
		return BtnContinue;
	}

	public WebElement getSortNameDesc() {
		return SortNameDesc;
	}



	@FindBy(xpath = "//label[@for='value_ndesc']")
	private WebElement SortNameDesc;

	@FindBy(id = "room_type")
	private WebElement TxtRoomType;

	@FindBy(xpath = "//label[@for='Suite']")
	private WebElement CheckBoxSuiteBtn;

	public WebElement getCheckBoxSuiteBtn() {
		return CheckBoxSuiteBtn;
	}

	public WebElement getTxtRoomType() {
		return TxtRoomType;
	}

	public WebElement getRadioBtnSortLowToHigh() {
		return RadioBtnSortLowToHigh;
	}

	public WebElement getSelectHotelConfirmMsg() {
		return SelectHotelConfirmMsg;
	}

	public String selectHotelMsg() {
		String Msg = getTextElement(SelectHotelConfirmMsg);
		return Msg;
	}

	public void SelectSortPriceLowToHigh() {
		clickElement(RadioBtnSortLowToHigh);

	}

	public void SortByAlphabeticalDesc() {
		clickElement(SortNameDesc);

	}

	public boolean SortFinalPrices() {

		ArrayList<Integer> ActPriceListAfterClickingSortbutton = new ArrayList<>();

		for (WebElement price : totalPrice) {
			String text = price.getText();
			// text = text.replace("$", "").replace(",", "").trim();
			text = text.replaceAll("[^0-9]", "").trim();

			// int int1 = Integer.parseInt(text);
			// ActPriceListAfterClickingSortbutton.add(int1);
			ActPriceListAfterClickingSortbutton.add(Integer.parseInt(text));
		}

//		List<Integer> ValidatePriceList1 = new ArrayList<>();
//		ValidatePriceList1.addAll(ActPriceListAfterClickingSortbutton);

		List<Integer> ValidatePriceList = new ArrayList<>(ActPriceListAfterClickingSortbutton);

		// Sort the copied list
		Collections.sort(ValidatePriceList);

		// System.out.println("Expected Price List : " + ValidatePriceList);

		// Compare both lists

		return ActPriceListAfterClickingSortbutton.equals(ValidatePriceList);

	}

	public boolean sortHotelNameDesc() {

		List<String> actualHotelNames = new ArrayList<>();

		// Get hotel names from the UI
		for (WebElement hotelName : Hotelnames) {
			actualHotelNames.add(hotelName.getText().trim());
		}

		// Create a copy
		List<String> expectedHotelNames = new ArrayList<>(actualHotelNames);

		// Sort the copy in descending order (Z to A)
		Collections.sort(expectedHotelNames, Collections.reverseOrder());

		// Compare actual vs expected
		return actualHotelNames.equals(expectedHotelNames);
	}

	public String getSelectedRoomType() {
		String RoomType = getTextElement(TxtRoomType);
		return RoomType;
	}

	public void Roomtype() {
		clickElement(CheckBoxSuiteBtn);
	}

	public void clickIndexBtnContinueFromlastBasedOnIndex(int x) {

		clickElement(getBtnContinue().get(getBtnContinue().size() - x));

	}

	public void clickIndexBtnContinueFromFirstBasedOnIndex(int x) {

		if (x >= 0 && x < BtnContinue.size()) {
			clickElement(BtnContinue.get(x));
		}
	}

	public void getHotelNamesfromFirstBasedOnIndex(int x) {

		if (x >= 0 && x < Hotelnames.size()) {
			clickElement(Hotelnames.get(x));
		}
	}

	public void getHotelPriceFromFirstBasedOnIndex(int x) {

		if (x >= 0 && x < totalPrice.size()) {
			clickElement(totalPrice.get(x));
		}

	}

	public String LastHotelName() {
		return Hotelnames.get(Hotelnames.size() - 1).getText().trim();
	}

	public String SecondLastHotelPrice() {
		return totalPrice.get(totalPrice.size() - 2).getText().trim();
	}

	public String SecondLastHotelName() {
		return Hotelnames.get(Hotelnames.size() - 2).getText().trim();
	}

	public String LastHotelPrice() {
		return totalPrice.get(totalPrice.size() - 1).getText().trim();
	}

}
