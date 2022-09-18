package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pages.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @description Used to perform cancel booking
 * @author Deepan
 *
 */
public class TC5_CancelBookingStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @description used to perform cancel booking by cancel order id
	 * @throws InterruptedException
	 */
	@When("User should perform search orderId and cancel orderId")
	public void userShouldPerformSearchOrderIdAndCancelOrderId() throws InterruptedException {
		String bookingId = pom.getBookingConfirmPage().getBookingId();
		pom.getCancelBookingPagePage().cancelBooking(bookingId);
	}

	/**
	 * @description Used to perform cancel booking through existing order id
	 * @param bookingId
	 */
	@When("User should perform search orderId and cancel orderId {string}")
	public void userShouldPerformSearchOrderIdAndCancelOrderId(String bookingId) {
		pom.getCancelBookingPagePage().cancelBooking(bookingId);
	}

	/**
	 * @description Used to verify sucess cancel booking msg
	 * @param expCancelledMsg
	 */
	@Then("User should verify after cancel orderId {string}")
	public void userShouldVerifyAfterCancelOrderId(String expCancelledMsg) {
		String actualCancelledMsg = pom.getCancelBookingPagePage().getCancelledMsg().getText();
		Assert.assertEquals("verify a booking cancelled message", expCancelledMsg, actualCancelledMsg);

	}

}
