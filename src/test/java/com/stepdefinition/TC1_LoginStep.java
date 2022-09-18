package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.pages.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Deepan
 * @description Used to perform login with differnt combination
 * @date 28/08/22
 *
 */
public class TC1_LoginStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();
/**
 * @description Used to launch browser and perform url
 * @throws FileNotFoundException
 * @throws IOException
 */
	@Given("User is on the adactin Page")
	public void userIsOnTheAdactinPage() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browserType"));
		enterUrl(getPropertyFileValue("url"));
	}
/**
 *@description Used to pass username and password to perform login
 * @param username
 * @param password
 */
	@When("User should perform login {string},{string}")
	public void userShouldPerformLogin(String username, String password) {
		pom.getLoginPage().login(username, password);
	}
/**
 * @description Used to perform username and password and perform login through enter key
 * @param username
 * @param password
 */
	@When("User should perform login {string},{string} with Enter Key")
	public void userShouldPerformLoginWithEnterKey(String username, String password) {
		pom.getLoginPage().loginWithEnter(username, password);

	}
/**
 * @description Used to verify an invalid error msg while passing invalid credentials
 * @param expLoginPartErrorMsg
 */
	@Then("User should verify Invalid login error message contains {string}")
	public void userShouldVerifyInvalidLoginErrorMessageContains(String expLoginPartErrorMsg) {
		String actualErrorMsg = pom.getLoginPage().getLblLoginError().getText();
		Assert.assertTrue(actualErrorMsg.contains(expLoginPartErrorMsg));
	}

}
