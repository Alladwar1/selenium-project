package com.crm.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class HomePage  extends WebDriverUtility{
	@FindBy(linkText = "Organizations")
	private WebElement orglink;

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickorgLink() {
		orglink.click();
	}

	public void clickcontact() {
		contactLink.click();
	}

	public void logout(WebDriver driver) {
		moveToElement(driver, AdministratorImg);
		signOutLink.click();
	}

	
}
