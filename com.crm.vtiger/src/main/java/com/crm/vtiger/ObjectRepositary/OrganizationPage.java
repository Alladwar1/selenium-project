package com.crm.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	@FindBy(xpath = "//img[contains(@title,'Create')]")
	private WebElement orgLookUpBtn;

	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickorgLookUp() {
		orgLookUpBtn.click();
	}

}
