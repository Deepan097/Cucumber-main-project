package com.stepdefinition;

import org.junit.Assert;

import com.pages.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
/**
 * 
 * @author Deepan
 *@description Used to perform select hotel
 */
public class TC3_SelectHotelStep {

	PageObjectManager pom = new PageObjectManager();
/**
 * @description Used to perform select hotel by selecting hotelname
 */
	@When("User should perform select hotel name")
	public void userShouldPerformSelectHotelName() {
		pom.getSelectHotelPage().selectHotel();
	   
	}
/**
 * @description Used to perform select hotel by without selecting hotel name
 */
	@When("User should click continue button without select hotel name")
	public void userShouldClickContinueButtonWithoutSelectHotelName() {
		pom.getSelectHotelPage().clickSelectHotel();
	}
/**
 * @description Used to verify an Book hotel after performing select hotel
 * @param expectedBookAHotelTxt
 */
	@Then("User should verify after select hotel navigates to book hotel page and verify {string} is present")
	public void userShouldVerifyAfterSelectHotelNavigatesToBookHotelPageAndVerifyIsPresent(String expectedBookAHotelTxt) {
		String actualBookAHotelTxt = pom.getBookHotelPage().getLblBookAHotel().getText();
		Assert.assertEquals("verify a Book A Hotel text",expectedBookAHotelTxt, actualBookAHotelTxt);
	}
	/**
	 * @description Used to get an error message
	 * @param expSelectAHotelErrorMsg
	 */
	
	
	@Then("User should verify error message {string}")
	public void userShouldVerifyErrorMessage(String expSelectAHotelErrorMsg) {
		String actualSelectAHotelErrorMsg = pom.getSelectHotelPage().getLblSelectAHotelErrorMsg().getText();
		Assert.assertEquals("verify a Select A Hotel Error Msg",expSelectAHotelErrorMsg, actualSelectAHotelErrorMsg);

	}

}
