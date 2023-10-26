/**
 * 
 */
package com.crm.vtiger.Practice;

import org.testng.annotations.Test;

public class GetDataFromAnotherClass {
	@Test(dataProvider = "data",dataProviderClass=DataProviderPractice2.class)
	public void get(String mobile,int price,String rating) {
		System.out.println(mobile+" "+price+" "+rating);
	}

}
