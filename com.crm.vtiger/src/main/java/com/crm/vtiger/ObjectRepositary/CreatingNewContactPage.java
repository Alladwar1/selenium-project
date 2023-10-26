package com.crm.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
@FindBy(name="lastname")private WebElement lastnameEdt;
@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement saveBtn;

public CreatingNewContactPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public void clickcreatecontact(String contactName) {
	lastnameEdt.sendKeys(contactName);
	saveBtn.click();
}
}
