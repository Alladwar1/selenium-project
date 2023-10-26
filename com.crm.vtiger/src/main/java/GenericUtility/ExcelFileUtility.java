package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consist of generic method to fetch data from excel file
 * @author radhi
 *
 */
import org.testng.annotations.DataProvider;
public class ExcelFileUtility {
	/**
	 * This method help us to fetch data from Excel file
	 * @param sheetname
	 * @param rownumber
	 * @param cellno
	 * @param Value
	 * @throws Throwable
	 */

	public void writeDataIntoExcel(String sheetname, int rownumber, int cellno, String Value) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).createRow(rownumber).createCell(cellno).setCellValue(Value);
		FileOutputStream fos = new FileOutputStream(IpathConstant.excelfilepath);
		wb.write(fos);
	}

	public String getDataFromExcel(String sheetname, int rownumber, int cellno) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		String Value = wb.getSheet(sheetname).getRow(rownumber).getCell(cellno).getStringCellValue();
		return Value;
		
	}
	@DataProvider
	public Object[] []getMultipleRowObjects() throws Throwable{
		FileInputStream fis=new FileInputStream(IpathConstant.excelfilepath);
		Sheet sh = WorkbookFactory.create(fis).getSheet("Dataprovider");
		 int lastrow = sh.getLastRowNum();
		 int lastcell = sh.getRow(0).getLastCellNum();
		 Object data[][]=new Object[lastrow][lastcell];
		 DataFormatter df=new DataFormatter();
		 for(int i=0;i<lastrow;i++) {
			 for(int j=0;j<lastcell;j++) {
				 data[i][j]=df.formatCellValue(sh.getRow(i).getCell(j));
			 }
		 }
return data;	
	}
	

}
