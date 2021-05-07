package com.crm.vtiger.generics;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Abhi
 *
 */

public class ExcelUtility 
{
	public void getExcelData(String sheetName, int rownum, int cellnum ) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_FILEPATH);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		cell.getStringCellValue();
	}
	
	public Object[][] getExcelData(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_FILEPATH);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		int lastCell = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[lastRow][lastCell];
		for(int i=0; i<lastRow; i++)
		{
			for(int j=0; j<lastCell; j++)
			{
				data[i][j]= sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
	public String getExcelData(String sheetName, String tc_ID, String headerValue) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_FILEPATH);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		int expectedRow = 0;
		for(int i=0; i<=lastRow; i++)
		{
			String testCaseId = sheet.getRow(i).getCell(0).getStringCellValue();
			if(testCaseId.equalsIgnoreCase(tc_ID))
			{
				expectedRow=i;
				break;
			}
		}
		expectedRow--;
		int expectedColumn=0;
		int lastCell = sheet.getRow(expectedRow).getLastCellNum();
		for(int j=0; j<lastCell; j++)
		{
			String value = sheet.getRow(expectedRow).getCell(j).getStringCellValue();
			if(value.equalsIgnoreCase(headerValue))
			{
				expectedColumn=j;
				break;
			}
		}
		  return sheet.getRow(expectedRow+1).getCell(expectedColumn).getStringCellValue();
	 }
		
}
