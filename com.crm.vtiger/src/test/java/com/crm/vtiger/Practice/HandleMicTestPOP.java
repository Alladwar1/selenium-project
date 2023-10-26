package com.crm.vtiger.Practice;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import GenericUtility.WebDriverUtility;

public class HandleMicTestPOP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions settings = new ChromeOptions();
		settings.addArguments("--use-fake-device-for-media-stream");
		settings.addArguments("--use-fake-ui-for-media-stream");
		WebDriver driver = new ChromeDriver(settings);
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.maximizepage(driver);
		wutil.waitThePageImplicitly(driver);
		driver.get("https://mictests.com/");
		driver.findElement(By.linkText("Test Webcam")).click();
		String mainId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		for (String id : allId) {
			if (!(mainId.equals(id))) {
				driver.switchTo().window(id);
			}
		}
		driver.findElement(By.id("webcam-launcher")).click();
	}
}
