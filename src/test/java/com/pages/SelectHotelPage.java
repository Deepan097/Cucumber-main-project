package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.BaseClass;
/**
 * 
 * @author Deepan
 *@description Used to maintain webelement of selecthotel page
 */

public class SelectHotelPage extends BaseClass {
	
	public SelectHotelPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="radiobutton_0")
	private WebElement btnRadio;
	
	@FindBy(id="continue")
	private WebElement btnContinue ;

	@FindBy(className="login_title")
	private WebElement lblSelectHotel ;
	
	@FindBy(id="radiobutton_span")
	private WebElement lblSelectAHotelErrorMsg ;
	
	

	
	public WebElement getLblSelectAHotelErrorMsg() {
		return lblSelectAHotelErrorMsg;
	}
	
	public WebElement getLblSelectHotel() {
		return lblSelectHotel;
	}
	public WebElement getBtnRadio() {
		return btnRadio;
	}
	public WebElement getBtnContinue() {
		return btnContinue;
	}

/**
 *@description Used to perform select hotel with hotel name 
 */
	// 1.Verifying Adactin Select Hotel Page With Hotel Name
	public void selectHotel() {
		elementClick(getBtnRadio());
		elementClick(getBtnContinue());
	}
/**
 * @description Used to perform select hotel without hotel name 
 */
	// 2.click continue button without select hotel name
	public void clickSelectHotel() {
		elementClick(getBtnContinue());

	}

}
