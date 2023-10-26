package com.crm.vtiger.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtility.WebDriverUtility;

public class HandleAutoSuggestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.maximizepage(driver);
		wutil.waitThePageImplicitly(driver);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("samsung s24");
		driver.findElement(By.xpath("//span[text()='✕']")).click();

	}

}
