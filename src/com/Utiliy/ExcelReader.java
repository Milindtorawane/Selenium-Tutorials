package com.Utiliy;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;



//This is the Program to read the excel 

public class ExcelReader {
	
	public static HSSFWorkbook MyWorkBook;
	public static HSSFSheet MyExcelSheet;
	public static HSSFCell Cell;
	public static HSSFRow Row;
	
	
	@Test
	public void MyExcelReader() throws Exception 
	{
		File src= new File(Constant.Filepath);
	    FileInputStream ExcelFile= new FileInputStream(src);
		MyWorkBook = new HSSFWorkbook(ExcelFile);
		MyExcelSheet=MyWorkBook.getSheetAt(0);		   
	    int RowNum=MyExcelSheet.getLastRowNum();	
		
	    System.out.println(RowNum);
	
	
	for (int colnum=0;colnum<2;colnum++){
		
	
	for(int i=0;i<RowNum;i++)
	{
	
	 String Data0 = MyExcelSheet.getRow(i).getCell(0).toString();
	 System.out.println(Data0);
	 
	 String Data1=MyExcelSheet.getRow(i).getCell(1).toString();
		
	}
	
	}
	MyWorkBook.close();
   }
	

	@Test
	public static String getData(){
		
		String CellData= MyExcelSheet.getRow(0).getCell(0).toString();
		System.out.println(CellData);
		return CellData;
				
	}
	
	

	
}
