package com.crm.vtiger.organisation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.ObjectRepositary.CreateNewOrganizationPage;
import com.crm.vtiger.ObjectRepositary.HomePage;
import com.crm.vtiger.ObjectRepositary.OrganizationInfoPage;
import com.crm.vtiger.ObjectRepositary.OrganizationPage;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;

public class CreateMultipleorgTest extends BaseClass {


	@Test(dataProvider ="getMultipleRowObjects",dataProviderClass = ExcelFileUtility.class)
	public void verifyusercreatemultipleOrgtest(String organizationName) {
		String orgName = organizationName+jutil.getRandom();
		
		HomePage hp=new HomePage(driver);
		hp.clickorgLink();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.clickorgLookUp();
		
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		
		OrganizationInfoPage oip =new OrganizationInfoPage(driver);
		String orgHeader = oip.getcreatedorgname();
		
		Assert.assertTrue(orgHeader.contains(orgName));
		System.out.println("pass");
		
		
	}

}
