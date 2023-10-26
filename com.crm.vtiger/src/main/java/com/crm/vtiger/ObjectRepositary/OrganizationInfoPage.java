package com.crm.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	@FindBy(css = ".dvHeaderText")
	private WebElement orgnameHeader;

	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getcreatedorgname() {
		return orgnameHeader.getText();
	}
}
