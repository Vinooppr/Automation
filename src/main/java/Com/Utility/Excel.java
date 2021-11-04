package Com.Utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel 

{

	XSSFWorkbook ExcelWBook;
	XSSFSheet ExcelWSheet;
	public Excel(String filePath)
	{
	try {

	File srcFile= new File(filePath);
	FileInputStream fis=new FileInputStream(srcFile);
	ExcelWBook=new XSSFWorkbook(fis);
	}catch (Exception exception) {
	System.out.println(exception.getMessage());
	}

	}
	public String getData(int SheetNo,int row,int cloumn )
	{

	ExcelWSheet=ExcelWBook.getSheetAt(SheetNo);

	String data=ExcelWSheet.getRow(row).getCell(cloumn).getStringCellValue();

	return data;


	}


	public int getRowCount(int sheetIndex)
	{
	int row=ExcelWBook.getSheetAt(sheetIndex).getLastRowNum();

	row=row+1;

	return row;

	}

	
	
	
	
	
}
