package com.crm.vtiger.Practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata.xlsx");
		Sheet sh = WorkbookFactory.create(fis).getSheet("data");
		Row row = sh.getRow(0);
		Cell cell = row.getCell(1);
		DataFormatter df=new DataFormatter();
		String data = df.formatCellValue(cell);
		System.out.println(data);
	}

}
