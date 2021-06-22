package dataprovider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataproviderexcel {
	
	public static Object[][] getdatafromExcel() throws IOException {
	//public static void main(String str[]) throws IOException{
	
		
		String path = ".\\payload\\datasetAssignment.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		int totalrows = sheet.getLastRowNum();
		Row row= sheet.getRow(1);
		int totalcolumns = row.getLastCellNum();
		totalrows= totalrows+1;
		
		System.out.println("total rows = " + totalrows);
		System.out.println("total columns = " + totalcolumns);
		
		Object[][] data = new Object[totalrows][totalcolumns];
		
		for(int i=0; i < totalrows; i++)
		{
			for (int j=0; j < totalcolumns; j++)
			{
				try
				{
					data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println(data[i][j]);
				}
				catch(NullPointerException ex)
				{
					
					System.out.println(ex.getMessage());
				}
				
			}
			
		}
		wb.close();
		return data;	
		
		
	
		
	}

}

