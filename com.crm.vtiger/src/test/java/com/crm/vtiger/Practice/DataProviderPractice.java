package com.crm.vtiger.Practice;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@DataProvider
	public Object[][]data() {
		Object data[][]=new Object[2][2];
		data[0][0]="samsung";
		data[0][1]=15000;
		
		data[1][0]="Nokia";
		data[1][1]=20000;
		
		return data;
		
	}
@Test(dataProvider="data")

public void create(String moblie,int price) {
	System.out.println(moblie+" "+price);
}
}
