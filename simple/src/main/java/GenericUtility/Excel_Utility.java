package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excel_Utility {
	public String getExcelData(String sheet,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheet4.xlsx");
        Workbook book=WorkbookFactory.create(fes);
        Sheet sh = book.getSheet(sheet);
        Row row = sh.getRow(rowNum);
        Cell cell = row.getCell(cellNum);
        String Data = cell.getStringCellValue();
        return Data;
	}
	
	public String getExcelUsingDataFormatter(String sheet,int rowNum,int celNum) throws Throwable
	{
		FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheet4.xlsx");
		Workbook book=WorkbookFactory.create(fes);
		DataFormatter format=new DataFormatter();
		String ExcelData=format.formatCellValue(book.getSheet(sheet).getRow(rowNum).getCell(celNum));
		return ExcelData;
	}
}
