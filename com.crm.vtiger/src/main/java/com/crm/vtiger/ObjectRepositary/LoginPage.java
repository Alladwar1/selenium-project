package com.crm.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Identify the WebElement using selenium annotation
	@FindBy(name = "user_name")

	// declare the element as private
	private WebElement usernameText;
	@FindBy(name = "user_password")
	private WebElement passwordText;
	@FindBy(id = "submitButton")
	private WebElement submitButton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method perform login action
	 * @param UN
	 * @param PW
	 */

	public void login (String UN,String PW) {
		usernameText.sendKeys(UN);
		passwordText.sendKeys(PW);
		submitButton.click();
	}
	
}
