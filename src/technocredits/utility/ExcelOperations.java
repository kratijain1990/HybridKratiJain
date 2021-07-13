package technocredits.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import technocredits.constant.ConstantPath;

public class ExcelOperations {
	
	public static void main(String[] args) throws IOException {
	//public static Object[][] excelReading(String workbookName, String sheetName) throws IOException {
		File file = new File(ConstantPath.TESTDATA+"TestDataOrangeHRM.xlsx");
		//File file = new File(ConstantPath.TESTDATA + workbookName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputStream);
		Sheet sheet = wb.getSheet("LoginCreds");
		int totalRows = sheet.getLastRowNum() + 1;
		int totalColumns = sheet.getRow(0).getLastCellNum();

		//System.out.println(totalRows);
		//System.out.println(totalColumns);

		Object[][] obj = new Object[totalRows][totalColumns];

		for (int rowNum = 1; rowNum < totalRows; rowNum++) { //4
			for (int colNum = 0; colNum < totalColumns; colNum++) { //2
				try {
					obj[rowNum-1][colNum] = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
				} catch (Exception e) {
					obj[rowNum-1][colNum] = "";
				}
				System.out.print(obj[rowNum-1][colNum] + "  ");
			}
			System.out.println();
		}
		wb.close();
		//return obj;
	}
}
