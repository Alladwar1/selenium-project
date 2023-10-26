package com.crm.vtiger.Practice;

import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Throwable {
		PropertyFileUtility putil = new PropertyFileUtility();
		String BROWSER = putil.getPropertyFileData("Browser");
		System.out.println(BROWSER );
		JavaUtility JU=new JavaUtility();
		int random = JU.getRandom();
		System.out.println(random);
		String dt = JU.getsysdate();
		System.out.println(dt);
		String date = JU.getModifiedSysDate();
		System.out.println(date);

	}

}
