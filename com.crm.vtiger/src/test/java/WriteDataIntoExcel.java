

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("./testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.createSheet("Data");
		Row row = sheet.createRow(0);
		org.apache.poi.ss.usermodel.Cell cell = row.createCell(0);
		cell.setCellValue("username");
		FileOutputStream fos = new FileOutputStream("./testdata.xlsx");
		wb.write(fos);
		System.out.println("DataAdded");

	}

}
