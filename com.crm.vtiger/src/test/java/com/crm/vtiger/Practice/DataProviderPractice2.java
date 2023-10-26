package com.crm.vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice2 {
	@DataProvider()
	public Object[][] data(){
		Object data[][]=new Object[3][3];
		 data[0][0]="apple";
		 data[0][1]=100000;
		 data[0][2]="5 star";
		 
		 data[1][0]="samsung";
		 data[1][1]=50000;
		 data[1][2]="4 star";
		 
		 data[2][0]="realme";
		 data[2][1]=20000;
		 data[2][2]="3.5 star";
		return data;
	}
	@Test(dataProvider="data")
	public void create(String moblie,int price,String rating) {
		System.out.println(moblie+" "+price+" "+rating);
	}

}
