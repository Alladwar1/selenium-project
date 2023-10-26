package com.crm.vtiger.organisation;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.ObjectRepositary.ContactPage;
import com.crm.vtiger.ObjectRepositary.CreateNewOrganizationPage;
import com.crm.vtiger.ObjectRepositary.HomePage;
import com.crm.vtiger.ObjectRepositary.LoginPage;
import com.crm.vtiger.ObjectRepositary.OrganizationInfoPage;
import com.crm.vtiger.ObjectRepositary.OrganizationPage;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;
@Listeners(GenericUtility.ListnerImplementation.class)

public class CreateOgranisationTestByUsingTestNG extends BaseClass{
	@Test(groups= {"smoke","regression"},retryAnalyzer = GenericUtility.RetryAnalyser.class)
	public void verifyUserCreateOgranisation() throws Throwable {
		
		String com = eutil.getDataFromExcel("Data", 1, 0) + jutil.getRandom();
		HomePage hp = new HomePage(driver);
		hp.clickorgLink();
		Reporter.log("contact link clicked",true);
		
		ContactPage cp=new ContactPage(driver);
		cp.clickContactLookup();
		Reporter.log("contact lookup clicked",true);
		
		OrganizationPage orgp=new OrganizationPage(driver);
		orgp.clickorgLookUp();
		//Assert.fail();
		
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createOrg(com);
		
		OrganizationInfoPage orip=new OrganizationInfoPage(driver);
		String comname= orip.getcreatedorgname();
				
		Assert.assertTrue(comname.contains(com));
		System.out.println("pass");

	}

}
