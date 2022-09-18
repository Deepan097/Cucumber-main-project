package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Deepan
 * @description Used to maintain webelement of login page
 * @date28/08/22
 */
public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtUserName;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(id = "login")
	private WebElement btnLogin;

	public WebElement getLblLoginError() {
		return lblLoginError;
	}

	@FindBy(className = "auth_error")
	private WebElement lblLoginError;

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	/**
	 * @description Used to perform login
	 * @param username
	 * @param password
	 */
	// 1.Login with valid credentials
	// 3.Login with invalid credentials
	public void login(String username, String password) {

		elementSendKeys(getTxtUserName(), username);
		elementSendKeys(getTxtPassword(), password);
		elementClick(getBtnLogin());
	}

	/**
	 * @description Used to perform login through enter key
	 * @param username
	 * @param password
	 */
	// 2.Login with valid credentials with Enter
	public void loginWithEnter(String username, String password) {
		elementSendKeys(getTxtUserName(), username);
		elementSendKeysWithEnter(getTxtPassword(), password);
	}

}
