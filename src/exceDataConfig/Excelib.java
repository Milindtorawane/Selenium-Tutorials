package exceDataConfig;




import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.Test;

//This is the Program to read the excel 

public class Excelib {




	public HSSFWorkbook MyWorkBook;
	public HSSFSheet MyExcelSheet;
	public HSSFCell Cell;
	public HSSFRow Row;


	@Test
	public void SetExcel(String Excelpath) throws IOException
	{
		File src= new File(Excelpath);
		FileInputStream ExcelFile= new FileInputStream(src);
		MyWorkBook = new HSSFWorkbook(ExcelFile);
		MyExcelSheet=MyWorkBook.getSheetAt(0);	
		System.out.println("Excel set successfully");
	}

	@Test
	public String getData(int RowNum,int ColNum){



		Cell CellData= MyExcelSheet.getRow(RowNum).getCell(ColNum);
		DataFormatter formatter = new DataFormatter();
		String CellData1 = formatter.formatCellValue(CellData);


		///System.out.println(CellData);
		return CellData1;

	}

	@Test
	public int getRowCount() throws Exception{

		int RowNum=MyExcelSheet.getLastRowNum();
		System.out.println(RowNum);
		return RowNum;
	}





	@Test 
	public void TearDown() throws IOException{
		MyWorkBook.close();
	}

	public int geCellCount() {
		
		int col=MyExcelSheet.getRow(0).getLastCellNum();
		return col;
				
	}
}






