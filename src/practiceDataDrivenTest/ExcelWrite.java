package practiceDataDrivenTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelWrite {
	public static void main(String[] args) throws IOException
	{
	
	
		FileInputStream f=new FileInputStream("C:\\Users\\qedge\\Desktop\\ajax.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		//Iterator<Row>row=ws.iterator();
		Row r=null;
		Cell c=null;
		r=ws.getRow(1);
		c=r.createCell(2);
		c.setCellValue("xxxxxxxxxx");
		/*c=r.getCell(2);
		String x=c.getStringCellValue();
		System.out.println("the valuse of x is:"+x);*/
		r=ws.createRow(11);
		c=r.createCell(0);
		c.setCellValue("aaaaaaaa");
		FileOutputStream f1=new FileOutputStream("C:\\Users\\qedge\\Desktop\\ajax.xlsx");
		wb.write(f1);
		f1.close();
	}
	
}

