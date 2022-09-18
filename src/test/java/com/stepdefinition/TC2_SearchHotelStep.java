package com.stepdefinition;

import com.pages.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/**
 * 
 * @author Deepan
 * @description Used to perform searchhotel 
 * @date28/08/22
 *
 */
public class TC2_SearchHotelStep {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @description Used to perform searchhotel by passing all fields
	 * @param location
	 * @param hotel
	 * @param roomType
	 * @param roomNos
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsPerRoom
	 * @param childPerRoom
	 */
	@When("User should perform search hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldPerformSearchHotelAnd(String location, String hotel, String roomType, String roomNos,
			String checkInDate, String checkOutDate, String adultsPerRoom, String childPerRoom) {

		pom.getSearchHotelPage().searchHotel(location, hotel, roomType, roomNos, checkInDate, checkOutDate,
				adultsPerRoom, childPerRoom);
	}

	/**
	 * @description Used to verify select hotel after perform with valid credentials
	 * @param lblSelectHotelText
	 */
	@Then("User should verify after search hotel navigates to select hotel page and verify {string} is present")
	public void userShouldVerifyAfterSearchHotelNavigatesToSelectHotelPageAndVerifyIsPresent(
			String lblSelectHotelText) {
		String actualSelectHotelText = pom.getSelectHotelPage().getLblSelectHotel().getText();
		Assert.assertEquals("verify after search hotel label Select Hotel", lblSelectHotelText, actualSelectHotelText);

	}

	/**
	 * @description Used to perform search hotel by giving mandatory fields only
	 * @param location
	 * @param roomNos
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsPerRoom
	 */
	@When("User should perform search hotel with only mandatory fields {string},{string},{string},{string} and {string}")
	public void userShouldPerformSearchHotelWithOnlyMandatoryFieldsAnd(String location, String roomNos,
			String checkInDate, String checkOutDate, String adultsPerRoom) {
		pom.getSearchHotelPage().searchHotel(location, roomNos, checkInDate, checkOutDate, adultsPerRoom);

	}

	/**
	 * @description Used to verify an error msg in date field
	 * @param expCheckInErrorMsg
	 * @param expCheckOutErrorMsg
	 */
	@Then("User should verify an error messages in date fields after search hotel {string},{string}")
	public void userShouldVerifyAnErrorMessagesInDateFieldsAfterSearchHotel(String expCheckInErrorMsg,
			String expCheckOutErrorMsg) {
		String actualCheckInErrorMsg = pom.getSearchHotelPage().getLblCheckin_span().getText();
		String actualCheckOutErrorMsg = pom.getSearchHotelPage().getLblCheckout_span().getText();
		Assert.assertEquals("verify an error messages in CheckInErrorMsg", expCheckInErrorMsg, actualCheckInErrorMsg);
		Assert.assertEquals("verify an error messages in CheckOutErrorMsg", expCheckOutErrorMsg,
				actualCheckOutErrorMsg);

	}

	/**
	 * @description Used to perform search hotel without any fields
	 */
	@When("User should click search button without entering any fields")
	public void userShouldClickSearchButtonWithoutEnteringAnyFields() {
		pom.getSearchHotelPage().SearchHotel();
	}

	/**
	 * @description Used to verify an error msg in location field
	 * @param expLocationErrorMsg
	 */
	@Then("User should verify an error message in location field after search hotel {string}")
	public void userShouldVerifyAnErrorMessageInLocationFieldAfterSearchHotel(String expLocationErrorMsg) {
		String actualLocationErrorMsg = pom.getSearchHotelPage().getLblLocation_span().getText();
		Assert.assertEquals("verify an error messages in location field", expLocationErrorMsg, actualLocationErrorMsg);

	}

}
