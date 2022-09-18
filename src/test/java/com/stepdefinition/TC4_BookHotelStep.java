package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.base.BaseClass;
import com.pages.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Deepan
 * @description Used to perform book hotel page
 * @date 28/08/22
 */
public class TC4_BookHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @description
	 * @param firstName
	 * @param lastName
	 * @param billingAddress
	 * @param dataTable
	 */
	@When("User should perform book hotel {string},{string} and {string}")
	public void userShouldPerformBookHotelAnd(String firstName, String lastName, String billingAddress,
			io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> cards = dataTable.asMaps();

		Map<String, String> card = cards.get(0);
		String cardType = card.get("cardType");
		String cardNo = card.get("cardNo");
		String expMonth = card.get("expMonth");
		String expYear = card.get("expYear");
		String cvv = card.get("cvv");

		pom.getBookHotelPage().bookHotel(firstName, lastName, billingAddress, cardType, cardNo, expMonth, expYear, cvv);

	}

	/**
	 * @description Used to perform book hotel without any field
	 */
	@When("User should click book now without enter any fields")
	public void userShouldClickBookNowWithoutEnterAnyFields() {
		pom.getBookHotelPage().bookHotel();
	}
/**
 * @description Used to verify an error msg in all fields
 * @param expFirstNameError
 * @param expLastNameError
 * @param expAddressError
 * @param expCcNumError
 * @param expCcTypeError
 * @param expCcExpMonthError
 * @param expCcvError
 */
	@Then("User should verify error messages after book now {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void userShouldVerifyErrorMessagesAfterBookNowAnd(String expFirstNameError, String expLastNameError,
			String expAddressError, String expCcNumError, String expCcTypeError, String expCcExpMonthError,
			String expCcvError) {

		String actualFirstNameError = pom.getBookHotelPage().getLblFirstNameErrorMsg().getText();
		Assert.assertEquals("verify FirstNameError Message", expFirstNameError, actualFirstNameError);

		String actualLastNameError = pom.getBookHotelPage().getLblLastNameErrorMsg().getText();
		Assert.assertEquals("verify LastNameError Message", expLastNameError, actualLastNameError);

		String actualAddressError = pom.getBookHotelPage().getLblAddressErrorMsg().getText();
		Assert.assertEquals("verify AddressError Message", expAddressError, actualAddressError);

		String actualCcNumErrorr = pom.getBookHotelPage().getLblCcNumErrorMsg().getText();
		Assert.assertEquals("verify CcNumError Message", expCcNumError, actualCcNumErrorr);

		String actualCcTypeError = pom.getBookHotelPage().getLblCcTypeErrorMsg().getText();
		Assert.assertEquals("verify CcTypeError Message", expCcTypeError, actualCcTypeError);

		String actualCcExpMonthError = pom.getBookHotelPage().getLblCcExpiryErrorMsg().getText();
		Assert.assertEquals("verify CcExpMonthError Message", expCcExpMonthError, actualCcExpMonthError);

		String actualCcvError = pom.getBookHotelPage().getLblCcvErrorMsg().getText();
		Assert.assertEquals("verify CcvError Message", expCcvError, actualCcvError);

	}
/**
 * @description  Used to verify an book hotel is present 
 * @param expBookingSuccessMsg
 * @throws InterruptedException
 */
	@Then("User should verify after book hotel {string} is present")
	public void userShouldVerifyAfterBookHotelIsPresent(String expBookingSuccessMsg) throws InterruptedException {
		Thread.sleep(5000);
		String actualBookingSuccessMsg = pom.getBookingConfirmPage().getTxtBookingHeader().getText();
		Assert.assertEquals("verify a BookingSuccessMsg", expBookingSuccessMsg, actualBookingSuccessMsg);

	}

}
