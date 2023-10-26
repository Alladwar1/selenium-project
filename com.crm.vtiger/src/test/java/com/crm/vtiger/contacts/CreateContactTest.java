package com.crm.vtiger.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.ObjectRepositary.ContactInformationPage;
import com.crm.vtiger.ObjectRepositary.ContactPage;
import com.crm.vtiger.ObjectRepositary.CreatingNewContactPage;
import com.crm.vtiger.ObjectRepositary.HomePage;

import GenericUtility.BaseClass;
import GenericUtility.JavaUtility;

public class CreateContactTest extends BaseClass{
	@Test
	public void verifyUserCreateContact()throws Throwable {
		/*WebDriver driver = null;
		PropertyFileUtility putil = new PropertyFileUtility();
		String UN = putil.getPropertyFileData("username");
		String PW = putil.getPropertyFileData("password");
		String URL = putil.getPropertyFileData("URL");*/
		JavaUtility JU = new JavaUtility();
		String lastName = "Kundu" + JU.getRandom();
		/*driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		//driver.findElement(By.name("user_name")).sendKeys(UN);
		//driver.findElement(By.name("user_password")).sendKeys(PW);
		//driver.findElement(By.id("submitButton")).click();
		
		
		LoginPage lp = new LoginPage(driver);
		lp.login(UN, PW);
		*/
		HomePage hp = new HomePage(driver);
		hp.clickcontact();

		ContactPage cp=new ContactPage(driver);
		cp.clickContactLookup();
		
		CreatingNewContactPage crnc= new CreatingNewContactPage(driver);
		crnc.clickcreatecontact(lastName);
		
		ContactInformationPage cip=new ContactInformationPage(driver);
		String ContactInformation = cip.getcreatedcontact();
		//driver.findElement(By.linkText("Contacts")).click();
		//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//driver.findElement(By.name("lastName")).sendKeys(lastName);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//String LName = driver.findElement(By.cssSelector(".dvHeaderText")).getText();
		/*if (ContactInformation.contains(lastName)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}*/
		
		Assert.assertTrue(ContactInformation.contains(lastName));

		System.out.println("pass");
		
		/*WebElement logout = driver.findElement(By.xpath(".//img[@src='themes/softed/images/user.PNG']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();*/
		hp.logout(driver);
		driver.quit();
	}
}
